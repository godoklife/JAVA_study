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
    	System.out.println("아이디 찾기 페이지 버튼");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	System.out.println("비밀번호 찾기 페이지 버튼");

    }

    @FXML
    void acclogin(ActionEvent event) {
    	System.out.println("로그인처리");
    	
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("회원가입 페이지로 이동.");
    	// 회원가입 버튼을 누르면 login 컨트롤 클래스 내 borderpane 컨테이너 center 페이지 변경.
    	// problem -> 다른 클래스 내 컨테이너 호출 -> Login login = new Login(); 쓰면 새로운 컨테이너가 만들어짐. XX
    	// answer -> 기존 컨테이너를 가져오는 방법 -> Login 클래스의 18번라인부터 27번라인 참고
    	Login.본인객체.loadpage("/view/signuppane.fxml");
    	
//    	login.loadpage("/view/signuppage.fxml");
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
