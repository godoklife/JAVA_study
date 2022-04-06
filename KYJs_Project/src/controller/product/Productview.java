package controller.product;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.MemberDao;
import dao.ProductDao;
import dto.Member;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Productview implements Initializable {
    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnback;

    @FXML
    private TextField txtptitle;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private ImageView pimage;

    @FXML
    private Label txtpprice;

    @FXML
    private Label txtpdate;

    @FXML
    private Label txtmid;

    @FXML
    private Label txtpactivation;

    @FXML
    private TableView<Product> tableview;

    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");
    }

    @FXML
    void accdelete(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("정말 삭제하시겠습니까?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get() == ButtonType.OK) {
	    	boolean result = ProductDao.productDao.delete(Productcontrol.select.getPnum());
	    	if(result) {
	    		alert = new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("삭제가 완료되었습니다.");
	    		alert.showAndWait();
	    		Home.home.loadpage("/view/product/product.fxml");
	    	}
    	}

    	
    }

    @FXML
    void accupdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("정말 수정 하시겠습니까?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get() == ButtonType.OK) {
    	Home.home.loadpage("/view/product/productadd.fxml");
    	}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	Product product = Productcontrol.select;
    	pimage.setImage(new Image(product.getPimage()));
    	txtptitle.setText(product.getPname());
    	txtpcontent.setText(product.getPcontent());
    	
    	// 가격에 쉼표 삽입
    	DecimalFormat decimalFormat = new DecimalFormat("가격 : #,##0원 ");
    	
    	txtpprice.setText(decimalFormat.format(product.getPprice()));
    	txtpdate.setText("등록일 : "+product.getPdate());
    	
    	
    	if(product.getPactivation()==1) {
    		txtpactivation.setText("판매 상태 : 판매중");
    	}else if(product.getPactivation()==2) {
    		txtpactivation.setText("판매 상태 : 예약중");
    	}else {
    		txtpactivation.setText("판매 상태 : 판매완료");
    	}
    	String mid = MemberDao.memberDao.getmemberid(product.getMnum());
    	if(mid==null) mid="탈퇴한 회원입니다.";
    			
    	txtmid.setText("글쓴이 : "+mid);		
    	
    	// 제목과 내용 수정 불가능하도록 잠금처리
    	txtptitle.setEditable(false);
    	txtpcontent.setEditable(false);
    	if(Login.member.getMnum()!=product.getMnum()) {	// 게시글 작성 Mnum과 로그인 한 유저의 Mnum이 같지 않으면 삭제, 수정 버튼 숨김처리
    		btndelete.setVisible(false);
    		btnupdate.setVisible(false);
    	}
    	
    	
    }
}
