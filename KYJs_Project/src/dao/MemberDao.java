package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import controller.login.Login;
import dto.Member;

public class MemberDao {	// DB ���� ��ü�� ���
	
	private Connection con;			// DB������ ���Ǵ� Ŭ����
	private PreparedStatement ps;	// ����� DB �� SQL�� ������ �� ���Ǵ� �������̽�
	private ResultSet rs;			// ������� �����ϴ� �������̽�

	public static MemberDao memberDao = new MemberDao();	// DB ���� ��ü;
	
	// ������
	public MemberDao() {	
		try {
		// DB ����
		Class.forName("com.mysql.cj.jdbc.Driver");	// 1. DB ����̹� ��������
//		con = DriverManager.getConnection("jdbc:mysql://���������);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC","root","1234");

			// 2. DB �ּ�, ���̵�, ��� ����
		} catch (Exception e) {System.out.println("DB�ּ� ���� ���� �߻�"+e);}
	}
	
	// �޼���
	
	// ���̵� �ߺ�üũ �޼��� ( �μ� : DB�� ���� ���̵�, ��й�ȣ, �̸���, �ּ�)
	public boolean idcheck(String id) {
		try {
		// 1. SQL �ۼ�
			// �˻� : where * from ���̺�� where ���� (�ʵ��=��)
		String sql = "select * from member where mid=?";
		// 2. SQL ����
		ps = con.prepareStatement(sql);
		ps.setString(1, id);	// 1�� ?�� �μ��� ���� id �ֱ�
		// 3. SQL ����
		rs = ps.executeQuery();
		// resultset(rs) ó�� �⺻ ���� : null
		// 4. SQL ���
		if(rs.next()) {	// ���� ���� ������� �����ϸ� => �ش� ���̵� ���� -> �ߺ� O
			return true;	// �ش� ���̵�� �ߺ��� ����
		}
		}catch (Exception e) {System.out.println(e);}
		return false;	// �ش� ���̵�� �ߺ��� ����
	}
	
	
		// ȸ������ �޼���, �μ� : ��� Ŭ����
	public boolean signup(Member member) {
		try {
		// 1. SQL �ۼ�
			// [ ȸ����ȣ(�ڵ���ȣ=auto, ����)�� ������ ��� �ʵ� ����. ]
		String sql = "insert member(mid, mpassword, memail, maddress, mpoint, msince, lastlogindate) value (?,?,?,?,?,?,?)";	// ȸ����ȣ �ȳֱ� ������ 6����.
		// 2. SQL ����
		ps = con.prepareStatement(sql);	// preparedStatement �������̽� �� ����� DB�� sql �ֱ�
		ps.setString(1, member.getMid());			// 1�� ?�� ���̵� ����ֱ�
		ps.setString(2, member.getMpassword());		// 2�� ?�� ��� ��
		ps.setString(3, member.getMemail());		
		ps.setString(4, member.getMaddress());
		ps.setInt(5, member.getMpoint());			// 5�� ?��
		ps.setString(6, member.getMsince());
		ps.setString(7, member.getLastlogindate());
		
		
		// 3. SQL ����
		ps.executeUpdate();	// SQL�� insert member�� ����.
		return true;	// ������
		} catch (Exception e) {System.out.println(e);}
		return false;	// ���н�
	}
	
		// 2. �α��� �޼���, �μ� : ���̵�, ��й�ȣ
	public boolean login(String id, String password) {
	// 1. sql �ۼ�
		// and : ����1 and ����2	-> �̸鼭
		// or  : ����1 or  ����2	-> �̰ų�
	try {	
	String sql = "select * from member where mid=? and mpassword=?";
	ps = con.prepareStatement(sql);
	ps.setString(1, id);
	ps.setString(2, password);
	// 2. sql ��ȸ
	rs = ps.executeQuery();
	if(rs.next()) {
		
		return true;
	}
	} catch (Exception e) { System.out.println(e);}
	// 3. sql ����
	
	// 4. sql ���
	return false;
	}

	// 3. ���̵� ã�� �޼���, �μ� : �̸���

	public String findid(String email) {
		try {
		// 1. SQL �ۼ�
		String sql = "select * from member where memail=?";
		// 2. sQL ����
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		// 3. SQL ����
			// rs�� ps�� ������ ���Ǿ ������ ���� ����.
		rs = ps.executeQuery();
		// 4. SQL ���
		if(rs.next()) {
			return rs.getString(2);	// �ʵ��� ��ȣ
		}
		} catch (Exception e) {System.out.println("���̵� ã�� ���� �߻�."+e);}
		
		return null;
		
		
		
//		�Ʒ� �ڵ嵵 ���� �����ϴ� �ڵ���.
//		try {
//			String sql = "selest * from member memail=?";
//			ps = con.prepareStatement(sql);
//			ps.setString(1, email);
//			
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				return true;
//			}
//		} catch (Exception e) {System.out.println("���̵� ã�� ���� �߻�"+e);}
//		return false;	// �Է��� �̸����� ���� ���
	}
	
	// 4. ��й�ȣ ã�� �޼���, �μ� : ���̵�, �̸���
	public String findpassword(String id, String email) {
		try {
		// 1. SQL �ۼ�
		String sql = "select * from member where mid=? and memail=?";
		// 2. SQL  ����
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, email);
		// 3. SQL ����
		rs = ps.executeQuery();
		// 4. SQL ���
		if(rs.next()) {
			return rs.getString(3);	// �ش��ϴ� ������ ã���� 3�� �÷� ��ȯ(mpassword)
		}
		}catch(Exception e) {System.out.println("���ã�� ���� �߻�"+e);}
		return null;	// �ش��ϴ� ������ ������ null ��ȯ
		}
	
	// 5. ���̵�� ȸ�� ���� ȣ��
	public Member getmember (String id) {
		try { 
		// 1. SQL �ۼ�
		String sql = "select * from member where mid=?";
		// 2. SQL ����
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		// 3. SQL ����
		rs = ps.executeQuery();
		// 4. SQL ��� 
		if(rs.next()) {
			// 1. ��ü ����
			Member member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
				// rs.next() : ��� �� ���� ���ڵ�(��, ����)
				// rs.getInt(�ʵ������ȣ) : �ش� �ʵ��� �ڷ����� ���������� ��������.
				// rs.getString(�ʽ�������ȣ) : �ش� �ʽ��� �ڷ����� ���ڿ��� ��������.
			return member;
			
		}
		} catch (Exception e) {System.out.println("ȸ������ ȣ�� ���� �߻�"+e);}
		return null;
	}
	
	// 6. ȸ�� Ż��	[ ȸ����ȣ�� �μ��� �޾� �ش� ȸ����ȣ�� ���ڵ� �ĺ� �� ���� ]
	public boolean delete(int num) {
		try {
		// 1. SQL �ۼ�
		String sql = "delete from member where mnum=?";
			// delete from ���̺�� where ����
		// 2. SQL ����
		ps = con.prepareStatement(sql);
		ps.setInt(1, num);
		// 3. SQL ����
		ps.executeUpdate();
			// insert, update, delete : executeUpdate() ���.
		// 4. SQL ���
		return true;	// ������ true ��ȯ
		}catch (Exception e) { System.out.println("ȸ�� Ż�� ���� �߻�"+ e);}
		return false;	// ���� �� false ��ȯ
	}
	
	// 7. ȸ�� ����	[ ȸ����ȣ, �̸���, �ּҸ� �μ��� �޾Ƽ� �����ϱ�(ȸ����ȣ�� �������� ����) ]
	
	public boolean update(int num, String email, String address) {
		try {
			// 1. SQL �ۼ�	
				// update ���̺�� set �ʵ��1=������1, �ʵ��2=������2 where ����
			String sql = "update member set memail=?, maddress=? where mnum=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);		
			ps.setString(1, email);
			ps.setString(2, address);
			ps.setInt(3, num);
			// 3. SQL ����
			ps.executeUpdate();
			// 4. SQL Ȯ��
			return true;		
		} catch (Exception e) {System.out.println("ȸ������ ���� ���� �߻�"+e);}
		return false;
	}
/////////////////////////////////////////////    		
	// 7-1 ���� 10�� �߰��� �޼���
	public void updatepoint(int num, int mpoint, String nowdate) {
		try {
			// 1. SQL �ۼ�	
				// update ���̺�� set �ʵ��1=������1, �ʵ��2=������2 where ����
			String sql = "update member set mpoint=?, lastlogindate=? where mnum=?";
			// 2. SQL ����
			ps = con.prepareStatement(sql);		
			ps.setInt(1, mpoint);
			ps.setString(2, nowdate);
			ps.setInt(3, num);
			// 3. SQL ����
			ps.executeUpdate();
			// 4. SQL Ȯ��
		} catch (Exception e) {System.out.println("ȸ������ ���� �߰� ���� �߻�"+e);}
	}
/////////////////////////////////////////////    	
	
	public String getmemberid (int mnum) {
		try { 
		// 1. SQL �ۼ�
		String sql = "select mid from member where mnum=?";	
			// member ���̺��� mnum�� �������� �˻��ؼ� mid�� �������ڴ�.
		// 2. SQL ����
		ps = con.prepareStatement(sql);
		ps.setInt(1, mnum);
		// 3. SQL ����
		rs = ps.executeQuery();
		// 4. SQL ��� 
		if(rs.next()) {
			String userid = rs.getString(1);
			return userid;
		}else
			return null;
		} catch (Exception e) {System.out.println("ȸ������ ȣ�� ���� �߻�"+e);}
		return null;
	}
	///////////////////////////////////////////////////////////////////////////
	// 9. ���̺��� ��ü �ʵ�� ��ȯ
	public int counttotal(String table) {
		String sql = "select count(*) from "+table;	// 
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {System.out.println(e);}
		return 0;
	}
	///////////////////////////////////////////////////////////////////////////
	
	// 10. (�μ� : ���̺��, �ʵ�� ) �� �޾Ƽ� ��¥�� ���� ��ȯ
	public Map<String, Integer> datetotal(String table, String field){
		Map<String, Integer> map = new HashMap<>();
		String sql = "select substring_index("+field+", ' ', 1), count(*) from "+table+" group by substring_index("+field+", ' ', 1)";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
			return map;
		} catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	// 11. ī�װ��� ����	// 10���� ���յ�	
//	public Map<String, Integer> countcategory() {
//		Map<String, Integer> map = new HashMap<>();
//		String sql = "select pcategory, count(*) from product group by pcategory";
//		try {
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				map.put(rs.getString(1), rs.getInt(2));
//			}
//			return map;
//		} catch (Exception e) {System.out.println(e);}
//		return null;
//		
//	}
	
}
