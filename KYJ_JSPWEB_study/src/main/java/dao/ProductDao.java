package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.admin.stockadd;
import dto.Cart;
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
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
				result.add(product);
			}return result;
		} catch (Exception e) {System.out.println("ProductDao_getproductlist_exception : "+e);}
		return null;
	}
	// 3. 제품 개별 호출
	public Product getproduct(int pno) {
		String sql = "select * from product where pno="+pno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
				return product;
			}else return null;
		} catch (Exception e) {System.out.println("ProductDao_getproduct_exception : "+e);}
		return null;
	}
	// 4. 제품 수정
	
	// 4-2 제품 상태 변경
	public byte activechange (int pno, int pactive) {
		String sql = "update product set pactive="+pactive+" where pno="+pno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {System.out.println("ProductDao_activechange_exception : "+e);}
		return 0;
	}
	// 5. 제품 삭제
	
//////////////////////////////////////////////////////   재고   //////////////////////////////////////////////////////
	// 1. 제품의 재고 등록
	public boolean ssave(Stock stock) {
		String sql = "insert into stock(scolor, ssize, samount, pno) values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, stock.getScolor());
			ps.setString(2, stock.getSsize());
			ps.setInt(3, stock.getSamount());
			ps.setInt(4, stock.getPno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("ProductDao_ssave_exception : "+e);}
		return false;
	}
	// 2. 제품의 재고 호출	// int pno 인수 임시 제거 22.05.16 12:18
	public ArrayList<Stock> getStock(int pno) {
		ArrayList<Stock> tmp = new ArrayList<Stock>();
		String sql = "select * from stock where pno="+pno+" order by scolor asc, ssize desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Stock stock = new Stock(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				tmp.add(stock);
			}return tmp;
		} catch (Exception e) {System.out.println("ProductDao_getStock_exception : "+e);}
		return null;
	}
	// 3. 재고량 수정
	public boolean stockupdate(int sno, int samount) {
		String sql = "update stock set samount="+samount+" where sno="+sno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("ProductDao_stockupdate_exception : "+e);}
		return false;
	}
	
	// 4. 찜하기
	public byte savelike(int pno, int mno) {
		String sql = "select * from plike where pno="+pno+" and mno="+mno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {	// 만약 이미 찜을 해놨던 제품이면-> 삭제처리
				sql="delete from plike where plikeno="+rs.getInt(1);
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return 2;
			}else {	// 이미 찜을 한 제품이 아니라면 -> 찜 등록
				sql = "insert into plike (pno, mno) values("+pno+", "+mno+")";
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return 1;
			}
		} catch (Exception e) {System.out.println("ProductDao_savelike_exception : "+e);}
		return 3;	// 1: 등록 2: 삭제 3: DB오류
		
	}
	
	// 5. 찜 상품 하나만 가져오기
	public boolean getplike(int pno, int mno) {
		String sql = "select * from plike where pno="+pno+" and mno="+mno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}else return false;
		} catch (Exception e) {System.out.println("ProductDao_getplike_exception : "+e);}
		return false;
	}
	
//////////////////////////////////////////////////////   장바구니   //////////////////////////////////////////////////////
	
	// 1. 카트 저장
	public boolean savecart(Cart cart) {
		String sql = "select * from cart where sno = "+cart.getSno()+" and mno="+cart.getMno();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {	// 1. 만약 장바구니 내 동일한 제품이 존재하면 수량 업데이트 처리
				sql = "update cart set samount = samount + ? and totalprice = totalprice + ? where cartno = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cart.getSamount());
				ps.setInt(2, cart.getTotalprice());
				ps.setInt(3, rs.getInt(1));	// 
				ps.executeUpdate();
				return true;
			}else {	// 2. 동일한 제품이 없으면 등록 처리
				sql = "insert into cart (samount, totalprice, sno, mno) values(?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cart.getSamount());
				ps.setInt(2, cart.getTotalprice());
				ps.setInt(3, cart.getSno());
				ps.setInt(4, cart.getMno());
				ps.executeUpdate();
				return true;
			}
		} catch (Exception e) {System.out.println("ProductDao_savecart_exception : "+e);}
		return false;
	}
	// 2. 장바구니 출력 메서드
	public JSONArray getcart(int mno) {
		JSONArray jsonArray = new JSONArray();
		String sql = "select \r\n"
				+ "	A.cartno as 장바구니번호,"
				+ "    A.samount as 구매수량,"
				+ "    A.totalprice as 총가격,"
				+ "    B.scolor as 색상,"
				+ "    B.ssize as 용량,"
				+ "    B.pno as 제품번호,"
				+ "    C.pname as 제품명,"
				+ "    C.pimg as 제품이미지"
				+ "    from cart A join stock B on A.sno = B.sno join product C on B.pno = C.pno where a.mno = "+mno;
			// A : cart테이블, B : stock 테이블, C : product 테이블
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("cartno", rs.getInt(1));
				object.put("samount", rs.getInt(2));
				object.put("totalprice", rs.getInt(3));
				object.put("scolor", rs.getString(4));
				object.put("ssize", rs.getString(5));
				object.put("pno", rs.getInt(6));
				object.put("pname", rs.getString(7));
				object.put("pimg", rs.getString(8));
				// 하니씩 json객체를 json 배열에 담기
				jsonArray.put(object);
			}
			return jsonArray;
		} catch (Exception e) {System.out.println("ProductDao_getcart_exception"+e);}
		return null;
		
	}
	
	// 3. 장바구니 수량, 금액 업데이트 
	public boolean updatecart(int cartno, int samount, int totalprice) {
		String sql = "update cart set samount=?, totalprice=? where cartno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, samount);
			ps.setInt(2, totalprice);
			ps.setInt(3, cartno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("ProductDao_updatecart_exception"+e);}
		return false;
	}
	
	// 4. 장바구니 삭제
	public boolean deletecart(int cartno) {
		String sql = "delete from cart where cartno="+cartno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("deletecart"+e);}
		return false;
	}
	
//////////////////////////////////////////////////////	reserved   //////////////////////////////////////////////////////

}
