package Day03_220303;

import java.util.Scanner;

public class Day03_test06 {
	public static void main(String[] args) {
		System.out.println("���� 1���� �Է¹޾Ƽ� 90�� �̻��̸� �հ�, �� �� ���� ���");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���� �Է� : ");
		int point = scanner.nextInt();
		
		if (point>=90) System.out.println("�հ��Դϴ�");
		else System.out.println("���հ��Դϴ�");
		
		scanner.close();
	}
}
