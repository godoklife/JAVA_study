package controller.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import controller.Main;
import dao.MemberDao;
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
    	Login.���ΰ�ü.loadpage("/view/login/findid.fxml");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	System.out.println("��й�ȣ ã�� ������ ��ư");
    	Login.���ΰ�ü.loadpage("/view/login/findpassword.fxml");
    }

    @FXML
    void acclogin(ActionEvent event) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String nowdate = format.format(new Date());
    	System.out.println("if�� �� nowdate : "+nowdate);
    	// 1. ��Ʈ�ѿ� �Էµ� �� ��������
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	
    	boolean result = MemberDao.memberDao.login(id, password);
    	
    	if(result) {
    		// �α��� ������ ������ ȸ������ ����. [ �α׾ƿ� �� �ʱ�ȭ ] 
    		Login.member = MemberDao.memberDao.getmember(id);
/////////////////////////////////////////////    		���� ù �α��ν� 10����Ʈ ����. ���� ��ġ �ٲ����.
    		if(!nowdate.equals(Login.member.getLastlogindate())) {
    			System.out.println("��ü �� ��¥ : "+Login.member.getLastlogindate());
    			System.out.println("nowdate : "+nowdate);
    			int tmpPoint = Login.member.getMpoint()+10;
    			MemberDao.memberDao.updatepoint(Login.member.getMnum(), tmpPoint, nowdate);
    		}
/////////////////////////////////////////////    		
    		
    		lblconfirm.setText("�α��� ����");
    		Main.instance.loadpage("/view/home/home.fxml");
    	}else {
    		lblconfirm.setText("���̵�� ��й�ȣ�� Ȯ���ϼ���");
    	}
    	
    	
//    	System.out.println(txtid.getText() + "�� ���̵�� �ԷµǾ����ϴ�.");
//    	System.out.println(txtpassword.getText() + "�� �н����尡 �ԷµǾ����ϴ�.");
    	
    	System.out.println("�α���ó��");
    	
    	
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("ȸ������ �������� �̵�.");
    	// ȸ������ ��ư�� ������ login ��Ʈ�� Ŭ���� �� borderpane �����̳� center ������ ����.
    	// problem -> �ٸ� Ŭ���� �� �����̳� ȣ�� -> Login login = new Login(); ���� ���ο� �����̳ʰ� �������. XX
    	// answer -> ���� �����̳ʸ� �������� ��� -> Login Ŭ������ 18�����κ��� 27������ ����
    	Login.���ΰ�ü.loadpage("/view/login/signuppane.fxml");
    	
//    	login.loadpage("/view/signuppage.fxml");
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
