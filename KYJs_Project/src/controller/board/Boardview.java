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
    	
    	// 1. ��� �޽��� ���
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("���!");
    	alert.setHeaderText("���� ���� �����Ͻðڽ��ϱ�?");
    	Optional<ButtonType> optional =  alert.showAndWait();	// showAndWait() �޼����� ��ȯ Ÿ�� -> ������ ��ư
    	
    	// 2. Ȯ�� ��ư ������
    	if(optional.get() == ButtonType.OK) {
    		// 3. ���� ����
    		boolean result = BoardDao.boardDao.delete(controller.board.Board.board.getBnum());
    		if (result) {
    			alert.setAlertType(AlertType.INFORMATION);
    			alert.setHeaderText("����ó���Ǿ����ϴ�.");
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
    	
    	Board board = controller.board.Board.board;	// board ��Ʈ�� �� ���̺��� ���õ� ��ü ȣ��
    		// (dto.Board)
    	
    	// �� ��Ʈ�ѿ� ���õ� board�� �����͸� �̾ƿͼ� �ѷ��ֱ�.
    	lblwriter.setText("�ۼ��� : "+board.getBwrite());
    	lbldate.setText("�ۼ��� : "+board.getBdate());
    	lblview.setText("��ȸ�� : "+board.getBview());
    	txttitle.setText(board.getBtitle());
    	txtcontent.setText(board.getBcontent());
    	
    	// ���� �Խù� �ۼ��ڿ� ���� �α��� �� ����� ���� �ʴٸ� ����&���� ��ư �����
    	if( ! board.getBwrite().equals(Login.member.getMid())) {
    		btndelete.setVisible(false);
    		btnupdate.setVisible(false);
    	}
    	// ����� ����κ� ���� ���ϰ� �����ϴ� �κ�.
    	txttitle.setEditable(false);
    	txtcontent.setEditable(false);
    }
	
}
