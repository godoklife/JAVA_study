package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Findpassword implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

    @FXML
    private TextField txtid;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("�ڷΰ��� ��ư ����");
    	Login.���ΰ�ü.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void findpassword(ActionEvent event) {
    	String id = txtid.getText();
    	String email = txtemail.getText();
    	String findpw = MemberDao.memberDao.findpassword(id, email);
    	if(findpw!=null) {
    		Member.sendmail(email, findpw);	// �̸��Ϸ� ����
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("�Է��Ͻ� ������ ��й�ȣ�� ����Ͻ� �̸��Ϸ� ���۵Ǿ����ϴ�.");
    		alert.showAndWait();
    	}else {	// ���Ϲ޴� ���� null�̸�
    		lblconfirm.setText("��ġ�ϴ� ������ �����ϴ�.");
    	}
    }

}
