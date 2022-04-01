package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Login implements Initializable{

	// * 현재 클래스의 메모리를 반환하는 방법
		// 1. 현재 클래스로 객체 선언
	public static Login 본인객체;
	
		// 2. 생성자에서 객체 내 this 넣어주기.
			// this : 현재 클래스의 메모리를 호출.
	public Login() {
		System.out.println("호출된 Login객체의 메모리 주소 : "+본인객체);
		본인객체 = this;	
	}
	 // 아래 get본인객체() 는 써도 되고 안써도 됨.
//	public static Login get본인객체() {
//		return 본인객체;
//	}
	
    @FXML
    private MediaView mediaview;
    	// 이거는 씬빌더 상단바 - 뷰 - 쇼 샘플 컨트롤러 스캘레톤 에서 복붙
    
    @FXML
    private BorderPane borderpane;
	
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 1. 동영상 삽입하기
			// 1. 동영상 파일 객체화
		Media media = new Media(getClass().getResource("/img/loginbg.mp4").toString());	// Media 클래스의 생성자는 String형으로만 받기 때문에 .toString을 통해 변환해주어야 함.
			
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			
			mediaview.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();
			System.out.println("실행중인 Login 메모리 주소 : "+Login.본인객체);
			loadpage("/view/login/loginpane.fxml");
	}
	
	public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page) );
			borderpane.setCenter(parent);
		}catch( Exception e ) { System.out.println("해당 파일이 없습니다. "+e);}
	}
	
}
