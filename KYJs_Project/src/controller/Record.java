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
		// ��ü ȸ����
		int mtotal = MemberDao.memberDao.counttotal("member");
		lblmtotal.setText(mtotal+"��");
		
		// ��ü ��ǰ��
		int ptotal = MemberDao.memberDao.counttotal("product");
		lblptotal.setText(ptotal+" ��");
		
		// ��ü �Խù���
		int btotal = MemberDao.memberDao.counttotal("board");
		lblptotal.setText(btotal+" ��");
				
		// ��¥�� ȸ�� ���� ��
		// 1.  xy�� �迭 ����
		XYChart.Series series = new XYChart.Series<>();	// 1. xy�� �迭 ���� ( ���׸� ���� ������)
			// XYChard.Series : �迭 Ŭ���� (�迭 = ���� : ��Ʈ ��� )
				// XYChard.Data : �迭 ������ Ŭ���� [ x���� ��, y���� �� ] 
		// 2. DB���� ������ ��������
			// ��¥���� ȸ������ �� üũ [ 2022-04-11, 3 ] 
			// Map �÷��� => Ű(��¥), ��(������ ��)���� �ϳ��� ��Ʈ�� ����.
			Map<String, Integer> map = MemberDao.memberDao.datetotal("member", "msince");
		// 3. �����͸� �迭�� �߰�	
			for(String key : map.keySet()) {
				// 3-1 : ������ �迭 ���� (������ : key = ��¥, value = �����ڼ�)
				XYChart.Data data =new XYChart.Data<>(key, map.get(key));
				// 3-2 : �ش� �������� ��ü�� �迭�� �߰�
				series.getData().add(data);
			}
		mbc.getData().add(series);	
		
		// ��¥�� �Խ��� �� ��
		XYChart.Series series2 = new XYChart.Series<>();
		Map<String, Integer> map2 = MemberDao.memberDao.datetotal("board", "bdate");
		
		for(String key : map2.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key, map2.get(key));
			series2.getData().add(data);
		}
		bbc.getData().add(series2);
		
		// ��¥�� ��ǰ ��� ��
		XYChart.Series series3 = new XYChart.Series<>();
		series3.setName("ī�װ��� ");
		
			// 2. �迭 ����
			XYChart.Data data = new XYChart.Data<>("�ŵ���", 10);
			// 3. �迭�� ������ �߰�
			series3.getData().add(data);
			
			XYChart.Data data2 = new XYChart.Data<>("��ȣ��", 15);
			series3.getData().add(data2);
			
		
			XYChart.Data data3 = new XYChart.Data<>("���缮", 20);
			series3.getData().add(data3);
			
		pbc.getData().add(series3);
			
		
		
		
		// ���� ��Ʈ : ī�װ��� ����
		// 1. // ObservableList ��� ���� ?? ���� ��Ʈ�� ����Ʈ �߰��Ϸ��� �ݵ�� ����ؾ���.
		ObservableList<PieChart.Data> pielist = FXCollections.observableArrayList();
			
		// 2. DB���� ī�װ��� ���� ����
		Map<String, Integer>map3 = MemberDao.memberDao.datetotal("product", "pcategory");
		
		for(String key : map3.keySet()) {
			PieChart.Data temp = new PieChart.Data(key, map3.get(key));
			pielist.add(temp);
		}
		ppc.setData(pielist);
			
		
		
		
		
		
	}
	
}
