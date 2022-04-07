package AAexamples.Day22_01;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
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
    void write(ActionEvent event) {
    	System.out.println("DB내 데이터를 저장합니다.");
    	
    	String 작성자 = txtwriter.getText();
    	String 내용 = txtcontent.getText();
    	
    	
    	// 1. 
    	Day22_02 DB연동 = new Day22_02();
    	// 2. 
    	boolean result = DB연동.write(작성자, 내용);
    	
    	if(result) {
    		System.out.println("DB에 저장 성공");
    		
    		// 성공시 컨트롤에 입력된 데이터 지워주기.
    		txtwriter.setText("");
    		txtcontent.setText("");
    	}else {
    		System.out.println("DB에 저장을 실패했습니다.");
    	}
    }
    
    @FXML
    void get(ActionEvent event) {
    	System.out.println("DB내 데이터 호출");
    	
    	// 1. DB 연동 객체 만들기
    	Day22_02 DB연동 = new Day22_02();
    	
    	// 2. DB 객체 내 메서드 호출 후 결과물 리스트로 
    	ArrayList<데이터> 데이터목록 = DB연동.get();
    	
    	for(데이터 tmp : 데이터목록) {
    		txtcontentlist.appendText(
    				"번호"+tmp.get번호()+
    				"작성자"+tmp.get작성자()+
    				"내용"+tmp.get내용()+"\n");
    	}
    	
    	
    	
    }
    
	
}
