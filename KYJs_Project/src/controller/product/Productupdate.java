package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
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
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Productupdate implements Initializable {

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
    void back(ActionEvent event) {

    }
    
    private String pimage = null;	// ���� ��� ����� ����
    @FXML
    void imgadd(ActionEvent event) {
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
    	pimage = file.toURI().toString();	// ���⿡�� ������� ��ġ�� �����.
    	    	
    	// 6. �̸����� �̹�����Ʈ�ѿ� ����
    	Image image = new Image(pimage);	// �̹��� Ŭ���� ��ü�� �����ϸ鼭 ���� ��θ� �־���.
    	img.setImage(image);	// �̹��� ��Ʈ�ѿ� �̹��� ��ü�� ��������.
    	
    	// * ���õ� �̹��� ������ ������Ʈ ������ �����ؿ���
    	try {
    	// 1. ���� �Է� ��Ʈ�� [ �̵� ���� : byte ] 
    	FileInputStream fileInputStream = new FileInputStream(file);	// file : fileChooser���� ���õ� ���� ��ü.
    	// 2. ���� ��� ��Ʈ��
    	File copyfile = new File("C:\\Users\\504\\git\\tmp\\JAVA_study\\KYJs_Project\\src\\img\\"+file.getName());
    		// ���ο� ��� ������ �뵵.
    	FileOutputStream fileOutputStream = new FileOutputStream(copyfile);
    	// 3. ����Ʈ �迭 ����
    	byte[] bytes = new byte[1024*1024*100];	// 100�ް�����Ʈ
    	// 4. �ݺ����� �̿��� inputStream�� ���� ��Ʈ���� ��� �о����
    	int size;
    	while( ( size = fileInputStream.read(bytes) ) > 0 ) {	// �о� �� ����Ʈ�� 0���� ������ ����.
    		fileOutputStream.write(bytes, 0, size);	// �о�� ����Ʈ��ŭ ��������.
    	}
    	// 5. �뷮�� ū ��쿡�� ��Ʈ�� ���� �ʼ�.
    	fileInputStream.close();
    	fileOutputStream.close();
    	// 6. ������ �̹��� ��ġ ���� ����
    	pimage = copyfile.toURI().toString();
    	
    	}catch(Exception e) {System.out.println("imgadd �޼��� ���� �߻� : "+e);}
    
    	
    }
    
    Product product = Productcontrol.select;
    
    @FXML
    void add(ActionEvent event) {
    	if(pimage == null ) {	// pimage�� �������� ������
    		pimage = Productcontrol.select.getPimage();	// ���� ��θ� �״�� ����
    	}
    	
    	String pcategory = null;
    	if(otp1.isSelected()) pcategory = "�����Ƿ�";
    	if(otp2.isSelected()) pcategory = "�����Ƿ�";
    	if(otp3.isSelected()) pcategory = "����Ʈ��";
    	if(otp4.isSelected()) pcategory = "��Ʈ��";
    	
    	Product updateproduct = new Product(Productcontrol.select.getPnum(),
    			txtpname.getText(),
    			pimage,
    			txtpcontent.getText(),
    			pcategory,
    			Integer.parseInt(txtpprice.getText()),
    			Productcontrol.select.getPactivation(),
    			null,
    			0);
    	
    	boolean result = ProductDao.productDao.update(updateproduct);
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
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	txtpname.setText(product.getPname());
    	txtpcontent.setText(product.getPcontent());
    	txtpprice.setText(product.getPprice()+"");
    	

    	
    }
    
    
    
	
}
