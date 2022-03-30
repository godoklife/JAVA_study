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
		System.out.println("main이 실행되었습니다.");
		loadpage("/view/login");
	}
	
	public void loadpage (String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page+".fxml"));	// dPdhlcjfl vlftn
			borderpane.setCenter(parent);	// 컨테이너 가운데에 페이지 넣기.
		} catch (Exception e) {System.out.println(e);}
	}
	
}
