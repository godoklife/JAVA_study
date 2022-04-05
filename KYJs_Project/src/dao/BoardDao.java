package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDao {
	
	private Connection con;			// 1. DB 연결시 사용하는 클래스
	private PreparedStatement ps;	// 2. 연결된 DB 내 SQL을 조잘할 떄 사용하는 인터페이스
	private ResultSet rs;			// 3. 결과물을 조작할 때 사용하는 인터페이스
	
	public static BoardDao boardDao = new BoardDao();
		// 이렇게 자기자신을 정적으로 메모리에 미리 한번만 올려놓으면 나머지 메서드들을 싹다 스테틱으로 선언할 필요 없이
		// BoardDao.boardDao.필요한메서드 이런식으로 간단하게 호출 가능.
	
	// 생성자
	public BoardDao() {
		try {
			// DB연동
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.1:3306/javafx?serverTimezone=UTC","root","1234");
			
		}catch(Exception e) {System.out.println("BoardDao DB주소 연동 예외 발생"+e);}
	}
	
	// 메서드
	
	// 1. 글쓰기 메서드
	public boolean write(Board board) { return false;}
	
	// 2. 모든 글 호출 메서드
	public boolean boardlist() { return false; }
	
	// 3. 글 삭제 메서드
	public boolean delete(int bnum) { return false; }
	
	// 4. 글 수정 메서드
	public boolean update(int bnum, String title, String content) { return false; }
	
	
	
}
