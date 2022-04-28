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
    
    // ���� ���̺� ��� �޼���
    public void replytableshow() {
    	
    	
    	// 1. ���� �Խù� ��ȣ ����
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
    	String rcontent = txtrecontent.getText();
    	String rwrite = Login.member.getMid();
    	int bnum = controller.board.Board.board.getBnum();
    	Reply reply = new Reply(0, rcontent, rwrite, null, bnum);
    	BoardDao.boardDao.rwrite(reply);
    	replytableshow();
    }
    
    boolean updatecheck = true;	// ���� ��ư ����ġ ����
    @FXML
    void accupdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(updatecheck) {	// ���� ����
	    	alert.setHeaderText("�Խñ� ���� �� �Ϸ� ��ư�� �����ּ���.");
	    	alert.showAndWait();
	    	
	    	// ����ִ� ����� ������ ���������ϰ� Ǯ����.
	    	txttitle.setEditable(true);
	    	txtcontent.setEditable(true);
	    	btnupdate.setText("�����Ϸ�");
	    	updatecheck=false;
	    	
    	}else {	// ���� �Ϸ�
    		// dbó��
    		
    		if((txttitle.getText()=="" || txtcontent.getText()=="")) {
        		alert.setHeaderText("�����̳� ������ ������ϴ�.");
        		alert.showAndWait();
        		return;
        	}else {
    		
	    		BoardDao.boardDao.update(controller.board.Board.board.getBnum(), txttitle.getText(), txtcontent.getText());
	    		
	    		alert.setHeaderText("������ �Ϸ�Ǿ����ϴ�.");
	    		alert.showAndWait();
	    		txttitle.setEditable(false);
		    	txtcontent.setEditable(false);
		    	btnupdate.setText("����");
		    	updatecheck=true;
	    	}
    	}
    }
    
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	replytableshow();
    	Board board = controller.board.Board.board;	// board ��Ʈ�� �� ���̺��� ���õ� ��ü ȣ��
    			
    	if ( !(BoardDao.boardDao.nullreplycheck( Login.member.getMid(), board.getBnum() ) ) ) {
    		BoardDao.boardDao.viewcountup(board.getBview()+1, board.getBnum());	// DB�� ��ȸ�� 1 �÷��ֱ�
    		board.setBview(board.getBview()+1);	// ��ü �� �޸𸮿� ��ȸ�� 1 �÷��ֱ�
    		Reply writeNullReply = new Reply(0, null, Login.member.getMid(), null, board.getBnum());	// null����(=�÷��� ����) �ۼ��ϱ� ���� ��üȭ
    		BoardDao.boardDao.rwrite(writeNullReply);	// ���� �ۼ�
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText(Login.member.getMid()+"���� "+board.getBtitle()+" ���� ���� ó�� ��ȸ�ϼ̽��ϴ�.");
    		alert.showAndWait();
    	}
    	
    	lblwriter.setText("�ۼ��� : "+board.getBwrite());
    	lbldate.setText("�ۼ��� : "+board.getBdate());
    	lblview.setText("��ȸ�� : "+board.getBview());
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
