package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable{
					// initializable : �ش��ϴ� FXML�� ������ ��, �޼��带 �����ϴ� �������̽�.
	// 1. �ʵ�
	@FXML
	private BorderPane borderpane;	
		// main.FXML�� ����ִ� BorderPane�� fx:id( = borderpane)
	
	public void loadpage(String page) {	// FXML �ε� �޼���ȭ(�μ��� : FXML ���)
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);	
				// �ش� FXML�� �������� �߾����� ��ġ ��Ŵ.
				// Top, Left, Center, Right, Bottom �� 5����
			
		}catch(Exception e) {System.out.println("Main loadpage Exception : "+e);}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadpage("/view/login/login.fxml");	// loadpage ��ü�� fxml �ּҸ� �μ��� ����
	}

}
