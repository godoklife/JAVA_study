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
import javafx.scene.control.Alert.AlertType;

public class Signuppane implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");	// �������� �� lblconfirm�� ����ڰ� ���� ���ϰ� ����ó��
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
    	boolean result2 = MemberDao.memberDao.idcheck(id);
    	if(result2) {
    		lblconfirm.setText("�̹� ������� ���̵� �Դϴ�.");
    		return;
    	}
    		// 2. id ���� üũ
    	if(id.length() < 4 || id.length() > 10) {
    		lblconfirm.setText("���̵�� 4~10�� �̳����� �մϴ�.");
    		return;
    	}
    		// 3. ��й�ȿ ���� üũ
    	if(password.length()<4 || password.length() > 10 ) {	// ����� 4���� �̸�, 10���� �ʰ���
    		lblconfirm.setText("��й�ȣ�� 4~10�� �̳����� �մϴ�.");
    		return;
    	}
    		// 4. ��й�ȣ ��ġ üũ
    	if( ! password.equals(passwordconfirm)) {	// �н������ϰ� �н����������ϰ� ��ġ���� ������
    		lblconfirm.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
    		return;
    	}
    		// 5. �̸���
    	if(email.indexOf("@")==-1 ) {	// indexOf("@") : ����̰� ���ڿ��� ������ -1 ����, ������ �ε����� ����
    		lblconfirm.setText("�̸��� ������ Ȯ���ϼ���.");
    		return;
    	}
    		// 6. �ּ�
    	if( ! (address.contains("��")&& address.contains("��")) ) {	// .contains("��") : "��" �� ������ true ��ȯ
    		lblconfirm.setText("��, ���� ������ �ּҸ� �Է��ϼ���.");
    		return;
    	}
    	// * ��� ��ȿ�� �˻� ��� �� ��üȭ �� DB�� ����.
    		// 1. ��üȭ [ ȸ����ȣ ����, id, pw, email, address, ����Ʈ ����, ������)
    	Member member = new Member(0, id, passwordconfirm, email, address, 0, since);
    		// 2. DB ��ü �� �޼��� ȣ��
    	boolean result = MemberDao.memberDao.signup(member);
    		// 3. Ȯ��
    	if (result) {
    		// 1) �޽��� â ���
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("�˸�");	// �޽��� ���� ����
    		alert.setHeaderText("�Ȼ�� �߰�ŷ��� ������ ȯ���մϴ�.");
    		alert.setTitle("���Լ���");
    		alert.showAndWait();
    		// 2) ȭ�� ��ȯ
    		Login.���ΰ�ü.loadpage("/view/login/loginpane.fxml");
    		
    	}else {
    		lblconfirm.setText("����! �����ڿ��� ����");
    		return;
    	}
    		
    	
    }
	
}
