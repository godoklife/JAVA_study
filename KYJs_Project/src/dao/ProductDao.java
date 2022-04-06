package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Product;

public class ProductDao {

	private Connection con;			// DB연동에 사용되는 클래스
	private PreparedStatement ps;	// 얀결된 DB 내 SQL을 조작할 때 사용함.
	private ResultSet rs;			// 결과물 조작할 때 사용하는 인터페이스
	
	public static ProductDao productDao = new ProductDao();	// DB연동할 때 사용하려고 자기자신을 정적화 선언
	
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTime=UTC", "root", "1234");
			
		} catch (Exception e) {System.out.println("ProductDAO DB연동 예외 발생 : "+ e);}
	}
	
	
	// 1. 제품 등록
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
	// 2. 제품 출력
	
	// 3. 제품 조회
	
	// 4. 제품 삭제
	
	// 5. 제품 수정
	
	
	
	
}
