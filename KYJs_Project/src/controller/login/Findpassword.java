package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    }

}
