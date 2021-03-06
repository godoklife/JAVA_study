package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
    	// 1. 컨트롤에 입력된 데이터 가져오기
    	String pname = txtpname.getText();
    	String pcontent = txtpcontent.getText();
    	int pprice = Integer.parseInt(txtpprice.getText());
    	
    	// * 카테고리 
    	String pcategory = null;
    		if(otp1.isSelected())	pcategory = "남성의류";	// otp1라고 내가 fx:id를 정해준 라디오버튼이 눌렸다면
    		if(otp2.isSelected())	pcategory = "여성의류";
    		if(otp3.isSelected())	pcategory = "휴대폰";
    		if(otp4.isSelected())	pcategory = "노트북";
    	int mnum = Login.member.getMnum();
    	
    	// 2. 객체화
    	Product product = new Product(0, pname, pimage, pcontent, pcategory, pprice, 1, null, mnum);
    	
    	// 3. DB처리
    	boolean result = ProductDao.productDao.add(product);
    	
    	// 4. 결과 처리
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("게시글 저장이 완료되었습니다.");
    		alert.showAndWait();
    		Home.home.loadpage("/view/product/product.fxml");
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setHeaderText("저장 실패.관리자에게 문의하세요.");
    		alert.showAndWait();
    		Home.home.loadpage("/view/product/product.fxml");
    	}
    }

    @FXML
    void back(ActionEvent event) {
    	Home.home.loadpage("/view/product/product.fxml");
    }

    private String pimage = null;	// 파일 경로 저장용 변수
    
    @FXML
    void imgadd(ActionEvent event) {	// 이미지 등록 버튼을 선택했을 떄 
    	// 1. 파일 선택 클래스
    	FileChooser fileChooser = new FileChooser();	// 파일 선택기 클래스의 객체 선언
    	// 2. 파일 선택 필터 [ = 이미지 확장자만 선택할수 있게. ]
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("이미지파일 : image file" , "*.jpg", "*.png", "*.gif","*.jpeg"));
    											// 사용자한테는 이미지파일 : image file 이라고 뜨고, 선택은 그 뒤에 내가 지정한거만 됨.
    	// 3. 파일 선택기의 새 스테이지(윈도우 창) 띄우기
    	File file =  fileChooser.showOpenDialog(new Stage());	
    		// 파일선택객체이름.showOpenDialog(새 스테이지);
    	// 4. 선택한 파일의 경로 띄우기
    	imgpath.setText("파일 경로 : " + file.getPath());
    	// 5. 파일 경로 저장
    	pimage = file.toURI().toString();	// 여기에선 사용자의 위치가 저장됨.
    	    	
    	// 6. 미리보기 이미지컨트롤에 띄우기
    	Image image = new Image(pimage);	// 이미지 클래스 객체를 선언하면서 파일 경로를 넣어줌.
    	img.setImage(image);	// 이미지 컨트롤에 이미지 객체를 설정해줌.
    	
    	// * 선택된 이미지 파일을 프로젝트 폴더로 복사해오기
    	try {
    	// 1. 파일 입력 스트림 [ 이돈 단위 : byte ] 
    	FileInputStream fileInputStream = new FileInputStream(file);	// file : fileChooser에서 선택된 파일 객체.
    	// 2. 파일 출력 스트림
    	File copyfile = new File("C:\\Users\\Matebook14\\git\\JAVA_study\\KYJs_Project\\src\\img\\"+file.getName());
    		// 새로운 경로 설정의 용도.
    	FileOutputStream fileOutputStream = new FileOutputStream(copyfile);
    	// 3. 바이트 배열 선언
    	byte[] bytes = new byte[1024*1024*100];	// 최대 100메가바이트
    	// 4. 반복문을 이용한 inputStream의 파일 스트림을 모두 읽어오기
    	int size;
    	while( ( size = fileInputStream.read(bytes) ) > 0 ) {	// 읽어 온 바이트가 0보다 작으면 종료.
    		fileOutputStream.write(bytes, 0, size);	// 읽어온 바이트만큼만 내보내기.
    	}
    	// 5. 용량이 큰 경우에는 스트림 종료 필수.
    	fileInputStream.close();
    	fileOutputStream.close();
    	// 6. 서버의 이미지 위치 저장 변수
    	pimage = copyfile.toURI().toString();
    	
    	}catch(Exception e) {System.out.println("imgadd 메서드 예외 발생 : "+e);}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	// TODO Auto-generated method stub
    	
    }
    
	
}
