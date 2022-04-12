package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Findpassword implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

    @FXML
    private TextField txtid;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Button btnback;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    void back(ActionEvent event) {
    	System.out.println("뒤로가기 버튼 눌림");
    	Login.본인객체.loadpage("/view/login/loginpane.fxml");
    }

    @FXML
    void findpassword(ActionEvent event) {
    	String id = txtid.getText();
    	String email = txtemail.getText();
    	String findpw = MemberDao.memberDao.findpassword(id, email);
    	if(findpw!=null) {
    		Member.sendmail(email, findpw);	// 이메일로 전송
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("입력하신 정보의 비밀번호는 등록하신 이메일로 전송되었습니다.");
    		alert.showAndWait();
    	}else {	// 리턴받는 값이 null이면
    		lblconfirm.setText("일치하는 계정이 없습니다.");
    	}
    }

}
