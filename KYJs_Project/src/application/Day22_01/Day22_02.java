package application.Day22_01;

import java.sql.Connection;
import java.sql.DriverManager;

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
	
}
