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
		} catch (Exception e) {System.out.println("DB주소 연동 오류 발생"+e);}
	}
	
	// 메서드
	
	// 아이디 중복체크 메서드 ( 인수 : DB에 넣을 아이디, 비밀번호, 이메일, 주소)
	public boolean idcheck(String id) {
		try {
		// 1. SQL 작성
			// 검색 : where * from 테이블명 where 조건 (필드명=값)
		String sql = "select * from member where mid=?";
		// 2. SQL 조작
		ps = con.prepareStatement(sql);
		ps.setString(1, id);	// 1번 ?에 인수로 받은 id 넣기
		// 3. SQL 실행
		rs = ps.executeQuery();
		// resultset(rs) 처음 기본 값은 : null
		// 4. SQL 결과
		if(rs.next()) {	// 만약 다음 결과물이 존재하면 => 해당 아이디가 존재 -> 중복 O
			return true;	// 해당 아이디는 중복이 존재
		}
		}catch (Exception e) {System.out.println(e);}
		return false;	// 해당 아이디는 중복이 없음
	}
	
	
		// 회원가입 메서드, 인수 : 멤버 클래스
	public boolean signup(Member member) {
		try {
		// 1. SQL 작성
			// [ 회원번호(자동번호=auto, 제외)를 제외한 모든 필드 삽입. ]
		String sql = "insert member(mid, mpassword, memail, maddress, mpoint, msince) value (?,?,?,?,?,?)";	// 회원번호 안넣기 때문에 6개임.
		// 2. SQL 조작
		ps = con.prepareStatement(sql);	// preparedStatement 인터페이스 내 연결된 DB에 sql 넣기
		ps.setString(1, member.getMid());			// 1번 ?에 아이디 집어넣기
		ps.setString(2, member.getMpassword());		// 2번 ?에 비번 넣
		ps.setString(3, member.getMemail());		
		ps.setString(4, member.getMaddress());
		ps.setInt(5, member.getMpoint());			// 5번 ?에
		ps.setString(6, member.getMsince());
		
		
		// 3. SQL 실행
		ps.executeUpdate();	// SQL에 insert member문 실행.
		return true;	// 성공시
		} catch (Exception e) {System.out.println(e);}
		return false;	// 실패시
	}
	
		// 2. 로그인 메서드, 인수 : 아이디, 비밀번호
	public boolean login(String id, String password) {
	// 1. sql 작성
		// and : 조건1 and 조건2	-> 이면서
		// or  : 조건1 or  조건2	-> 이거나
	try {	
	String sql = "select * from member where mid=? and mpassword=?";
	ps = con.prepareStatement(sql);
	ps.setString(1, id);
	ps.setString(2, password);
	// 2. sql 조회
	rs = ps.executeQuery();
	if(rs.next()) {
		return true;
	}
	} catch (Exception e) { System.out.println(e);}
	// 3. sql 실행
	
	// 4. sql 결과
	return false;
	}

	// 3. 아이디 찾기 메서드, 인수 : 이메일

	public String findid(String email) {
		try {
		// 1. SQL 작성
		String sql = "select * from member where memail=?";
		// 2. sQL 조작
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		// 3. SQL 실행
			// rs에 ps에 셋팅한 질의어를 실행한 값을 저장.
		rs = ps.executeQuery();
		// 4. SQL 결과
		if(rs.next()) {
			return rs.getString(2);	// 필드의 번호
		}
		} catch (Exception e) {System.out.println("아이디 찾기 예외 발생."+e);}
		
		return null;
		
		
		
//		아래 코드도 정상 동작하는 코드임.
//		try {
//			String sql = "selest * from member memail=?";
//			ps = con.prepareStatement(sql);
//			ps.setString(1, email);
//			
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				return true;
//			}
//		} catch (Exception e) {System.out.println("아이디 찾기 예외 발생"+e);}
//		return false;	// 입력한 이메일이 없는 경우
	}
	
	// 4. 비밀번호 찾기 메서드, 인수 : 아이디, 이메일
	public String findpassword(String id, String email) {
		try {
		// 1. SQL 작성
		String sql = "select * from member where mid=? and memail=?";
		// 2. SQL  조작
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, email);
		// 3. SQL 실행
		rs = ps.executeQuery();
		// 4. SQL 결과
		if(rs.next()) {
			return rs.getString(3);	// 해당하는 정보를 찾으면 3번 컬럼 반환(mpassword)
		}
		}catch(Exception e) {System.out.println("비번찾기 예외 발생"+e);}
		return null;	// 해당하는 정보가 없으면 null 반환
		}
	
	// 5. 아이디로 회원 정보 호출
	public Member getmember (String id) {
		try { 
		// 1. SQL 작성
		String sql = "select * from member where mid=?";
		// 2. SQL 조작
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		// 3. SQL 실행
		rs = ps.executeQuery();
		// 4. SQL 결과 
		if(rs.next()) {
			// 1. 객체 선언
			Member member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				// rs.next() : 결과 내 다음 레코드(줄, 가로)
				// rs.getInt(필드순서번호) : 해당 필드의 자료형을 정수형으로 가져오기.
				// rs.getString(필스순서번호) : 해당 필스의 자료형을 문자열로 가져오기.
			return member;
			
		}
		} catch (Exception e) {System.out.println("회원정보 호출 예외 발생"+e);}
		return null;
	}
	
	
	// 6. 회원 탈퇴
	
	// 7. 회원 수정
	
	
	
}
