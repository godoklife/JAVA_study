package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDao {
	
	private Connection con;			// 1. DB ����� ����ϴ� Ŭ����
	private PreparedStatement ps;	// 2. ����� DB �� SQL�� ������ �� ����ϴ� �������̽�
	private ResultSet rs;			// 3. ������� ������ �� ����ϴ� �������̽�
	
	public static BoardDao boardDao = new BoardDao();
		// �̷��� �ڱ��ڽ��� �������� �޸𸮿� �̸� �ѹ��� �÷������� ������ �޼������ �ϴ� ����ƽ���� ������ �ʿ� ����
		// BoardDao.boardDao.�ʿ��Ѹ޼��� �̷������� �����ϰ� ȣ�� ����.
	
	// ������
	public BoardDao() {
		try {
			// DB����
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.1:3306/javafx?serverTimezone=UTC","root","1234");
			
		}catch(Exception e) {System.out.println("BoardDao DB�ּ� ���� ���� �߻�"+e);}
	}
	
	// �޼���
	
	// 1. �۾��� �޼���
	public boolean write(Board board) { return false;}
	
	// 2. ��� �� ȣ�� �޼���
	public boolean boardlist() { return false; }
	
	// 3. �� ���� �޼���
	public boolean delete(int bnum) { return false; }
	
	// 4. �� ���� �޼���
	public boolean update(int bnum, String title, String content) { return false; }
	
	
	
}
