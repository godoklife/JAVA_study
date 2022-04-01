package application.Day22_01;

import java.sql.Connection;
import java.sql.DriverManager;

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
	
}
