package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dto.Member;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Home implements Initializable{
				// fxml 실행 시 초기값 설정 메서드를 제공하는 인터페이스
	
	@FXML
	private Label lblloginid;
	
	@FXML
	private Label lblpoint;
	
	@FXML
	private Label lbllogout;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(Login.member.getMid());
		lblpoint.setText("포인트 : "+Login.member.getMpoint());
	}
	
	@FXML	// 시
	public void logout (MouseEvent e) {	
		// 1. 로그인 정보 날리기
		Login.member = null;
		// 2. 페이지 전환
		Main.instance.loadpage("/view/main.fxml");
	}
	

}
