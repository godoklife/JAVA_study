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
    	Home.home.loadpage("/view/product/productadd.fxml");	// 제품 추가 fxml
    	
    }
    
    @FXML
    void accsearch(ActionEvent event) {	// 검색 버튼을 눌렀을떄
    	String search = txtsearch.getText();	// 검색창에 입력 된 텍스트 가져오기
    	System.out.println("검색창에 입력된 텍스트 : "+txtsearch.getText());
    	show(search);
    }
    
    public static Product select;	// 선택된 버튼의 제품을 저장하는 필드
    
    void show(String search) {
    	
    	if(vbox.getChildren().isEmpty()==false) {	// .isEmpty() : 해당 객체 가 비어 있는지 확인
    			// vbox내 객체가 비어 있지 않으면?
    		vbox.getChildren().remove(0);	// vbox내 기존 객체를 삭제
    	}
    	
    	// 1. 모든 제품 가져오기
    	ArrayList<Product> productlist = ProductDao.productDao.list(Home.category, search);
    	// 2. 그리드 클래스 [ 행 / 열 ] 
    	GridPane gridPane = new GridPane();
    		// * 그리드 간 여백
    		gridPane.setPadding(new Insets(10));
    		// * 버튼들 간 여맥
    		gridPane.setHgap(10);	// 세로 여백 10픽셀
    		gridPane.setVgap(10);	// 가로 여백 10픽셀
    	int i = 0;	// 인덱스용 변수
    	// 3. 반복문
    	for(int row = 0; row < productlist.size()/3; row++) {	// 행 반복문, 한 행에 3열 넣기 위해 나누기 3
    		for(int col = 0; col < 3; col++) {	// 열 반복문, 열은 3칸
    			// 1. 이미지 
    			ImageView imageView = new ImageView(new Image(productlist.get(i).getPimage()));
    				imageView.setFitWidth(250);		// 이미지 가로 길이
    				imageView.setFitHeight(200);	// 이미지 세로 길이
    			// 2. 사진 버튼 생성
    			Button button = new Button(null, imageView);
    				// *버튼 배경 제거 [ CSS형식, transperent : 투명색 ]
    				button.setStyle("fx-background-color:transperent");
    				button.setId(i+"");	// 버튼에 아이디(인덱스)를 String형으로 지정.
    				// *버튼 클릭 이벤트
    				button.setOnAction(e->{
    					// 1. 클릭한 버튼의 id 가져오기
    					System.out.println(e.toString());
    					int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
    					System.out.println("e에서 id만 빼온 결과 : "+id);
    					// 2. 클릭한 제품을 저장
    					select = productlist.get(id);
    					// 3. 화면 전환
    					Home.home.loadpage("/view/product/productview.fxml");
    				});	// 람다식 : 인수 -> {실행코드}
    			
    			gridPane.add(button, col, row);	// 해당하는 열 번호, 행 번호에 버튼 쿠가
    			i++;
    		}
    	}
    	// * 3배수의 나머지값
    	int row = productlist.size() / 3;
    	int remain = productlist.size() % 3;
    	if(remain!=0) {
    		for(int col = 0; col < remain; col++) {	// 열 반복문, 열은 3칸
    			// 1. 이미지 
    			ImageView imageView = new ImageView(new Image(productlist.get(i).getPimage()));
    				imageView.setFitWidth(250);		// 이미지 가로 길이
    				imageView.setFitHeight(200);	// 이미지 세로 길이
    			// 2. 사진 버튼 생성
    			Button button = new Button(null, imageView);
    				// *버튼 배경 제거 [ CSS형식, transperent : 투명색 ]
    				button.setStyle("fx-background-color:transperent");
    				button.setId(i+"");	// 버튼에 아이디(인덱스)를 String형으로 지정.
    				// *버튼 클릭 이벤트
    				button.setOnAction(e->{
    					// 1. 클릭한 버튼의 id 가져오기
    					System.out.println(e.toString());
    					int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);	// ????????????????????????? 배열 순서가 어찌되는거지??
    					String test1 = (e.toString().split(",")[0].split("=")[1]);
    					String test2 = (e.toString().split(",")[0].split("=")[2]);
    					String test3 = e.toString().split(",")[0];

    					System.out.println("e에서 id만 빼온 결과 : "+id);
    					System.out.println("test1 : "+test1);
    					System.out.println("test2 : "+test2);
    					System.out.println("test3 : "+test3);
    					// 2. 클릭한 제품을 저장
    					select = productlist.get(id);
    					
    					// 3. 화면전환
    					Home.home.loadpage("/view/product/productview.fxml");
    					
    				});	// 람다식 : 인수 -> {실행코드}
    			gridPane.add(button, col, row+1);	// 해당하는 열 번호, 행 번호에 버튼 쿠가
    			i++;
    		}
    	}
    	// 4.
    	vbox.getChildren().add(gridPane);
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	show(null);	// 처음 게시판 열릴때는 null값 삽입. = 전부 출력
    }
	
}
