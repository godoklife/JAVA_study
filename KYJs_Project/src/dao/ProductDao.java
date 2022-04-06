package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Product;

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
	
	
	// 1. ��ǰ ���
	public boolean add(Product product) {
		try {
			String sql = "insert into product (pname, pimage, pcontent, pcategory, pprice, pactivation, mnum) values(?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, null);
			ps.setString(3, product.getPcontent());
			ps.setString(4, product.getPcategory());
			ps.setInt(5, product.getPprice());
			ps.setInt(6, product.getPactivation());
			ps.setInt(7, product.getMnum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("ProductDao_add_exception : "+e);}
		return false;
	}
	// 2. ��ǰ ���
	
	// 3. ��ǰ ��ȸ
	
	// 4. ��ǰ ����
	
	// 5. ��ǰ ����
	
	
	
	
}
