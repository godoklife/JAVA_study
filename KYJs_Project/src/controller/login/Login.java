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

	// * ���� Ŭ������ �޸𸮸� ��ȯ�ϴ� ���
		// 1. ���� Ŭ������ ��ü ����
	public static Login ���ΰ�ü;
	
		// 2. �����ڿ��� ��ü �� this �־��ֱ�.
			// this : ���� Ŭ������ �޸𸮸� ȣ��.
	public Login() {
		System.out.println("ȣ��� Login��ü�� �޸� �ּ� : "+���ΰ�ü);
		���ΰ�ü = this;	
	}
	 // �Ʒ� get���ΰ�ü() �� �ᵵ �ǰ� �Ƚᵵ ��.
//	public static Login get���ΰ�ü() {
//		return ���ΰ�ü;
//	}
	
    @FXML
    private MediaView mediaview;
    	// �̰Ŵ� ������ ��ܹ� - �� - �� ���� ��Ʈ�ѷ� ��Ķ���� ���� ����
    
    @FXML
    private BorderPane borderpane;
	
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 1. ������ �����ϱ�
			// 1. ������ ���� ��üȭ
		Media media = new Media(getClass().getResource("/img/loginbg.mp4").toString());	// Media Ŭ������ �����ڴ� String�����θ� �ޱ� ������ .toString�� ���� ��ȯ���־�� ��.
			
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			
			mediaview.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();
			System.out.println("�������� Login �޸� �ּ� : "+Login.���ΰ�ü);
			loadpage("/view/login/loginpane.fxml");
	}
	
	public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page) );
			borderpane.setCenter(parent);
		}catch( Exception e ) { System.out.println("�ش� ������ �����ϴ�. "+e);}
	}
	
}
