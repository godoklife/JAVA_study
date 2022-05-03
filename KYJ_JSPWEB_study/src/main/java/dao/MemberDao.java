package dao;

import dto.Member;

public class MemberDao extends Dao{
	
	public static MemberDao instance = new MemberDao();
	
	public MemberDao() {
		super();	// 부모클래스 생성자 호출하기
	}
	
	
	// 1. 회원가입 메서드
	public boolean signup(Member member) {
		String sql = "insert into member(mid, mpassword, mname, mphone, memail, maddress) values(?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMphone());
			ps.setString(5, member.getMemail());
			ps.setString(6, member.getMaddress());
			ps.executeUpdate();
			
			return true;
		} catch (Exception e) {System.out.println("MemberDao_signup_exception : "+e);}
		return false;
	}
	
	// 2. 아이디 유효성 검사 메서드
	public boolean idcheck(String mid) {
		String sql = "select mid from member where mid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}else {
				return true;
			}
		} catch (Exception e) {System.out.println("MemberDao_idcheck_exception : "+e);}
		return false;
	}
	
	// 3. 이메일 중복 체크 메서드
	public boolean emailcheck(String email) {
		String sql = "select * from member where memail="+"'"+email+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}else return true;
		} catch (Exception e) {System.out.println("Memberdao_emailcheck_exception : "+e);}
		return false;
	}
	
	// 4. 로그인 메서드
	public int login(String mid, String mpassword) {
		String sql = "select * from member where mid='"+mid+"' and mpassword='"+mpassword+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;	// 로그인 성공시 1 리턴
			}else return 2;	// 동일한 계정 정보 없으면 2 리턴
		} catch (Exception e) {System.out.println("MemberDao_login_exception : "+e);}
		return 3;	// DB 예외 발생시 3 리턴
	}
	
}
