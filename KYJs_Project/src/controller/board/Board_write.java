package controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.BoardDao;
import dto.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Board_write implements Initializable{

    @FXML
    private Button btnwrite;

    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btnback;

    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/board/board.fxml");
    }

    @FXML
    void accwrite(ActionEvent event) {
    	// 1. 컨트롤에 입력된 데이타 가져오기
    	String title = txttitle.getText();
    	String content = txtcontent.getText();
    	String write = Login.member.getMid();
    	if(title==null || content==null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("제목이나 내용이 비었습니다.");
    		alert.showAndWait();
    		Home.home.loadpage("/view/board/board.fxml");
    	}
    	// 2. 객체화 [ 글 번호(DB에서 자동추가=생략, 제목, 내용, 작성자, 작성일(DB에서 자동추가=생략), 조회수(자동추가=생략)
    	Board board = new Board(0, title, content, write, null, 0);
    	// 3. DB에 저장
    	boolean result = BoardDao.boardDao.write(board);
    	
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("작성이 완료되었습니다.");
    		alert.showAndWait();
    		Home.home.loadpage("/view/board/board.fxml");
    	}
    	
    }
	
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }
    
}
