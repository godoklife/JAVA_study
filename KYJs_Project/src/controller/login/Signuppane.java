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
		lblconfirm.setText("");	// 실행했을 때 lblconfirm을 사용자가 보지 못하게 공백처리
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
    	boolean result2 = MemberDao.memberDao.idcheck(id);
    	if(result2) {
    		lblconfirm.setText("이미 사용중인 아이디 입니다.");
    		return;
    	}
    		// 2. id 형식 체크
    	if(id.length() < 4 || id.length() > 10) {
    		lblconfirm.setText("아이디는 4~10자 이내여야 합니다.");
    		return;
    	}
    		// 3. 비밀번효 형식 체크
    	if(password.length()<4 || password.length() > 10 ) {	// 비번이 4글자 미만, 10글자 초과면
    		lblconfirm.setText("비밀번호는 4~10자 이내여야 합니다.");
    		return;
    	}
    		// 4. 비밀번호 일치 체크
    	if( ! password.equals(passwordconfirm)) {	// 패스워드하고 패스워드컨펌하고 일치하지 않으면
    		lblconfirm.setText("비밀번호가 일치하지 않습니다.");
    		return;
    	}
    		// 5. 이메일
    	if(email.indexOf("@")==-1 ) {	// indexOf("@") : 골뱅이가 문자열에 없으면 -1 리턴, 있으면 인덱스값 리턴
    		lblconfirm.setText("이메일 형식을 확인하세요.");
    		return;
    	}
    		// 6. 주소
    	if( ! (address.contains("시")&& address.contains("동")) ) {	// .contains("시") : "시" 가 있으면 true 반환
    		lblconfirm.setText("시, 동을 포함한 주소를 입력하세요.");
    		return;
    	}
    	// * 모든 유효성 검사 통과 시 객체화 후 DB에 저장.
    		// 1. 객체화 [ 회원번호 없음, id, pw, email, address, 포인트 없음, 가입일)
    	Member member = new Member(0, id, passwordconfirm, email, address, 0, since);
    		// 2. DB 객체 내 메서드 호출
    	boolean result = MemberDao.memberDao.signup(member);
    		// 3. 확인
    	if (result) {
    		// 1) 메시지 창 출력
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("알림");	// 메시지 제목 설정
    		alert.setHeaderText("안산시 중고거래에 가입을 환영합니다.");
    		alert.setTitle("가입성공");
    		alert.showAndWait();
    		// 2) 화면 전환
    		Login.본인객체.loadpage("/view/login/loginpane.fxml");
    		
    	}else {
    		lblconfirm.setText("실패! 관리자에게 문의");
    		return;
    	}
    		
    	
    }
	
}
