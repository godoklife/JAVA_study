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
    private TableView<dto.Board> boardtable;	// ���̺�信 �Խù� ǥ���ϱ� ���� ���� �ڷ��� ���� -> Board
    
    public static dto.Board board;	// ���콺�� Ŭ���� ��ü�� �����ϴ� Board(dto) ��ü

    @FXML
    private Button btnwrite;

    @FXML
    void accwrite(ActionEvent event) {
    	Home.home.loadpage("/view/board/board_write.fxml");
    }
    
    public void initialize(java.net.URL arg0, java.util.ResourceBundle arg1) {
    	// * arraylist�� �ƴ� ObserableList ����ϴ� ����? [ tableview ] 
    	// 1. DB���� ��� �Խñ� ��������.
    	ObservableList<dto.Board> boardlist = BoardDao.boardDao.list();
    	
    	// 2. tableview�� �߰�
    		// ���� ���̺��� �� ������ ����Ʈ �� �ʵ� ����
    	TableColumn tc = boardtable.getColumns().get(0);	// ���̺��� ù ���� �� ��������
    		// TableColumn : ���̺� ��		// boardtable(fxid).getColumns().get(0) : ù ���� �� ȣ��
    	tc.setCellValueFactory(new PropertyValueFactory<>("bnum"));
    	
    	tc = boardtable.getColumns().get(1);	// ���̺��� �ι�° �� ��������
    	tc.setCellValueFactory( new PropertyValueFactory<>("btitle"));
    	
    	tc = boardtable.getColumns().get(2);	// ���̺��� ����° �� ��������
    	tc.setCellValueFactory( new PropertyValueFactory<>("bwrite"));
    	
    	tc = boardtable.getColumns().get(3);	// ���̺��� �׹�° �� ��������
    	tc.setCellValueFactory( new PropertyValueFactory<>("bdate"));
    	
    	tc = boardtable.getColumns().get(4);	// ���̺��� �ټ���° �� ��������
    	tc.setCellValueFactory( new PropertyValueFactory<>("bview"));
    	
    	// 3. tableview �� list ����
    	boardtable.setItems(boardlist);
    		// ���̺��(fxid)
    	
    	// * tableview ���� �ش� ���� Ŭ������ �� �̺�Ʈ
    	//boardtable.setOnMouseClicked(null);
    	boardtable.setOnMouseClicked( e -> {
    		// 1. ���̺��� Ŭ���� ��ü�� �ӽ� ��ü�� ����
    		board = boardtable.getSelectionModel().getSelectedItem();	// ����ڰ� Ŭ���� ��ü�� �޸� �ּҸ� Board(dto) board ��ü�� ����
    		// 2. ��ȸ�� ����
    		// 3. Ŭ���ϸ� ȭ�� ��ȯ
    		Home.home.loadpage("/view/board/boardview.fxml");
    	});
    	
    	
    	// [ ��ȸ��
    	
    	
    }
	
}
