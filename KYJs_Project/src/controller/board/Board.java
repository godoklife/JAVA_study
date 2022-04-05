package controller.board;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class Board implements Initializable{

    @FXML
    private TableColumn<?, ?> boardtable;

    @FXML
    private Button btnwrite;

    @FXML
    void accwrite(ActionEvent event) {

    }
    
    public void initialize(java.net.URL arg0, java.util.ResourceBundle arg1) {
    	
    };
	
}
