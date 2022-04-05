package controller.board;

import controller.home.Home;
import dao.BoardDao;
import javafx.collections.ObservableList;
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
    	Home.home.loadpage("/view/board/board_write.fxml");
    }
    
    public void initialize(java.net.URL arg0, java.util.ResourceBundle arg1) {
    	// * arraylist가 아닌 ObserableList 사용하는 이유? [ tableview ] 
    	// 1. DB에서 모든 게시글 가져오기.
    	ObservableList<dto.Board> boardlist = BoardDao.boardDao.list();
    	System.out.println(boardlist.toString());
    	
    	
    };
	
}
