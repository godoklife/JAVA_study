package application.Day22_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Day22_02 {
	
	// 1. �ʵ�
	private Connection connection;	// DB���� ��ü ����
	// 2. ������
	public Day22_02 () {
		try {
			// 1. DB ����̺� Ŭ���� ȣ��
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. DB ����
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC",
					// JDBC : JAVA DATABASE CONNECTION
					// "jdbc:mysql://ip�ּ�(������ ����,�� ip):��Ʈ��ȣ/DB�̸�?DB�ð�����"
					"root",
					//"������",
					"1234");	
					//"��й�ȣ"
			
			// 3. Ȯ��
			System.out.println("[ DB ���� ���� ]");
		} catch (Exception e) {System.out.println("[ DB ���� ���� ]"+ e);}
	}
	// 3. �޼���
	
	// 2) ���� �޼���
	public boolean write (String �ۼ���, String ����) {
		try {
		// 1. SQL �ۼ� [ DB�� ���� ] 
			// DB �� ���̺� ������ ���� : insert into ���̺��(�ʵ��1, �ʵ��2) 
			// values(�ʵ��1�ǰ�, �ʵ��2�ǰ�)
		String sql = "insert into test(writer, content) values(?, ?)";
		// 2. SQl ���� [ ����� DB�� SQL ���� ]
			// PreparedStatement : ����� DB���� ���̺� ���� ( ����, ���� ,����, ����)�Ҷ� ���� �������̽�
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, �ۼ���);
		ps.setString(2, ����);
		// 3. SQL ����
		ps.executeUpdate();
		return true;
		
		
		
		
		
		}catch(Exception e) {System.out.println("[ SQL ���� ���� ]"+e);}
		// ������ true
		
		// ���н� false ��ȯ
		return false;
	}
	
	
	// 3) ȣ�� �޼���
	public ArrayList<������> get (){
		
	// *
	ArrayList<������> �����͸�� = new ArrayList<>();
	
	String sql = "select * from test";
			// se
	try {
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			������ tmp = new ������(
			rs.getInt(1),
			rs.getString(2),
			rs.getString(3));
			// 2. ��ü�� ����Ʈ�� ����ֱ�
			�����͸��.add(tmp);
			// ������ �����͸�� ����Ʈ ����			
			
		}
		return �����͸��;
	} catch (Exception e) {System.out.println("�ҷ����� ����"+e);}
	
	// ���н�
	return null;
	}
}
