package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.Reply;
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
//			con = DriverManager.getConnection("jdbc:mysql://remoteaddress");
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
			String sql = "select * from javafx.board";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			// 3. SQL ����
			rs = ps.executeQuery();
			// 4. SQL ���
			while(rs.next()) {	// ���� ���ڵ尡 ���� �� ���� �ݺ�
				// 1. ��üȭ
				Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6));
				
				// 2. ��ü�� ����Ʈ�� �ֱ�
				boardlist.add(board);
				
			}
			return boardlist;
			
		} catch (Exception e) {System.out.println("��� �� ȣ�� �޼��� ���� �߻�"+e);}
		return null;
	}
	
	// 3. �� ���� �޼���
	public boolean delete(int bnum) { 
		try {
		// 1. SQL �ۼ�
		String sql = "delete from board where bnum=?";
		// 2. SQL ����
		ps = con.prepareStatement(sql);
		ps.setInt(1, bnum);
		// 3. SQL ����
		ps.executeUpdate();
		// 4. SQL ���
		return true;
		} catch(Exception e) {System.out.println("�� �輼 �޼��� ���� �߻�"+e);}
		return false;
	}
	
	// 4. �� ���� �޼���
	public boolean update(int bnum, String title, String content) { 
		
		try {
			// 1. SQL �ۼ�
			String sql = "update board set btitle=?, bcontent=? where bnum=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, bnum);
			// 3. SQL ����
			ps.executeUpdate();
			// 4. SQL ���
			return true;
		} catch (Exception e) {System.out.println("�� ���� �޼��� ���� �߻� : "+e);}
		
		return false; 
	}
	
	// 5. ���� �ۼ� �޼���
	public boolean rwrite(Reply reply) {
		try {
			String sql = "insert into reply(rcontent, rwrite, bnum)values(?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setString(2, reply.getRwrite());
			ps.setInt(3, reply.getBnum());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("���� �ۼ� �޼��� ���� �߻� : "+e);}
		return false;
	}
	
	// 6. ���� ���� �޼���
	public ObservableList<Reply> replylist(int bnum) {
		ObservableList<Reply> replylist = FXCollections.observableArrayList();
		
		try {
		String sql = "select * from reply where bnum = ?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, bnum);
		rs = ps.executeQuery();
		while(rs.next()) {
			// ������ ������ �ΰ��̸� ��üȭ ����
			if( !(rs.getString(2)==null)) {
			Reply reply = new Reply(rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getInt(5));
			replylist.add(reply);
			}
		}
		return replylist;
		} catch (Exception e) {System.out.println("���� ȣ�� �޼��� ");}
		return null;
	}
	
	// 7-1 ������ null�� ������ ��ȸ�ؼ� �ִ��� �������� Ȯ��.(�� �����ʹ� �ʿ� ����, null ������ �Խñ� ù ��ȸ �÷��� ����)
	public boolean nullreplycheck(String mid, int bnum){
		String sql = "select * from reply where rcontent is null and bnum=? and substring_index(rdate, ' ', 1)=curdate() and rwrite = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			ps.setString(2, mid);
			rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (Exception e) {System.out.println("nullreply method Exception : "+e);}
		return false;
	}
	
	// 7-2. ��ȸ�� ī��Ʈ ��
	public void viewcountup(int count, int bnum) {
		System.out.println("ī��Ʈ ��!");
		try {
			String sql = "update board set bview=? where bnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setInt(2, bnum);
			ps.executeUpdate();
		} catch (Exception e) {System.out.println("viewcountup method Exception : "+e);}
	
		
	}
}
