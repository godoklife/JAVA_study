package Day02;

import java.util.Scanner;

public class Day02_test3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("������ �Է��Ͻÿ� : ");
		int num = scanner.nextInt();
		
		System.out.println("�Է��� ���� 7�� ����ΰ�? : " + (num%7==0));
		scanner.close();
				
	}
	
}
