package controller.product;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Productadd implements Initializable{


    @FXML
    private TextField txtpname;

    @FXML
    private TextArea txtpcontent;

    @FXML
    private TextField txtpprice;

    @FXML
    private RadioButton otp1;

    @FXML
    private ToggleGroup category;

    @FXML
    private RadioButton otp2;

    @FXML
    private RadioButton otp3;

    @FXML
    private RadioButton otp4;

    @FXML
    private Button btnimgadd;

    @FXML
    private ImageView img;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnback;

    @FXML
    private Label imgpath;

    @FXML
    void add(ActionEvent event) {
    	// 1. ��Ʈ�ѿ� �Էµ� ������ ��������
    	String pname = txtpname.getText();
    	String pcontent = txtpcontent.getText();
    	int pprice = Integer.parseInt(txtpprice.getText());
    	
    	// * ī�װ� 
    	String pcategory = null;
    		if(otp1.isSelected())	pcategory = "�����Ƿ�";	// otp1��� ���� fx:id�� ������ ������ư�� ���ȴٸ�
    		if(otp2.isSelected())	pcategory = "�����Ƿ�";
    		if(otp3.isSelected())	pcategory = "�޴���";
    		if(otp4.isSelected())	pcategory = "��Ʈ��";
    	int mnum = Login.member.getMnum();
    	
    	// 2. ��üȭ
    	Product product = new Product(0, pname, pimage, pcontent, pcategory, pprice, 1, null, mnum);
    	
    	// 3. DBó��
    	boolean result = ProductDao.productDao.add(product);
    	
    	// 4. ��� ó��
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("�Խñ� ������ �Ϸ�Ǿ����ϴ�.");
    		alert.showAndWait();
    		Home.home.loadpage("/view/product/product.fxml");
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setHeaderText("���� ����.�����ڿ��� �����ϼ���.");
    		alert.showAndWait();
    		Home.home.loadpage("/view/product/product.fxml");
    	}
    }

    @FXML
    void back(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");
    }

    private String pimage = null;	// ���� ��� ����� ����
    
    @FXML
    void imgadd(ActionEvent event) {	// �̹��� ��� ��ư�� �������� �� 
    	// 1. ���� ���� Ŭ����
    	FileChooser fileChooser = new FileChooser();	// ���� ���ñ� Ŭ������ ��ü ����
    	// 2. ���� ���� ���� [ = �̹��� Ȯ���ڸ� �����Ҽ� �ְ�. ]
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("�̹������� : image file" , "*.jpg", "*.png", "*.gif","*.jpeg"));
    											// ��������״� �̹������� : image file �̶�� �߰�, ������ �� �ڿ� ���� �����ѰŸ� ��.
    	// 3. ���� ���ñ��� �� ��������(������ â) ����
    	File file =  fileChooser.showOpenDialog(new Stage());	
    		// ���ϼ��ð�ü�̸�.showOpenDialog(�� ��������);
    	// 4. ������ ������ ��� ����
    	imgpath.setText("���� ��� : " + file.getPath());
    	// 5. ���� ��� ����
    	pimage = file.toURI().toString();
    	    	
    	// 6. �̸����� �̹�����Ʈ�ѿ� ����
    	Image image = new Image(pimage);	// �̹��� Ŭ���� ��ü�� �����ϸ鼭 ���� ��θ� �־���.
    	img.setImage(image);	// �̹��� ��Ʈ�ѿ� �̹��� ��ü�� ��������.
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// TODO Auto-generated method stub
    	
    }
    
	
}
