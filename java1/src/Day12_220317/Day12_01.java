package Day12_220317;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Day12_01 {
	public static void main(String[] args) throws IOException {
		
		// P.496 String Ŭ����
	byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};	
	
	String str1 = new String(bytes);	
	// �ڹٴ� �⺻������ �ƽ�Ű�ڵ� ���. ���� bytes�� ������ �ƽ�Ű �ڵ�� �ؼ���.
	System.out.println(str1);
	
	String str2 = new String(bytes, 6, 4);	// 6�� �ε���(74)���� 4���� ����ִ´�.
	System.out.println(str2);
	
	// P.498 ����2
		// System.out : �ý��� Ŭ���� �� ��� �ʵ�
		// System.in : �ý��� Ŭ���� �� �Է� �ʵ�
	
	byte[] bytes2 = new byte[100];
	
	System.out.println("�Է� : ");
	int readByteno = System.in.read(bytes2);
		// �ܺ���� : �ڹ����α׷� �� [ Ű����, ��Ʈ�p ��� ] ����� �Ϲݿ��� �߻�!!
	System.out.println("�Է¹��� ����Ʈ : "+Arrays.toString(bytes2));
	// �ҹ��� a �Է��ϰ� ���� ������ �迭�� 97, 13, 10 ����.
		// 97 : a
		// 13 : �ٹٲ�
		// 10 : ����(�� ������)
	
	
	String str = new String(bytes2);
		//  readByteno-2 : ���͸� �������ν� ����� �ٹٲް� ������ ���� �о����.
	System.out.println("�Է¹��� ����Ʈ -> ���ڿ� ��ȯ : "+str);
	
	Scanner scanner = new Scanner(System.in);
	scanner.next();			// ����Ʈ->���ڿ� ��ȯ
	scanner.nextInt();		// ����Ʈ->������ ��ȯ
	scanner.nextDouble();	// ����Ʈ->�Ǽ��� ��ȯ
	
	
	}
}
