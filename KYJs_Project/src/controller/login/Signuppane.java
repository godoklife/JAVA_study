package controller.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class Signuppane implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnsignup;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private PasswordField txtpasswordconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtaddress;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("�ڷΰ��� ��ư ����");
    	Login.���ΰ�ü.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void signup(ActionEvent event) {
    	// ��Ʈ�ѿ� �Էµ� ������ ��������
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	String passwordconfirm = txtpasswordconfirm.getText();
    	String email = txtemail.getText();
    	String address = txtaddress.getText();
    	
    	// ���� ��¥ �������� [ SimpleDateFormat : ��¥ ���(����) ��ȯ Ŭ���� ] 
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String since = format.format(new Date());	// ���� ��¥�� String������ ������� ���� �� ����
    	
    	// ��ȿ�� �˻�
    		// 1. id �ߺ� üũ
    		// 2. id ���� üũ
    		// 3. ��й�ȿ ���� üũ
    		// 4. ��й�ȣ ��ġ üũ
    		// 5. �̸���
    		// 6. �ּ�
    	// * ��� ��ȿ�� �˻� ��� �� ��üȭ �� DB�� ����.
    		// 1. ��üȭ [ ȸ����ȣ ����, id, pw, email, address, ����Ʈ ����, ������)
    	Member member = new Member(0, id, passwordconfirm, email, address, 0, since);
    	boolean result = MemberDao.memberDao.signup(member);
    	
    	if (result) {
    		System.out.println("���� ����");
    	}else {
    		System.out.println("���� ����");
    	}
    		
    	
    }
	
}
