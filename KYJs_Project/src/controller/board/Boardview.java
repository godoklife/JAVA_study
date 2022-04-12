package controller.board;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.BoardDao;
import dto.Board;
import dto.Reply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Boardview implements Initializable{

    @FXML
    private Button btnback;

    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnrewrite;

    @FXML
    private Label lblwriter;

    @FXML
    private Label lbldate;

    @FXML
    private TextArea txtrecontent;

    @FXML
    private TableView<Reply> replytable;
    
    // 덧글 테이블 출력 메서드
    public void replytableshow() {
    	
    	
    	// 1. 현재 게시물 번호 저장
    	int bnum = controller.board.Board.board.getBnum();
    	// 2.
    	ObservableList<Reply> replylist = BoardDao.boardDao.replylist(bnum);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    	
    	// 날짜용 임시 객체		// 보드 클래스로 이동할것.
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String nowdate = format.format(new Date());
    	boolean viewcounttmp=false;
    	boolean iscountchanged=false;
    	int i=0;	// index
    	for(Reply tmp : replylist) {
    		viewcounttmp=true;

    		System.out.println("for문 진입");
    		System.out.println(tmp.getRdate().split(" ")[0]);
    		
    		// 리플에 내용이 null인 리플의 작성날짜와 작성자를 기준으로 글의 조회수를 올림.
    		if( !( tmp.getRdate().split(" ")[0].equals(nowdate) && tmp.getRwrite().equals(Login.member.getMid()) ) ) {
    			System.out.println("if문 진입");
    			BoardDao.boardDao.viewcountup(controller.board.Board.board.getBview()+1, bnum);	// 게시글 조회수 1 추가해서 DB에 저장
    			Reply reply = new Reply(0, null, Login.member.getMid(), null, bnum); // 리플 DB에 내용이 일정하고 글쓴이가 로그인한 사용자인 리플을 저장
    				// 목적 ?? 조회수 체크용
    			BoardDao.boardDao.rwrite(reply);
    		}
    		if(tmp.getRcontent()==null) {
    			iscountchanged=true;
    			replylist.remove(i);
    		}
    		i++;
    	}
    	if (viewcounttmp==false) {
    		iscountchanged=true;
    		BoardDao.boardDao.viewcountup(controller.board.Board.board.getBview()+1, bnum);
			Reply reply = new Reply(0, null, Login.member.getMid(), null, bnum); // 리플 DB에 내용이 일정하고 글쓴이가 로그인한 사용자인 리플을 저장
			BoardDao.boardDao.rwrite(reply);
    	}
//    	if (iscountchanged)
//    		replylist = BoardDao.boardDao.replylist(bnum);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    	
    	// 3. 
    	TableColumn tc = replytable.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rnum"));
    	
    	tc = replytable.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rwrite"));
    	
    	tc = replytable.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rdate"));
    	
    	tc = replytable.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("rcontent"));
    	
    	replytable.setItems(replylist);
    }

    @FXML
    private Label lblview;

    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/board/board.fxml");
    }

    @FXML
    void accdelete(ActionEvent event) {
    	
    	// 1. 경고 메시지 출력
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("경고!");
    	alert.setHeaderText("정말 글을 삭제하시겠습니까?");
    	Optional<ButtonType> optional =  alert.showAndWait();	// showAndWait() 메서드의 반환 타입 -> 선택한 버튼
    	
    	// 2. 확인 버튼 누르면
    	if(optional.get() == ButtonType.OK) {
    		// 3. 삭제 실행
    		boolean result = BoardDao.boardDao.delete(controller.board.Board.board.getBnum());
    		if (result) {
    			alert.setAlertType(AlertType.INFORMATION);
    			alert.setHeaderText("삭제처리되었습니다.");
    			alert.showAndWait();
    	    	Home.home.loadpage("/view/board/board.fxml");
    		}
    	}
    	
    	
    }

    @FXML
    void accrewrite(ActionEvent event) {
    	String rcontent = txtrecontent.getText();
    	String rwrite = Login.member.getMid();
    	int bnum = controller.board.Board.board.getBnum();
    	Reply reply = new Reply(0, rcontent, rwrite, null, bnum);
    	boolean result = BoardDao.boardDao.rwrite(reply);
    	replytableshow();
    }
    
    boolean updatecheck = true;	// 수정 버튼 스위치 변수
    @FXML
    void accupdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(updatecheck) {	// 수정 시작
	    	alert.setHeaderText("게시글 수정 후 완료 버튼을 눌러주세요.");
	    	alert.showAndWait();
	    	
	    	// 잠겨있던 제목과 내용을 수정가능하게 풀어줌.
	    	txttitle.setEditable(true);
	    	txtcontent.setEditable(true);
	    	btnupdate.setText("수정완료");
	    	updatecheck=false;
	    	
    	}else {	// 수정 완료
    		// db처리
    		BoardDao.boardDao.update(controller.board.Board.board.getBnum(), txttitle.getText(), txtcontent.getText());
    		
    		alert.setHeaderText("수정이 완료되었습니다.");
    		alert.showAndWait();
    		txttitle.setEditable(false);
	    	txtcontent.setEditable(false);
	    	btnupdate.setText("수정");
	    	updatecheck=true;
    	}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	replytableshow();
    	Board board = controller.board.Board.board;	// board 컨트롤 내 테이블에서 선택된 객체 호출
    		// (dto.Board)
    	
    	// 각 컨트롤에 선택된 board의 데이터를 뽑아와서 뿌려주기.
    	lblwriter.setText("작성자 : "+board.getBwrite());
    	lbldate.setText("작성일 : "+board.getBdate());
    	lblview.setText("조회수 : "+board.getBview());
    	txttitle.setText(board.getBtitle());
    	txtcontent.setText(board.getBcontent());
    	
    	// 만약 게시물 작성자와 현재 로그인 산 사람이 같지 않다면 수정&삭제 버튼 숨기기
    	if( ! board.getBwrite().equals(Login.member.getMid())) {
    		btndelete.setVisible(false);
    		btnupdate.setVisible(false);
    	}
    	// 제목과 내용부분 수정 못하게 설정하는 부분.
    	txttitle.setEditable(false);
    	txtcontent.setEditable(false);
    }
	
}
