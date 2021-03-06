package controller.home;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import dao.MemberDao;
import dto.Member;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Home implements Initializable{
				// fxml 실행 시 초기값 설정 메서드를 제공하는 인터페이스
	public static Home home;
	public Home() {
		System.out.println("호출된 Home 객체의 메모리 주소 : "+home);
		home = this;
	}
	
	@FXML
	private Label lblloginid;
	
	@FXML
	private Label lblpoint;
	
	@FXML
	private Label lbllogout;
	
	@FXML
	private Label lbldelete;
	
	@FXML
	private Label lblupdate;
	
	@FXML
	private Label lblboard;
	
	@FXML
	private Label lblproduct;
	
    @FXML
    private Label lblproduct2;

    @FXML
    private Label lblproduct3;

    @FXML
    private Label lblproduct4;
	
	@FXML
	private BorderPane borderpane;
	
	@FXML
	private Label lblrecord;
	
	@FXML
	public void accrecord(MouseEvent e) {
		loadpage("/view/record.fxml");
	}
	
	
	@FXML
	public void accboard(MouseEvent e) {
		loadpage("/view/board/board.fxml");
	}
	

	
	@FXML
	public void update(MouseEvent e) {
		loadpage("/view/home/update.fxml");
	}
	
	@FXML	
	public void accinfo(MouseEvent e) {
		loadpage("/view/home/info.fxml");
	}
	
	public static String category;	// 어떤 게시판을 클릭했는지 저장하는 변수
	
	@FXML
	public void product(MouseEvent e) {
		category = "남성의류";
		loadpage("/view/product/product.fxml");
	}
	
	@FXML
	public void product2(MouseEvent e) {
		category = "여성의류";
		loadpage("/view/product/product.fxml");
	}
	
	@FXML
	public void product3(MouseEvent e) {
		category = "휴대폰";
		loadpage("/view/product/product.fxml");
	}
	
	@FXML
	public void product4(MouseEvent e) {
		category = "노트북";
		loadpage("/view/product/product.fxml");
	}
	

	public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page) );
			borderpane.setCenter(parent);
		}catch( Exception e ) { System.out.println("Home controll Exception :  "+e);}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(Login.member.getMid());
		lblpoint.setText("포인트 : "+Login.member.getMpoint());
		loadpage("/view/chatting.fxml");
	}
	
	@FXML	// 로그아웃 클릭시 이벤트
	public void logout (MouseEvent e) {	
		// 1. 로그인 정보 날리기
		Login.member = null;
		// 2. 페이지 전환
		Main.instance.loadpage("/view/main.fxml");
	}
	
	@FXML	// 회원탈퇴 레이블을 클릭했을 때 이벤트
	public void delete(MouseEvent e) {
		// 1. 메시지 띄우기
		Alert alert = new Alert(AlertType.CONFIRMATION);	// 확인과 취소 버튼이 있음.
			alert.setHeaderText("정말 탈퇴하시겠습니까?");
		// 2. 버튼 확인 [ Optional : 클래스 ]
		Optional<ButtonType> optional = alert.showAndWait();
		
		if(optional.get() == ButtonType.OK) {
			System.out.println("확인 눌림");
			boolean result = MemberDao.memberDao.delete(Login.member.getMnum());
				// 현재 로그인 중인 회원의 회원번호를 인수로 넣어서 delete 메서드로 전달.
			if(result) {	// 탈퇴 성공시
				// 로그아웃	[ Login 클래스 내 Member 객체를 null로 수정 ] 
				Login.member = null;
				Main.instance.loadpage("/view/main.fxml");
				
				// 페이지 전환
			}else {	// 탈퇴 실패시
				
			}
		}else {
			System.out.println("취소 눌림");
		}
		
		
	}
	
	
	
}
