package application.Day22_01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Day22_01_controller implements Initializable{
										// Initializable : FXML이 새로 열렸을 때 초기값 설정 메서드를 제공하는 인터페이스
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Day22_02 DB연동 = new Day22_02();
	}

	@FXML
    private TextField txtwriter;

    @FXML
    private TextField txtcontent;

    @FXML
    private Button btnget;

    @FXML
    private Button btnwrite;

    @FXML
    private TextArea txtcontentlist;

    @FXML
    void get(ActionEvent event) {
    	System.out.println("DB내 데이터 호출");
    	
    }

    @FXML
    void write(ActionEvent event) {
    	System.out.println("DB내 데이터를 저장합니다.");

    }
	
}
