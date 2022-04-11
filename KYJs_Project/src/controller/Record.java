package controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Record implements Initializable{
	
	@FXML
	private Label lblmtotal;
	
	@FXML
	private Label lblptotal;
	
	@FXML
	private Label lblbtotal;

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
		XYChart.Series series = new XYChart.Series<>();	// 1. xy축 계열 생성 ( 제네릭 내가 지웠음)
			// 날짜별로 회원가입 수 체크 [ 2022-04-11, 3 ] 
			// Map 컬렉션 => 키(날짜), 값(가입자 수)으로 하나의 엔트리 구성.
			Map<String, Integer> map = MemberDao.memberDao.datetotal();
			
			for(String key : map.keySet()) {
				XYChart.Data data =new XYChart.Data<>(key, map.get(key));
				series.getData().add(data);
			}
	
		
	}
	
}
