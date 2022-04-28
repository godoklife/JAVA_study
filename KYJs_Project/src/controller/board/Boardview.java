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
    	BoardDao.boardDao.rwrite(reply);
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
    		
    		if((txttitle.getText()=="" || txtcontent.getText()=="")) {
        		alert.setHeaderText("제목이나 내용이 비었습니다.");
        		alert.showAndWait();
        		return;
        	}else {
    		
	    		BoardDao.boardDao.update(controller.board.Board.board.getBnum(), txttitle.getText(), txtcontent.getText());
	    		
	    		alert.setHeaderText("수정이 완료되었습니다.");
	    		alert.showAndWait();
	    		txttitle.setEditable(false);
		    	txtcontent.setEditable(false);
		    	btnupdate.setText("수정");
		    	updatecheck=true;
	    	}
    	}
    }
    
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	replytableshow();
    	Board board = controller.board.Board.board;	// board 컨트롤 내 테이블에서 선택된 객체 호출
    			
    	if ( !(BoardDao.boardDao.nullreplycheck( Login.member.getMid(), board.getBnum() ) ) ) {
    		BoardDao.boardDao.viewcountup(board.getBview()+1, board.getBnum());	// DB에 조회수 1 올려주기
    		board.setBview(board.getBview()+1);	// 객체 내 메모리에 조회수 1 올려주기
    		Reply writeNullReply = new Reply(0, null, Login.member.getMid(), null, board.getBnum());	// null리플(=플래그 역할) 작성하기 위해 객체화
    		BoardDao.boardDao.rwrite(writeNullReply);	// 리플 작성
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText(Login.member.getMid()+"님은 "+board.getBtitle()+" 글을 오늘 처음 조회하셨습니다.");
    		alert.showAndWait();
    	}
    	
    	lblwriter.setText("작성자 : "+board.getBwrite());
    	lbldate.setText("작성일 : "+board.getBdate());
    	lblview.setText("조회수 : "+board.getBview());
    	txttitle.setText(board.getBtitle());
    	txtcontent.setText(board.getBcontent());
    	
    	if( ! board.getBwrite().equals(Login.member.getMid())) {
    		btndelete.setVisible(false);
    		btnupdate.setVisible(false);
    	}
    	
    	txttitle.setEditable(false);
    	txtcontent.setEditable(false);
    }
	
}
