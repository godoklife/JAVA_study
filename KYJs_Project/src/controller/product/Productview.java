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
    private Button btnactivation;

    @FXML
    void accactivation(ActionEvent event) {
    	if(Productcontrol.select.getPactivation()==1) {
    		txtpactivation.setText("������");
    		ProductDao.productDao.activation(Productcontrol.select.getPnum());
    		return;
    	}else if(Productcontrol.select.getPactivation()==2) {
    		txtpactivation.setText("�ǸſϷ�");
    		ProductDao.productDao.activation(Productcontrol.select.getPnum());
    		return;
    	}else {
    		txtpactivation.setText("�Ǹ���");
    		ProductDao.productDao.activation(Productcontrol.select.getPnum());
    		return;
    	}
    }
    
    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");
    }

    @FXML
    void accdelete(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("���� �����Ͻðڽ��ϱ�?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get() == ButtonType.OK) {
	    	boolean result = ProductDao.productDao.delete(Productcontrol.select.getPnum());
	    	if(result) {
	    		alert = new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("������ �Ϸ�Ǿ����ϴ�.");
	    		alert.showAndWait();
	    		Home.home.loadpage("/view/product/product.fxml");
	    	}
    	}

    	
    }

    @FXML
    void accupdate(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("���� ���� �Ͻðڽ��ϱ�?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get() == ButtonType.OK) {
    	Home.home.loadpage("/view/product/productupdate.fxml");
    	}
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
    		btnactivation.setText("���������� ����");
    	}else if(product.getPactivation()==2) {
    		txtpactivation.setText("�Ǹ� ���� : ������");
    		btnactivation.setText("�ǸſϷ�� ����");
    	}else {
    		txtpactivation.setText("�Ǹ� ���� : �ǸſϷ�");
    		btnactivation.setText("�Ǹ������� ����");
    	}
    	String mid = MemberDao.memberDao.getmemberid(product.getMnum());
    	if(mid==null) mid="Ż���� ȸ���Դϴ�.";
    			
    	txtmid.setText("�۾��� : "+mid);		
    	
    	// ����� ���� ���� �Ұ����ϵ��� ���ó��
    	txtptitle.setEditable(false);
    	txtpcontent.setEditable(false);
    	if(Login.member.getMnum()!=product.getMnum()) {	// �Խñ� �ۼ� Mnum�� �α��� �� ������ Mnum�� ���� ������ ����, ���� ��ư ����ó��
    		btndelete.setVisible(false);
    		btnupdate.setVisible(false);
    	}
    	
    	
    	// ��ǰ ���°� �Ǹ����̸� ��ư�� �ؽ�Ʈ�� '�ŷ��Ϸ�� �ٲٱ�' �� ����
    	
    	
    }
}