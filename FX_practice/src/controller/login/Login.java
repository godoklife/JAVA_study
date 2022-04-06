package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Login implements Initializable	{

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private MediaView mediaview;

    @FXML
    private BorderPane borderpane;

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    // 1. ������ ������ �����̳ʿ� �ֱ�
    Media media = new Media(getClass().getResource("/img/thundermovie.mp4").toString());
    
    // 2. �̵�� �÷��̾� ��ü�� �����̳ʸ� �μ��� ����
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    // 3. fxml�� mediaview fx:id�� mediaPlayer ��ü ����
    mediaview.setMediaPlayer(mediaPlayer);
    
    // 4. �̵���÷��̾� ��ü ����
    mediaPlayer.play();
    
    // 5. ������ ������ �� ��ݺ�
    mediaPlayer.setOnEndOfMedia(new Runnable() {
		@Override
		public void run() {
			mediaPlayer.seek(Duration.ZERO);
				// �̵���÷��̾��� ���� ��ġ�� ó������ �ǵ�����
		}
	} );
    loadpage("/view/login/loginpane");
    }	// initialize END
    
    public void loadpage(String url) {
    	try {
    		Parent parent = FXMLLoader.load(getClass().getResource(url));
    		borderpane.setCenter(parent);
		} catch (Exception e) {System.out.println("Login loadpage Exception : "+e);}
    }
    
    

}	// c e
