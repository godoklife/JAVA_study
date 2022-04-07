package controller.product;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.ProductDao;
import dto.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Productcontrol implements Initializable{

	
	
    @FXML
    private Button btnadd;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;
    
    @FXML
    private TextField txtsearch;

    @FXML
    private Button btnsearch;

    @FXML
    void accadd(ActionEvent event) {
    	Home.home.loadpage("/view/product/productadd.fxml");	// ��ǰ �߰� fxml
    	
    }
    
    @FXML
    void accsearch(ActionEvent event) {	// �˻� ��ư�� ��������
    	String search = txtsearch.getText();	// �˻�â�� �Է� �� �ؽ�Ʈ ��������
    	System.out.println("�˻�â�� �Էµ� �ؽ�Ʈ : "+txtsearch.getText());
    	show(search);
    }
    
    public static Product select;	// ���õ� ��ư�� ��ǰ�� �����ϴ� �ʵ�
    
    void show(String search) {
    	
    	if(vbox.getChildren().isEmpty()==false) {	// .isEmpty() : �ش� ��ü �� ��� �ִ��� Ȯ��
    			// vbox�� ��ü�� ��� ���� ������?
    		vbox.getChildren().remove(0);	// vbox�� ���� ��ü�� ����
    	}
    	
    	// 1. ��� ��ǰ ��������
    	ArrayList<Product> productlist = ProductDao.productDao.list(Home.category, search);
    	// 2. �׸��� Ŭ���� [ �� / �� ] 
    	GridPane gridPane = new GridPane();
    		// * �׸��� �� ����
    		gridPane.setPadding(new Insets(10));
    		// * ��ư�� �� ����
    		gridPane.setHgap(10);	// ���� ���� 10�ȼ�
    		gridPane.setVgap(10);	// ���� ���� 10�ȼ�
    	int i = 0;	// �ε����� ����
    	// 3. �ݺ���
    	for(int row = 0; row < productlist.size()/3; row++) {	// �� �ݺ���, �� �࿡ 3�� �ֱ� ���� ������ 3
    		for(int col = 0; col < 3; col++) {	// �� �ݺ���, ���� 3ĭ
    			// 1. �̹��� 
    			ImageView imageView = new ImageView(new Image(productlist.get(i).getPimage()));
    				imageView.setFitWidth(250);		// �̹��� ���� ����
    				imageView.setFitHeight(200);	// �̹��� ���� ����
    			// 2. ���� ��ư ����
    			Button button = new Button(null, imageView);
    				// *��ư ��� ���� [ CSS����, transperent : ����� ]
    				button.setStyle("fx-background-color:transperent");
    				button.setId(i+"");	// ��ư�� ���̵�(�ε���)�� String������ ����.
    				// *��ư Ŭ�� �̺�Ʈ
    				button.setOnAction(e->{
    					// 1. Ŭ���� ��ư�� id ��������
    					System.out.println(e.toString());
    					int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
    					System.out.println("e���� id�� ���� ��� : "+id);
    					// 2. Ŭ���� ��ǰ�� ����
    					select = productlist.get(id);
    					// 3. ȭ�� ��ȯ
    					Home.home.loadpage("/view/product/productview.fxml");
    				});	// ���ٽ� : �μ� -> {�����ڵ�}
    			
    			gridPane.add(button, col, row);	// �ش��ϴ� �� ��ȣ, �� ��ȣ�� ��ư ��
    			i++;
    		}
    	}
    	// * 3����� ��������
    	int row = productlist.size() / 3;
    	int remain = productlist.size() % 3;
    	if(remain!=0) {
    		for(int col = 0; col < remain; col++) {	// �� �ݺ���, ���� 3ĭ
    			// 1. �̹��� 
    			ImageView imageView = new ImageView(new Image(productlist.get(i).getPimage()));
    				imageView.setFitWidth(250);		// �̹��� ���� ����
    				imageView.setFitHeight(200);	// �̹��� ���� ����
    			// 2. ���� ��ư ����
    			Button button = new Button(null, imageView);
    				// *��ư ��� ���� [ CSS����, transperent : ����� ]
    				button.setStyle("fx-background-color:transperent");
    				button.setId(i+"");	// ��ư�� ���̵�(�ε���)�� String������ ����.
    				// *��ư Ŭ�� �̺�Ʈ
    				button.setOnAction(e->{
    					// 1. Ŭ���� ��ư�� id ��������
    					System.out.println(e.toString());
    					int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);	// ????????????????????????? �迭 ������ ����Ǵ°���??
    					String test1 = (e.toString().split(",")[0].split("=")[1]);
    					String test2 = (e.toString().split(",")[0].split("=")[2]);
    					String test3 = e.toString().split(",")[0];

    					System.out.println("e���� id�� ���� ��� : "+id);
    					System.out.println("test1 : "+test1);
    					System.out.println("test2 : "+test2);
    					System.out.println("test3 : "+test3);
    					// 2. Ŭ���� ��ǰ�� ����
    					select = productlist.get(id);
    					
    					// 3. ȭ����ȯ
    					Home.home.loadpage("/view/product/productview.fxml");
    					
    				});	// ���ٽ� : �μ� -> {�����ڵ�}
    			gridPane.add(button, col, row+1);	// �ش��ϴ� �� ��ȣ, �� ��ȣ�� ��ư ��
    			i++;
    		}
    	}
    	// 4.
    	vbox.getChildren().add(gridPane);
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	show(null);	// ó�� �Խ��� �������� null�� ����. = ���� ���
    }
	
}
