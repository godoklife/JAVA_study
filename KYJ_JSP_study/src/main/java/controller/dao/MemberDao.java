package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.dto.Board;
import controller.dto.Member;

public class MemberDao {
	private Connection con;			// DB 연결 클래스
	private PreparedStatement ps;	// DB 조작 
	private ResultSet rs;			// DB 결과 

	public MemberDao() {
		// jdbc : java data base connecter
			// 1. project build path에 mysqljdbc.jar 추가
			// 2. webapp/web-inf/lib/에도 복사-붙여넣기.
		
		// 1. 드라이브
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest?serverTimezone=UTC","root","1234");
			System.out.println("연동 성공!");
		} catch (Exception e) {System.out.println("MemberDao connection exception : "+e);}
		
	}
	
	public boolean signup(Member member) {
		
		// 1. SQL 질의어 작성
		String sql = "insert into member(mid, mpassword, mname) values(?, ?, ?)";
				// 모든 필드에 순차적으로 넣을 때는 컬럼명 생략하고 바로 values(?, ?, ?, ?) 작성 가능.
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("MemberDao_signup_exception : "+e);}
		return false;
	}
	
	public Member login(String id, String password) {
		
		String sql = "select * from member where mid=? and mpassword=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				Member result = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return result;
			}
		} catch (Exception e) {System.out.println("MemberDao_login_exception : "+e);}
		return null;
	}
	
	public void signout(int mnum) {
		String sql = "delete from member where mnum="+mnum;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			
		}catch (Exception e) {System.out.println("MemberDao_signout_exception : "+e);}
	}
	
	public boolean write(Board board) {
		String sql = "insert into board (btitle, bcontent, bwriter, bdate) values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwriter());
			ps.setString(4, board.getBdate());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("MemberDao_write_exception : "+e);}
		return false;
	}
	
}
