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
	public void confirm(ActionEvent e){	//  버튼 클릭은 ActionEvent 임.
		// 1. 컨트롤러에 입력한 ㅔ데이터 가져오기
		String email = txtemail.getText();
		String address = txtaddress.getText();
		// 2. 업데이트 처리 [ 회원번호는 로그인시 Login.member 메모리에 올라가 있음!! ] 
		boolean result = MemberDao.memberDao.update(Login.member.getMnum(), email, address);
		if(result) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("회원정보가 수정되었습니다. 다시 로그인 해 주세요.");
			alert.showAndWait();
			Main.instance.loadpage("/view/login/login.fxml");// 로그인 페이지로 전환
		}else {
			System.out.println("에러발생");
		}
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtemail.setText(Login.member.getMemail());
		txtaddress.setText(Login.member.getMaddress());
		
		
	}
	
}
