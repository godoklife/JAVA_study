package Day02;

import java.util.Scanner;

public class Day02_test12 {
	public static void main(String[] args) {
		System.out.println("inch�� �Է¹޾� cm���� ��ȯ�ϱ� [ 1inch = 2.54cm ]");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("inch�� �Է��Ͻÿ� : ");
		float inch = scanner.nextFloat();
		float cm = inch * 2.54f;
		
		System.out.println("�Է��� ���� cm���� ��ȯ�� ���� " + (inch * 2.54) + " cm �Դϴ�.");
		System.out.printf("�Է��� ���� cm���� ��ȯ�� ���� %.3f cm �Դϴ�.",cm);
		
		scanner.close();
	}

}
