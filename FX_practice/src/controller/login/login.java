package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class login implements Initializable	{

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private MediaView mediaview;

    @FXML
    private BorderPane borderpane;

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    // 1. 동영상 파일을 컨테이너에 넣기
    Media media = new Media("/img/sky.mp4");
    
    // 2. 미디어 플레이어 객체에 컨테이너를 인수로 전달
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    
    // 3. fxml의 mediaview fx:id에 mediaPlayer 객체 설정
    mediaview.setMediaPlayer(mediaPlayer);
    
    // 4. 미디어플레이어 객체 시작
    mediaPlayer.play();
    
    // 5. 동영상 끝났을 떄 재반복
    mediaPlayer.setOnEndOfMedia(new Runnable() {
		@Override
		public void run() {
			mediaPlayer.seek(Duration.ZERO);
				// 미디어플레이어의 현재 위치를 처음으로 되돌리기
		}
	} );
    }	// initialize END

}	// c e
