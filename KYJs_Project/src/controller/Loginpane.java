package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class Loginpane implements Initializable{
	
	@FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnfindid;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Label lblconfirm;

    @FXML
    void accfindid(ActionEvent event) {
    	System.out.println("���̵� ã�� ������ ��ư");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	System.out.println("��й�ȣ ã�� ������ ��ư");

    }

    @FXML
    void acclogin(ActionEvent event) {
    	System.out.println("�α���ó��");
    	
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("ȸ������ �������� �̵�.");
    	// ȸ������ ��ư�� ������ login ��Ʈ�� Ŭ���� �� borderpane �����̳� center ������ ����.
    	// problem -> �ٸ� Ŭ���� �� �����̳� ȣ�� -> Login login = new Login(); ���� ���ο� �����̳ʰ� �������. XX
    	// answer -> ���� �����̳ʸ� �������� ��� -> Login Ŭ������ 18�����κ��� 27������ ����
    	Login.���ΰ�ü.loadpage("/view/signuppane.fxml");
    	
//    	login.loadpage("/view/signuppage.fxml");
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
