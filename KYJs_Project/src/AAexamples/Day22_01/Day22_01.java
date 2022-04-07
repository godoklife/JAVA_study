package AAexamples.Day22_01;
// 수요일 [ javaFX 처음 사용 ] 

	// javaFX 사용 설정
		// 1.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;





public class Day22_01 extends Application{
						// 반드시 Application 클래스 상속 받기.
	// 1. 스타트 메서드 재정의
	@Override
	public void start(Stage stage) throws Exception {
						// 스테이지 이름은 내 맘대로.
		Parent parent = FXMLLoader.load(getClass().getResource("DB테스트.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	// 2. 메인 메서드 작성
	public static void main(String[] args) {
		launch(args);
	}	// m e
	
	
	
	
	// 3. 메인메서드가 있는 클래스마다 --module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.graphics 등등 라이브러리 추가해주기.
}	// c e
