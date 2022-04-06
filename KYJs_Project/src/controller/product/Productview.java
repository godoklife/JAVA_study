package controller.product;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import dao.MemberDao;
import dto.Member;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

    }

    @FXML
    void accdelete(ActionEvent event) {

    }

    @FXML
    void accupdate(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	Product product = Productcontrol.select;
    	pimage.setImage(new Image(product.getPimage()));
    	txtptitle.setText(product.getPname());
    	txtpcontent.setText(product.getPcontent());
    	
    	// ���ݿ� ��ǥ ����
    	DecimalFormat decimalFormat = new DecimalFormat("���� : #,##0�� ");
    	
    	txtpprice.setText(decimalFormat.format(product.getPprice()));
    	txtpdate.setText("����� : "+product.getPdate());
    	
    	
    	if(product.getPactivation()==1) {
    		txtpactivation.setText("�Ǹ� ���� : �Ǹ���");
    	}else if(product.getPactivation()==2) {
    		txtpactivation.setText("�Ǹ� ���� : ������");
    	}else {
    		txtpactivation.setText("�Ǹ� ���� : �ǸſϷ�");
    	}
    	String mid = MemberDao.memberDao.getmemberid(product.getMnum());
    	if(mid==null) mid="Ż���� ȸ���Դϴ�.";
    			
    	txtmid.setText("�۾��� : "+mid);		
    	
    }
}
