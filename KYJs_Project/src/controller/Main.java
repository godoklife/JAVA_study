package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable{
				// Initializable : view가 열렸을 때 초기값 설정 메서드 제공
	
    @FXML
    private BorderPane borderpane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Main과 Start가 연결되었습니다..");
		loadpage("/view/login.fxml");	// /패키지명/파일명
		// 괄호 안의 주소는 인수로 넘어감	// /패키지명/파일명.fxml (26번 라인에서 ".fxml" 안 적을 경우)
	}
	
	public void loadpage (String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));	// 예외처리 필수
																		// 확장명 쓰기 귀찮으니 그냥 인수 받아올 때 확장자 붙여주는거임...
			borderpane.setCenter(parent);	// 컨테이너 가운데에 페이지 넣기.
		} catch (Exception e) {System.out.println("main");System.out.println(e);}
	}
	
}
