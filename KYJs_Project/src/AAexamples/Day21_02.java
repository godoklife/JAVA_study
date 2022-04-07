package AAexamples;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Day21_02 extends Application {	// 1. Application 클래스로부터 상속
	
	@Override
	public void start(Stage stage) throws Exception {
						// 스테이지 이름
		// 1) FXML 파일 불러오기 : 컨테이너
		Parent parent = FXMLLoader.load( getClass().getResource("test.fxml"));
			// Parent : fxml 파일 (씬빌더로 생성한 파일)을 객체화
				// FXML.Loader.load(getClass().getRecource("경로.fxml파일명"));
		// 2) 씬 객체 생성 : 
		Scene scene = new Scene(parent);
		// 3) 스테이지에 씬 넣기
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
