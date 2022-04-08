package app;

import controller.Chatting;
import controller.login.Login;
import dao.RoomDao;
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
			Font.loadFont(getClass().getResourceAsStream("CookieRun Regular.ttf"), 40);
			// 2. 외부 스타일시트를 씬 객체에 적용
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
///////////////////////////////////////////////////////////////////////////////////////////////////////			
			
		// setOnCloseRequest : 윈도우 창에서 X버튼 눌러서 껐을 때 이벤트
		arg0.setOnCloseRequest(e->{
			// 만약 로그인이 되어있으면
			if(Login.member != null	) {
				// 1. 방 접속 명단 삭제
				RoomDao.roomDao.roomlivedelete(Login.member.getMid());
				// 2. 방 삭제	
				if(Chatting.selectroom != null) {
					RoomDao.roomDao.roomdelete(Chatting.selectroom.getRoomnumber());
				}
				// 3. 선택 방 저장하는 변수 초기화
				Chatting.selectroom=null;	// 초기화 할 필요가 있나?	
			}
		});		// 람다식 END
			
		arg0.setResizable(false);	// 4. 스테이지(창) 크기 재조정 불가 
		arg0.setTitle("번개장터");	// 2. 스테이지 창 이름 설정
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
