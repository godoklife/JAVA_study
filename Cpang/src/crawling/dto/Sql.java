package crawling.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sql {
	
	private int gno;
	private String title;
	private String url;
	private float discountrate;
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static Sql instance = new Sql();
	
	public Sql() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coupang?serverTimezone=UTC", "root", "1234");
		} catch (Exception e) {System.out.println(e);}
		
	}
	
	@Override
	public String toString() {
		return "Sql [gno=" + gno + ", title=" + title + ", url=" + url + ", discountrate=" + discountrate + "]";
	}

	public Sql(int gno, String title, String url, float discountrate) {
		super();
		this.gno = gno;
		this.title = title;
		this.url = url;
		this.discountrate = discountrate;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getDiscountrate() {
		return discountrate;
	}

	public void setDiscountrate(float discountrate) {
		this.discountrate = discountrate;
	}
	
	// 1. 검색 결과 sql에 저장
	public boolean savesearch(String title, String url) {
		String sql = "insert into googlesearch(title, url, discountrate) values(?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, url);
			ps.setFloat(3, -1);	// 할인률 -1은 아직 연산 안한것.
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("Sql_savesearch_exception : "+e);}
		return false;
	}
	

}
