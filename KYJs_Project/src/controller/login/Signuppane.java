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
    	System.out.println("뒤로가기 버튼 눌림");
    	Login.본인객체.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void signup(ActionEvent event) {
    	// 컨트롤에 입력된 데이터 가져오기
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	String passwordconfirm = txtpasswordconfirm.getText();
    	String email = txtemail.getText();
    	String address = txtaddress.getText();
    	
    	// 현재 날짜 가져오기 [ SimpleDateFormat : 날짜 모양(형식) 변환 클래스 ] 
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String since = format.format(new Date());	// 현재 날짜를 String형식의 모양으로 변형 후 저장
    	
    	// 유효성 검사
    		// 1. id 중복 체크
    		// 2. id 형식 체크
    		// 3. 비밀번효 형식 체크
    		// 4. 비밀번호 일치 체크
    		// 5. 이메일
    		// 6. 주소
    	// * 모든 유효성 검사 통과 시 객체화 후 DB에 저장.
    		// 1. 객체화 [ 회원번호 없음, id, pw, email, address, 포인트 없음, 가입일)
    	Member member = new Member(0, id, passwordconfirm, email, address, 0, since);
    	boolean result = MemberDao.memberDao.signup(member);
    	
    	if (result) {
    		System.out.println("가입 성공");
    	}else {
    		System.out.println("가입 실패");
    	}
    		
    	
    }
	
}
