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
						
		int tmp = (num1 > num2) ? num1 : num2;
		int max = (tmp > num3) ? tmp : num3;
		
		tmp = (num1 < num2) ? num1 : num2;
		int min = (tmp < num3) ? tmp : num3;
		int mid = (num1 > num2) ? ((num1 > num3) ? ((num2 > num3) ? num2 : num3) : num1) : ((num2 > num3) ? ((num1 > num3) ? num1 : num3) : num2);
		
		
//		int b = num1 > num2 ? num1 : num2;
//		b = b > num3 ? b : num3;
//		b = b > num1 ? b : num1;
		
		

		System.out.println("�ִ밪 : " + max);
		System.out.println("�߰��� : "+ mid);
		System.out.println("�ּҰ� : "+ min);
		
		scanner.close();
	}
	
}
