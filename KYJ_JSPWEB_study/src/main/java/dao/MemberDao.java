package dao;

import dto.Member;

public class MemberDao extends Dao{
	
	public static MemberDao instance = new MemberDao();
	// 1. 회원가입 메서드
	public boolean signup(Member member) {
		String sql = "insert into member(mid, mpassword, memail, maddress) values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMemail());
			ps.setString(4, member.getMaddress());
			
			ps.executeUpdate();
			
			
			return true;
		} catch (Exception e) {System.out.println("MemberDao_signup_exception : "+e);}
		return false;
	}
}
