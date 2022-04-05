package controller.board;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.BoardDao;
import dto.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private TableView<?> replytable;

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

    }

    @FXML
    void accupdate(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
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
