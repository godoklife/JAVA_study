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
    	System.out.println("아이디 찾기 페이지 버튼");
    	Login.본인객체.loadpage("/view/login/findid.fxml");
    }

    @FXML
    void accfindpassword(ActionEvent event) {
    	System.out.println("비밀번호 찾기 페이지 버튼");
    	Login.본인객체.loadpage("/view/login/findpassword.fxml");
    }

    @FXML
    void acclogin(ActionEvent event) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String nowdate = format.format(new Date());
    	System.out.println("if문 전 nowdate : "+nowdate);
    	// 1. 컨트롤에 입력된 값 가져오기
    	String id = txtid.getText();
    	String password = txtpassword.getText();
    	
    	boolean result = MemberDao.memberDao.login(id, password);
    	
    	if(result) {
    		// 로그인 성공시 성공한 회원정보 저장. [ 로그아웃 시 초기화 ] 
    		Login.member = MemberDao.memberDao.getmember(id);
/////////////////////////////////////////////    		오늘 첫 로그인시 10포인트 지급. 실행 위치 바꿔야함.
    		if(!nowdate.equals(Login.member.getLastlogindate())) {
    			System.out.println("객체 내 날짜 : "+Login.member.getLastlogindate());
    			System.out.println("nowdate : "+nowdate);
    			int tmpPoint = Login.member.getMpoint()+10;
    			MemberDao.memberDao.updatepoint(Login.member.getMnum(), tmpPoint, nowdate);
    		}
/////////////////////////////////////////////    		
    		
    		lblconfirm.setText("로그인 성공");
    		Main.instance.loadpage("/view/home/home.fxml");
    	}else {
    		lblconfirm.setText("아이디와 비밀번호를 확인하세요");
    	}
    	
    	
//    	System.out.println(txtid.getText() + "가 아이디로 입력되었습니다.");
//    	System.out.println(txtpassword.getText() + "로 패스워드가 입력되었습니다.");
    	
    	System.out.println("로그인처리");
    	
    	
    }

    @FXML
    void accsignup(ActionEvent event) {
    	System.out.println("회원가입 페이지로 이동.");
    	// 회원가입 버튼을 누르면 login 컨트롤 클래스 내 borderpane 컨테이너 center 페이지 변경.
    	// problem -> 다른 클래스 내 컨테이너 호출 -> Login login = new Login(); 쓰면 새로운 컨테이너가 만들어짐. XX
    	// answer -> 기존 컨테이너를 가져오는 방법 -> Login 클래스의 18번라인부터 27번라인 참고
    	Login.본인객체.loadpage("/view/login/signuppane.fxml");
    	
//    	login.loadpage("/view/signuppage.fxml");
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
