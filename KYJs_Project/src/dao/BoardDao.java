package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");
			
		}catch(Exception e) {System.out.println("BoardDao DB�ּ� ���� ���� �߻�"+e);}
	}
	
	// �޼���
	
	// 1. �۾��� �޼���
	public boolean write(Board board) { 
		try {
		
		// 1) SQL �ۼ�
			String sql = "insert board(btitle, bcontent, bwrite) values(?,?,?)";
			
		// 2) SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBwrite());
	
		// 3. SQL ����
			ps.executeUpdate();
		// 4) SQL ��� ��ȸ
			// �ܼ� �����̱⿡ ��� ��ȸ ���ʿ�.
			return true;
		}catch(Exception e) {System.out.println("�۾��� �޼��� ���� �߻�"+e);}
		return false;
		
	}
	// 2. ��� �� ȣ�� �޼���
	public ObservableList<Board> list()	{
		// * ����Ʈ ����
		ObservableList<Board> boardlist = FXCollections.observableArrayList();
		try {
			// 1. SQL �ۼ�
			String sql = "select * from board";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			// 3. SQL ����
			rs = ps.executeQuery();
			// 4. SQL ���
			while(rs.next()) {	// ���� ���ڵ尡 ���� �� ���� �ݺ�
				// 1. ��üȭ
				Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6));
				
				boardlist.add(board);
			}
			
		} catch (Exception e) {System.out.println("��� �� ȣ�� �޼��� ���� �߻�"+e);}
		return null;
	}
	
	// 3. �� ���� �޼���
	public boolean delete(int bnum) { return false; }
	
	// 4. �� ���� �޼���
	public boolean update(int bnum, String title, String content) { return false; }
	
	
	
}
