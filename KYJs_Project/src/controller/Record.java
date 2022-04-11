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
		XYChart.Series series = new XYChart.Series<>();	// 1. xy�� �迭 ���� ( ���׸� ���� ������)
			// ��¥���� ȸ������ �� üũ [ 2022-04-11, 3 ] 
			// Map �÷��� => Ű(��¥), ��(������ ��)���� �ϳ��� ��Ʈ�� ����.
			Map<String, Integer> map = MemberDao.memberDao.datetotal();
			
			for(String key : map.keySet()) {
				XYChart.Data data =new XYChart.Data<>(key, map.get(key));
				series.getData().add(data);
			}
	
		
	}
	
}
