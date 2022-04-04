package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Update implements Initializable{
	
	
	
	@FXML
	private TextField txtemail;
	@FXML
	private TextField txtaddress;
	@FXML
	private Button btnupdate;
	@FXML
	public void confirm(ActionEvent e){	//  ��ư Ŭ���� ActionEvent ��.
		// 1. ��Ʈ�ѷ��� �Է��� �ĵ����� ��������
		String email = txtemail.getText();
		String address = txtaddress.getText();
		// 2. ������Ʈ ó�� [ ȸ����ȣ�� �α��ν� Login.member �޸𸮿� �ö� ����!! ] 
		boolean result = MemberDao.memberDao.update(Login.member.getMnum(), email, address);
		if(result) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("ȸ�������� �����Ǿ����ϴ�. �ٽ� �α��� �� �ּ���.");
			alert.showAndWait();
			Main.instance.loadpage("/view/login/login.fxml");// �α��� �������� ��ȯ
		}else {
			System.out.println("�����߻�");
		}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtemail.setText(Login.member.getMemail());
		txtaddress.setText(Login.member.getMaddress());
		
		
	}
	
}
