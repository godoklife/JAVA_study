package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Product;

public class ProductDao {

	private Connection con;			// DB������ ���Ǵ� Ŭ����
	private PreparedStatement ps;	// ���� DB �� SQL�� ������ �� �����.
	private ResultSet rs;			// ����� ������ �� ����ϴ� �������̽�
	
	public static ProductDao productDao = new ProductDao();	// DB������ �� ����Ϸ��� �ڱ��ڽ��� ����ȭ ����
	
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://cirrus.cpfogy2aejex.ap-northeast-2.rds.amazonaws.com:3306/javafx?serverTime=UTC", "root", "rladydwns1");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");

		} catch (Exception e) {System.out.println("ProductDAO DB���� ���� �߻� : "+ e);}
	}
	
	
	// 1. ��ǰ ���
	public boolean add(Product product) {
		try {
			String sql = "insert into product (pname, pimage, pcontent, pcategory, pprice, pactivation, mnum) values(?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPimage());
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
	// 2. ��ǰ ��� [ tableview�� ������� �ʱ� ������ �ɼ�����Ʈ ��� ��̸���Ʈ ��� ����. ]
	public ArrayList<Product> list (String category, String search) {
		ArrayList<Product> productlist = new ArrayList<Product>();
		try {
			if(category==null && search == null) {	// ��� ��ǰ �� ������
				System.out.println("test1");
				String sql = "select pcategory, count(*) from product group by pcategory";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
					productlist.add(product);
				}
			}else if(search==null) {
				String sql = "select * from product where pcategory = ? order by pnum desc";
				ps = con.prepareStatement(sql);
				ps.setString(1, category);
				rs = ps.executeQuery();
			}else {			//  = : �񱳿�����, �ʵ�� like '%��%' : ���� ���Ե� �񱳿����� ->	('��' �� �Է��ص� '���ǽ�' ã����)
				String sql = "select * from product where pcategory = ? and pname like '%"+search+"%' order by pnum desc";
				ps = con.prepareStatement(sql);
				ps.setString(1, category);
				rs = ps.executeQuery();
			}
			while(rs.next()) {
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
				productlist.add(product);
		}
		return productlist;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	// 3. ��ǰ ��ȸ
	
	// 4. ��ǰ ����
	public boolean delete(int pnum) {
		try {
		String sql = "delete from product where pnum=?";
		ps = con.prepareCall(sql);
		ps.setInt(1, pnum);
		ps.executeUpdate();
		return true;
		}catch(Exception e) {System.out.println("ProductDao Exception : "+e);}
		return false;
	}
	
	// 5. ��ǰ ����
	public boolean update(Product product) {
		try {
			String sql = "update product set pname=?, pimage=?, pcontent=?, pcategory=?, pprice=?, pactivation=? where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setString(2, product.getPimage());
			ps.setString(3, product.getPcontent());
			ps.setString(4, product.getPcategory());
			ps.setInt(5, product.getPprice());
			ps.setInt(6, product.getPactivation());
			ps.setInt(7, product.getPnum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("ProductDao_add_exception : "+e);}
		return false;
	}
	
	// 6. ��ǰ �Ǹ� ���� ����
	public boolean activation(int pnum) {
		try {
			// ���� ���� ��ǰ�� ���¸� �˾ƾ� ��
			
			String sql = "select pactivation from product where pnum=? ";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)==1) {
					sql = "update product set pactivation=2 where pnum=?";
				}else if(rs.getInt(1)==2) {
					sql = "update product set pactivation=3 where pnum=?";
				}else if(rs.getInt(1)==3) {
					sql = "update product set pactivation=1 where pnum=?";
				}
				ps = con.prepareStatement(sql);
				ps.setInt(1, pnum);
				ps.executeUpdate();
				return true;
			}
		} catch (Exception e) {System.out.println("��ǰ ���� ���� �޼��� ���� �߻� : "+e);}
		return false;
	}
	
	
	
	
}
