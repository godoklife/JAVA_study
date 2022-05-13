package dao;

import java.util.ArrayList;

import dto.Category;
import dto.Product;
import dto.Stock;

public class ProductDao extends Dao{
	private ProductDao() {super();}
	public static ProductDao instance = new ProductDao();
	private static ProductDao getProductDao() {
		return instance;
	}
	
	
//////////////////////////////////////////////////////   카테고리   //////////////////////////////////////////////////////
	// 1. 카테고리 등록 [ C ] 
		public byte csave(String cname) {
			String sql = "insert into category(cname) values('"+cname+"')";
			try {
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return 1;
			} catch (Exception e) {System.out.println("ProductDao_csave_exception : "+e);}
			return 0;
		}
	// 2. 카테고리 호출 [ R ]
		public ArrayList<Category> getcategorylist(){
			ArrayList<Category> tmp = new ArrayList<Category>();
			String sql = "select * from category";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					Category tmp2 = new Category(rs.getInt(1), rs.getString(2));
					tmp.add(tmp2);
				}return tmp;
			} catch (Exception e) {System.out.println("ProductDao_getcategorylist_exception : "+e);}
			return null;
		}
	// 3. 카테고리 수정 [ U ] 
		
	// 4. 타케고리 삭제 [ D ]
//////////////////////////////////////////////////////   제품   //////////////////////////////////////////////////////
	// 1. 제품 등록
	public byte psave(Product product) {
		
		String sql = "insert into product(pname, pprice, pdiscount, pimg, cno) values(?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setInt(2, product.getPprice());
			ps.setFloat(3, product.getPdiscount());
			ps.setString(4, product.getPimg());
			ps.setInt(5, product.getCno());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {System.out.println("ProductDao_psave : "+e);}
		return 0;
	}
	// 2. 모든 제품 호출
	public ArrayList<Product> getproductlist(){
		String sql = "select * from product";
		ArrayList<Product> result = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product(rs.getInt(1), sql, 0, 0, 0, sql, 0);
			}
		} catch (Exception e) {System.out.println("ProductDao_getproductlist_exception : "+e);}
		return null;
	}
	// 3. 제품 개별 호출
	public Product getproduct() {
		return null;
	}
	// 4. 제품 수정
	
	// 5. 제품 삭제
	
//////////////////////////////////////////////////////   재고   //////////////////////////////////////////////////////
	// 1. 제품의 재고 등록
	public boolean ssave() {
		return false;
	}
	// 2. 제품의 재고 호출
	public Stock getStock() {
		return null;
	}
	
	
//////////////////////////////////////////////////////   reserved   //////////////////////////////////////////////////////
	
	
	
	
	
	
}
