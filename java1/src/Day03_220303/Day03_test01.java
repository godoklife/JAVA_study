package Day03_220303;

import java.util.Scanner;

public class Day03_test01 {	//	c s
	public static void main(String[] args) {	// m s
		System.out.println("2���� ������ �Է¹޾Ƽ� �� ū ���� ����ϴ� ���α׷�");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("(1) ������ �Է��ϼ���");
		int num1 = scanner.nextInt();
		
		System.out.println("(2) ������ �Է��ϼ���");
		int num2 = scanner.nextInt();
		
		System.out.println("�Է��Ͻ� ������ " + num1 + ", " + num2 + " �Դϴ�.");
		
		if(num1 > num2)
			System.out.println("�� ���� �� �� ū ���� " + num1 + " �Դϴ�.");
		else if(num1 < num2)
			System.out.println("�� ���� �� �� ū ���� " + num2 + " �Դϴ�.");
		else
			System.out.println("�� ������ �����ϴ�.");
		
		
		scanner.close();
	}	// m e
}	// c e
