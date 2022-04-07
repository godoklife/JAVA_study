package AAexamples;


// javafx만 import [ awt, swing은 구버전에서 사용 ] 
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Day21_01 extends Application{
							// Application : javaFX GUI 관련 클래스
	@Override
	public void start(Stage 스테이지) throws Exception {	// 
		// javaFX를 실행하는 메서드 [ 추상 -> 구현 ]
			// 상속받으면 슈퍼클래스 내 멤버를 사용할 수 있다.
		// 1. 컨테이너 만들기 [ 여러개의 컨트롤을 세로로 저장 ] 
		VBox 컨테이너 = new VBox();	// (Vertical box)
			// 2. 컨트롤 만들기
			Button button = new Button();
			button.setText("닫기");
			button.setOnAction( e -> Platform.exit() ); // 값 -> 인수  람다식 ( 이름이 없는 메소드 )
			// 3. 컨테이너에 컨트롤 넣기 
			컨테이너.getChildren().add(button);
			// 4. 씬 객체 만들어서 씬 컨테이너 넣기
			Scene 장면 = new Scene(컨테이너, 500, 500);	// 컨테이너이름, 가로크기, 세로크기
		
		
		스테이지.show();	// 스테이지 열기
	}
	
	public static void main(String[] args) {	// 메인스레드
		
		launch(args);	// start 메서드 호출
	}
}
