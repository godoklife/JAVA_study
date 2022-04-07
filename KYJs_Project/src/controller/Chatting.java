package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Chatting {
	
    @FXML
    private AnchorPane txt;

    @FXML
    private Button btnsend;

    @FXML
    private Button btnconnect;

    @FXML
    private TextArea txtcontent;

    @FXML
    private TextField txtmsg;

    @FXML
    private TextField txtnickname;

    @FXML
    private TextField txtserverip;

    @FXML
    private TextField txtserverport;

    @FXML
    private Label lblnickname;

    @FXML
    private Label lblserverip;

    @FXML
    private Label lblserverport;

    @FXML
    void accconnect(ActionEvent event) {

    }

    @FXML
    void accsend(ActionEvent event) {

    }

}
