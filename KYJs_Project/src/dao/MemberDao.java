package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		String sql = "insert member(mid, mpassword, memail, maddress, mpoint, msince) value (?,?,?,?,?,?)";	// ȸ����ȣ �ȳֱ� ������ 6����.
		// 2. SQL ����
		ps = con.prepareStatement(sql);	// preparedStatement �������̽� �� ����� DB�� sql �ֱ�
		ps.setString(1, member.getMid());			// 1�� ?�� ���̵� ����ֱ�
		ps.setString(2, member.getMpassword());		// 2�� ?�� ��� ��
		ps.setString(3, member.getMemail());		
		ps.setString(4, member.getMaddress());
		ps.setInt(5, member.getMpoint());			// 5�� ?��
		ps.setString(6, member.getMsince());
		
		
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
					rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
				// rs.next() : ��� �� ���� ���ڵ�(��, ����)
				// rs.getInt(�ʵ������ȣ) : �ش� �ʵ��� �ڷ����� ���������� ��������.
				// rs.getString(�ʽ�������ȣ) : �ش� �ʽ��� �ڷ����� ���ڿ��� ��������.
			return member;
			
		}
		} catch (Exception e) {System.out.println("ȸ������ ȣ�� ���� �߻�"+e);}
		return null;
	}
	
	
	// 6. ȸ�� Ż��
	
	// 7. ȸ�� ����
	
	
	
}
