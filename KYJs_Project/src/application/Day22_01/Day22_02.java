package application.Day22_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Day22_02 {
	
	// 1. 필드
	private Connection connection;	// DB연동 객체 선언
	// 2. 생성자
	public Day22_02 () {
		try {
			// 1. DB 드라이브 클래스 호출
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. DB 연결
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					// JDBC : JAVA DATABASE CONNECTION
					// "jdbc:mysql://ip주소(지금은 로컬,내 ip):포트번호/DB이름?DB시간구역"
					"root",
					//"계정명",
					"1234");	
					//"비밀번호"
			
			// 3. 확인
			System.out.println("[ DB 연동 성공 ]");
		} catch (Exception e) {System.out.println("[ DB 연동 실패 ]"+ e);}
	}
	// 3. 메서드
	
	// 2) 삽입 메서드
	public boolean write (String 작성자, String 내용) {
		try {
		// 1. SQL 작성 [ DB에 쓰기 ] 
			// DB 내 테이블에 데이터 저장 : insert into 테이블명(필드명1, 필드명2) 
			// values(필드명1의값, 필드명2의값)
		String sql = "insert into test(writer, content) values(?, ?)";
		// 2. SQl 설정 [ 연결된 DB에 SQL 설정 ]
			// PreparedStatement : 연결된 DB에서 테이블 조작 ( 삽입, 삭제 ,수정, 생성)할때 쓰는 인터페이스
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, 작성자);
		ps.setString(2, 내용);
		// 3. SQL 실행
		ps.executeUpdate();
		return true;
		
		
		
		
		
		}catch(Exception e) {System.out.println("[ SQL 연결 실패 ]"+e);}
		// 성공시 true
		
		// 실패시 false 반환
		return false;
	}
	
	
	// 3) 호출 메서드
	public ArrayList<데이터> get (){
		
	// *
	ArrayList<데이터> 데이터목록 = new ArrayList<>();
	
	String sql = "select * from test";
			// se
	try {
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			데이터 tmp = new 데이터(
			rs.getInt(1),
			rs.getString(2),
			rs.getString(3));
			// 2. 객체를 리스트에 담아주기
			데이터목록.add(tmp);
			// 성공시 데이터목록 리스트 리턴			
			
		}
		return 데이터목록;
	} catch (Exception e) {System.out.println("불러오기 실패"+e);}
	
	// 실패시
	return null;
	}
}
