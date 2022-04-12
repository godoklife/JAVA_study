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
    	// 1. ��Ʈ�ѿ� �Էµ� ����Ÿ ��������
    	String title = txttitle.getText();
    	String content = txtcontent.getText();
    	String write = Login.member.getMid();
    	if(title==null || content==null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("�����̳� ������ ������ϴ�.");
    		alert.showAndWait();
    		Home.home.loadpage("/view/board/board.fxml");
    	}
    	// 2. ��üȭ [ �� ��ȣ(DB���� �ڵ��߰�=����, ����, ����, �ۼ���, �ۼ���(DB���� �ڵ��߰�=����), ��ȸ��(�ڵ��߰�=����)
    	Board board = new Board(0, title, content, write, null, 0);
    	// 3. DB�� ����
    	boolean result = BoardDao.boardDao.write(board);
    	
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("�ۼ��� �Ϸ�Ǿ����ϴ�.");
    		alert.showAndWait();
    		Home.home.loadpage("/view/board/board.fxml");
    	}
    	
    }
	
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }
    
}
