package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberDao {	// DB 접근 객체로 사용
	
	private Connection con;			// DB연동시 사용되는 클래스
	private PreparedStatement ps;	// 연결된 DB 내 SQL을 조작할 때 사용되는 인터페이스
	private ResultSet rs;			// 결과물을 조작하는 인터페이스

	public static MemberDao memberDao = new MemberDao();	// DB 연동 객체;
	
	
	// 생성자
	public MemberDao() {	
		try {
		// DB 연동
		Class.forName("com.mysql.cj.jdbc.Driver");	// 1. DB 드라이버 가져오기
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
			// 2. DB 주소, 아이디, 비번 연동
		
//		memberDao = this;	// ??????????????????
		
		} catch (Exception e) {System.out.println(e);}
	}
	
	
	// 메서드
		// 회원가입 메서드, 인수 : 멤버 클래스
	public boolean signup(Member member) {
		try {
		// 1. SQL 작성
			// [ 회원번호(자동번호=auto, 제외)를 제외한 모든 필드 삽입. ]
		String sql = "insert member(mid, mpassword, memail, maddress, mpoint, msince) value (?,?,?,?,?,?)";	// 회원번호, 포인트 안넣기 때문에 5개임.
		// 2. SQL 조작
		ps = con.prepareStatement(sql);	// preparedStatement 
		ps.setString(1, member.getMid());
		ps.setString(2, member.getMpassword());
		ps.setString(3, member.getMemail());
		ps.setString(4, member.getMaddress());
		ps.setInt(5, member.getMpoint());
		ps.setString(6, member.getMsince());
		
		
		// 3. SQL 실행
		ps.executeUpdate();
		return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
		// 로그인 메서드, 인수 : 아이디, 비밀번호
	public boolean login(String id, String password) {return false;}
		// 아이디 찾기 메서드, 인수 : 이메일
	public String findid(String email) { return null;}
		// 비밀번호 찾기 메서드, 인수 : 아이디, 이메일
	public String findpassword(String id, String email) {return null;}
	
	
	
	
	
}
