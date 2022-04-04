package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Findid implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	   @FXML
	    private TextField txtemail;

	    @FXML
	    private Button btnfindid;

	    @FXML
	    private Button btnback;

	    @FXML
	    private Label lblconfirm;

	    @FXML
	    void back(ActionEvent event) {
	    	System.out.println("뒤로가기 버튼 눌림");
	    	Login.본인객체.loadpage("/view/login/loginpane.fxml");
	    }

    @FXML
    void findid(ActionEvent event) {
    	// 1. 컨트롤에 입련된 이메일 가져오기
    	String email = txtemail.getText();
    	String id = MemberDao.memberDao.findid(email);
    	if(id!=null) {	// id가 null이 아니면?
    		// 1. 메세지 출력
    		Alert alert = new Alert(AlertType.INFORMATION);	
    			// Alert의 형태를 information으로 지정 후 메모리 선언
    		alert.setHeaderText("당신의 아이디는"+id);
    		alert.showAndWait();
    		
    	}else{	// id가 null이면?
    		lblconfirm.setText("해당 이메일의 아이디가 존재하지 않습니다.");
    	}
    	
    }
	
}
