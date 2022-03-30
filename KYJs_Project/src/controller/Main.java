package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable{
				// Initializable : view�� ������ �� �ʱⰪ ���� �޼��� ����
	
    @FXML
    private BorderPane borderpane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("main�� ����Ǿ����ϴ�.");
		loadpage("/view/login");
	}
	
	public void loadpage (String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page+".fxml"));	// dPdhlcjfl vlftn
			borderpane.setCenter(parent);	// �����̳� ����� ������ �ֱ�.
		} catch (Exception e) {System.out.println(e);}
	}
	
}
