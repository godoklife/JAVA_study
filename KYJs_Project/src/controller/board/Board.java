package controller.board;

import controller.home.Home;
import dao.BoardDao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Board implements Initializable{

    @FXML
    private TableView<dto.Board> boardtable;	// 테이블뷰에 게시물 표시하기 위해 넣을 자료형 선택 -> Board
    
    public static dto.Board board;	// 마우스로 클릭한 객체를 저장하는 Board(dto) 객체

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
    	
    	// 2. tableview에 추가
    		// 현재 테이블의 각 열마다 리스트 내 필드 설정
    	TableColumn tc = boardtable.getColumns().get(0);	// 테이블에서 첫 번쨰 열 가져오기
    		// TableColumn : 테이블 열		// boardtable(fxid).getColumns().get(0) : 첫 번쨰 열 호출
    	tc.setCellValueFactory(new PropertyValueFactory<>("bnum"));
    	
    	tc = boardtable.getColumns().get(1);	// 테이블에서 두번째 열 가져오기
    	tc.setCellValueFactory( new PropertyValueFactory<>("btitle"));
    	
    	tc = boardtable.getColumns().get(2);	// 테이블에서 세번째 열 가져오기
    	tc.setCellValueFactory( new PropertyValueFactory<>("bwrite"));
    	
    	tc = boardtable.getColumns().get(3);	// 테이블에서 네번째 열 가져오기
    	tc.setCellValueFactory( new PropertyValueFactory<>("bdate"));
    	
    	tc = boardtable.getColumns().get(4);	// 테이블에서 다섯번째 열 가져오기
    	tc.setCellValueFactory( new PropertyValueFactory<>("bview"));
    	
    	// 3. tableview 로 list 연결
    	boardtable.setItems(boardlist);
    		// 테이블명(fxid)
    	
    	// * tableview 에서 해당 셀을 클릭했을 떄 이벤트
    	//boardtable.setOnMouseClicked(null);
    	boardtable.setOnMouseClicked( e -> {
    		// 1. 테이블에서 클릭한 객체를 임시 객체에 저장
    		board = boardtable.getSelectionModel().getSelectedItem();	// 사용자가 클릭한 객체의 메모리 주소를 Board(dto) board 객체에 저장
    		// 2. 조회수 증가
    		// 3. 클릭하면 화면 전환
    		Home.home.loadpage("/view/board/boardview.fxml");
    	});
    	
    	
    	// [ 일회용
    	
    	
    }
	
}
