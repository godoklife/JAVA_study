package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDao {

	private Connection con;			// DB������ ���Ǵ� Ŭ����
	private PreparedStatement ps;	// ���� DB �� SQL�� ������ �� �����.
	private ResultSet rs;			// ����� ������ �� ����ϴ� �������̽�
	
	public static ProductDao productDao = new ProductDao();	// DB������ �� ����Ϸ��� �ڱ��ڽ��� ����ȭ ����
	
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTime=UTC", "root", "1234");
			
		} catch (Exception e) {System.out.println("ProductDAO DB���� ���� �߻� : "+ e);}
	}
	
}
