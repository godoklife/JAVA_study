package Day03_220303;

import java.util.Scanner;

public class Day03_test07 {
	public static void main(String[] args) {
		System.out.println("������ �Է¹޾� 90�� �̻��̸� A���");
		System.out.println("������ �Է¹޾� 80�� �̻��̸� B���");
		System.out.println("������ �Է¹޾� 70�� �̻��̸� C���");
		System.out.println("�� �ܴ� �����");
		System.out.println("--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ���.");
		int point = scanner.nextInt();
		
		if(point >= 90) System.out.println("A���");
		else if(point >= 80) System.out.println("B���");
		else if(point >= 70) System.out.println("C���");
		else System.out.println("�����");
		
		scanner.close();
	}
}
