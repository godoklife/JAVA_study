package Day02;

import java.util.Scanner;

public class Day02_test16 {
	public static void main(String[] args) {
		System.out.println("3���� ������ �Է¹޾� ������������ ����");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ���.(1) :");
		int num1 = scanner.nextInt();
		
		System.out.println("������ �Է��ϼ���.(2) :");
		int num2 = scanner.nextInt();
		
		System.out.println("������ �Է��ϼ���.(3) :");
		int num3 = scanner.nextInt();
						
		int a = num1 > num2 ? num1 : num2;
		a = a > num3 ? a : num3;
		a = a > num1 ? a : num1;
		
		
		
//		int b = num1 > num2 ? num1 : num2;
//		b = b > num3 ? b : num3;
//		b = b > num1 ? b : num1;
		
		

		System.out.println(a);
		
		scanner.close();
	}
	
}
