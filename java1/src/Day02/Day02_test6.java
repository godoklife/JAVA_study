package Day02;

import java.util.Scanner;

public class Day02_test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���� �Է� : ");
		int num1 = scanner.nextInt();
		
		System.out.println("�ٸ� ���� �Է� : ");
		int num2 = scanner.nextInt();
		
		System.out.println("�Է��� �� ���� �� �� ū���� " + 
		(num1>num2 ? num1 : num1==num2 ? "�� ���� �����ϴ�." : num2) );
	
		scanner.close();
		
	}

}
