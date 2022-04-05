package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application{
	
	@Override
	public void start(Stage arg0) throws Exception {
		// 5. 컨테이너 불러오기
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		
		// 6. 씬 객체-> 컨테이너
		Scene scene = new Scene(parent);
		// 7. 씬 -> 스테이지
		arg0.setScene(scene);
		
		// 3. 스테이지로고 설정
			Image image = new Image("/img/search.png");
				// 절대 경로 VS 상대 경로
				// 절대 경로 : 모든 경로 (C:\Users\504\git\JAVA_study\KYJs_Project\src\img\search.img)
				// 상대 경로 : src 폴더부터 시작 (/img/search.png)
				// 슬래쉬를 쓰면 상대경로로 인식, 역슬래쉬를 쓰면 상대경로로 인식한다.
			// 2. 스테이지 설정			
			arg0.getIcons().add(image);	// 스테이지 로고 적용
///////////////////////////////////////////////////////////////////////////////////////////////////////			
		// * 외부 폰트 일괄 적용 & application.css 연동
			// 1. 폰트 호출
			Font.loadFont(getClass().getResourceAsStream("CookieRun Regular.ttf"), 14);
			// 2. 외부 스타일시트를 씬 객체에 적용
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
///////////////////////////////////////////////////////////////////////////////////////////////////////			
			
		arg0.setResizable(false);	// 4. 스테이지(창) 크기 재조정 불가 
		arg0.setTitle("이젠마켙");	// 2. 스테이지 창 이름 설정
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
