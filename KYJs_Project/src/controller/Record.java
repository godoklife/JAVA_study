package controller;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import controller.product.Productcontrol;
import dao.MemberDao;
import dao.ProductDao;
import dto.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Record implements Initializable{
	
	@FXML
	private Label lblmtotal;
	
	@FXML
	private Label lblptotal;
	
	@FXML
	private Label lblbtotal;
	
    @FXML
    private BarChart mbc;

    @FXML
    private BarChart pbc;

    @FXML
    private BarChart bbc;
    
    @FXML
    private PieChart ppc;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 전체 회원수
		int mtotal = MemberDao.memberDao.counttotal("member");
		lblmtotal.setText(mtotal+"명");
		
		// 전체 제품수
		int ptotal = MemberDao.memberDao.counttotal("product");
		lblptotal.setText(ptotal+" 개");
		
		// 전체 게시물수
		int btotal = MemberDao.memberDao.counttotal("board");
		lblptotal.setText(btotal+" 개");
				
		// 날짜별 회원 가입 수
		// 1.  xy축 계열 생성
		XYChart.Series series = new XYChart.Series<>();	// 1. xy축 계열 생성 ( 제네릭 내가 지웠음)
			// XYChard.Series : 계열 클래스 (계열 = 범례 : 차트 용어 )
				// XYChard.Data : 계열 데이터 클래스 [ x축의 값, y축의 값 ] 
		// 2. DB에서 데이터 가져오기
			// 날짜별로 회원가입 수 체크 [ 2022-04-11, 3 ] 
			// Map 컬렉션 => 키(날짜), 값(가입자 수)으로 하나의 엔트리 구성.
			Map<String, Integer> map = MemberDao.memberDao.datetotal("member", "msince");
		// 3. 데이터를 계열에 추가	
			for(String key : map.keySet()) {
				// 3-1 : 데이터 계열 선언 (생성자 : key = 날짜, value = 가입자수)
				XYChart.Data data =new XYChart.Data<>(key, map.get(key));
				// 3-2 : 해당 데이터의 객체를 계열에 추가
				series.getData().add(data);
			}
		mbc.getData().add(series);	
		
		// 날짜별 게시판 글 수
		XYChart.Series series2 = new XYChart.Series<>();
		Map<String, Integer> map2 = MemberDao.memberDao.datetotal("board", "bdate");
		
		for(String key : map2.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key, map2.get(key));
			series2.getData().add(data);
		}
		bbc.getData().add(series2);
		
		// 날짜별 제품 등록 수
		XYChart.Series series3 = new XYChart.Series<>();
		series3.setName("카테고리별 ");
		
			// 2. 계열 선언
			XYChart.Data data = new XYChart.Data<>("신동엽", 10);
			// 3. 계열에 데이터 추가
			series3.getData().add(data);
			
			XYChart.Data data2 = new XYChart.Data<>("강호동", 15);
			series3.getData().add(data2);
			
		
			XYChart.Data data3 = new XYChart.Data<>("유재석", 20);
			series3.getData().add(data3);
			
		pbc.getData().add(series3);
			
		
		
		
		// 원형 차트 : 카테고리별 개수
		// 1. // ObservableList 사용 이유 ?? 원형 차트에 리스트 추가하려면 반드시 사용해야함.
		ObservableList<PieChart.Data> pielist = FXCollections.observableArrayList();
			
		// 2. DB에서 카테고리병 개수 추출
		Map<String, Integer>map3 = MemberDao.memberDao.datetotal("product", "pcategory");
		
		for(String key : map3.keySet()) {
			PieChart.Data temp = new PieChart.Data(key, map3.get(key));
			pielist.add(temp);
		}
		ppc.setData(pielist);
			
		
		
		
		
		
	}
	
}
