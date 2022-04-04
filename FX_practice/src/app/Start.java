package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application{
		// 윈도우 창 여는 쓰레드[ 메인 메서드가 들어있는 클래스 ]
			// Application : javaFX 실행 관련 메서드 제공. 메인 메서드가 반드시 상속 받아야 한다.
	
	@Override
	public void start(Stage primaryStage) throws Exception {	
		// 1.FXML 파일을 컨테이너로 불러오기
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		
		// 2. 컨테이너 -> 씬 객체로 전달	
		Scene scene = new Scene(parent);
		
		// 3. 윈도우창(primaryStage)에 띄울 씬 객체 설정
		primaryStage.setScene(scene);
		
		Image image = new Image("/img/thunder.png");	// 아이콘 경로 설정
		primaryStage.getIcons().add(image);	// 아이콘 설정
		primaryStage.setTitle("번개장터");		// 윈도 창 타이틀 설정
		primaryStage.setResizable(false);	// 사용자가 창 크기 재설정 가능 여부 설정 [ T / F ] 
		primaryStage.show();				// 윈도 창 실행
		
	}
	
	public static void main(String[] args) {
		launch(args);	// 바로 위에서 정의한 start 메서드 시작
	}
	
}
