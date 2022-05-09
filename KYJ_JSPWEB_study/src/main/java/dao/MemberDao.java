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
	
	// 5. 회원정보 불러오기 메서드
	public Member getmember(String mid) {
		String sql = "select * from member where mid='"+mid+"'";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {	// 회원가입할때 중복값 검사 하기 때문에 중복값 나올 일 없음.
				Member tmp = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				return tmp;		
			}
		} catch (Exception e) {System.out.println("Memberdao_getmember_exception : "+e);}
			return null;
	}
	
	// 6. 회원정보 수정 메서드
	public boolean update(Member member) {
		try {
			if(member.getMpassword()==null) {	// 만약 비번 변경이 없다면
				String sql = "update member set mname=?, memail=?, mphone=?, maddress=? where mno=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getMname());
				ps.setString(2, member.getMemail());
				ps.setString(3, member.getMphone());
				ps.setString(4, member.getMaddress());
				ps.setInt(5, member.getMno());
			}else{
				String sql = "update member set mname=?, mpassword=?, memail=?, mphone=?, maddress=? where mno=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getMname());
				ps.setString(2, member.getMpassword());
				ps.setString(3, member.getMemail());
				ps.setString(4, member.getMphone());
				ps.setString(5, member.getMaddress());
				ps.setInt(6, member.getMno());
			}
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println("Memberdao_update_exception : "+e);}
		return false;
	}
	
	// 7. 패스워드 확인 메소드 
	public boolean passwordcheck( String mid , String mpassword ) {
		
		String sql = "select * from member where mid = '"+mid+"' and mpassword = '"+mpassword+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); if( rs.next() ) return true;
		}catch (Exception e) { System.out.println("Memberdao_passwordcheck_exception : "+e);} return false;
	}
	
	// 8. 회원 탈퇴 메서드
	public boolean delete(String mid) {
		String sql = "delete from member where mid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("Memberdao_delete_exception : "+e);}
		return false;
	}
	
	// 9. 회원번호 출력 메서드
	public int getmno(String mid) {
		String sql = "select mno from member where mid='"+mid+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else return 0;
		} catch (Exception e) {System.out.println("Memberdao_getmno_exception : "+e);}
		return 0;
	}
	
	// 10. 강사님식 회원 ID 출력 메서드
	public String getmid(int mno) {
		String sql = "select mid from member where mno="+mno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {System.out.println("Memberdao_getmid_exception : "+e);}
		return null;
	}
}
