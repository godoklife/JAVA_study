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
		
//		memberDao = this;	// ??????????????????
		
		} catch (Exception e) {System.out.println(e);}
	}
	
	
	// �޼���
		// ȸ������ �޼���, �μ� : ��� Ŭ����
	public boolean signup(Member member) {
		try {
		// 1. SQL �ۼ�
			// [ ȸ����ȣ(�ڵ���ȣ=auto, ����)�� ������ ��� �ʵ� ����. ]
		String sql = "insert member(mid, mpassword, memail, maddress, mpoint, msince) value (?,?,?,?,?,?)";	// ȸ����ȣ, ����Ʈ �ȳֱ� ������ 5����.
		// 2. SQL ����
		ps = con.prepareStatement(sql);	// preparedStatement 
		ps.setString(1, member.getMid());
		ps.setString(2, member.getMpassword());
		ps.setString(3, member.getMemail());
		ps.setString(4, member.getMaddress());
		ps.setInt(5, member.getMpoint());
		ps.setString(6, member.getMsince());
		
		
		// 3. SQL ����
		ps.executeUpdate();
		return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
		// �α��� �޼���, �μ� : ���̵�, ��й�ȣ
	public boolean login(String id, String password) {return false;}
		// ���̵� ã�� �޼���, �μ� : �̸���
	public String findid(String email) { return null;}
		// ��й�ȣ ã�� �޼���, �μ� : ���̵�, �̸���
	public String findpassword(String id, String email) {return null;}
	
	
	
	
	
}
