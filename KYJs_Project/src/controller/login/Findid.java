package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Findid implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	   @FXML
	    private TextField txtemail;

	    @FXML
	    private Button btnfindid;

	    @FXML
	    private Button btnback;

	    @FXML
	    private Label lblconfirm;

	    @FXML
	    void back(ActionEvent event) {
	    	System.out.println("�ڷΰ��� ��ư ����");
	    	Login.���ΰ�ü.loadpage("/view/login/loginpane.fxml");
	    }

    @FXML
    void findid(ActionEvent event) {
    	// 1. ��Ʈ�ѿ� �Էõ� �̸��� ��������
    	String email = txtemail.getText();
    	String id = MemberDao.memberDao.findid(email);
    	if(id!=null) {	// id�� null�� �ƴϸ�?
    		// 1. �޼��� ���
    		Alert alert = new Alert(AlertType.INFORMATION);	
    			// Alert�� ���¸� information���� ���� �� �޸� ����
    		alert.setHeaderText("����� ���̵��"+id);
    		alert.showAndWait();
    		
    	}else{	// id�� null�̸�?
    		lblconfirm.setText("�ش� �̸����� ���̵� �������� �ʽ��ϴ�.");
    	}
    	
    }
	
}
