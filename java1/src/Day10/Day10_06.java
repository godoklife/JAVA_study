package Day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day10_06 {
	public static void main(String[] args) throws IOException {
		
		// 1. ���� ��� [ �ڹ� -> ���� ]
		FileOutputStream ������� = new FileOutputStream("D:/java/java1.txt");
		// FileOutputStream : ������� Ŭ����
		// FileOutputStream("d:/java/java1.txt"); : ���ϰ��\���ϸ�.Ȯ����  | txt : �޸���
		String test = "�ڹٿ��� �Է��� �����Դϴ�.";
		�������.write(test.getBytes());	// ����
		
		// 2. ���� �Է� [ ���� -> �ڹ� ]
		FileInputStream �����Է� = new FileInputStream("D:/java/java1.txt");
		byte[] bytes = new byte[1000];
		�����Է�.read(bytes);
		System.out.println("���ϳ��� : "+new String(bytes));
		
	}	// main END
}	// class END
