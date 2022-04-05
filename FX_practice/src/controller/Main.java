package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable{
					// initializable : 해당하는 FXML이 열렸을 때, 메서드를 제공하는 인터페이스.
	// 1. 필드
	@FXML
	private BorderPane borderpane;	
		// main.FXML에 들어있는 BorderPane의 fx:id( = borderpane)
	
	public void loadpage(String page) {	// FXML 로딩 메서드화(인수값 : FXML 경로)
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);	
				// 해당 FXML을 보더팬의 중앙으로 위치 시킴.
				// Top, Left, Center, Right, Bottom 총 5가지
			
		}catch(Exception e) {System.out.println("Main loadpage Exception : "+e);}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadpage("/view/login/login.fxml");	// loadpage 객체에 fxml 주소를 인수로 전달
	}

}
