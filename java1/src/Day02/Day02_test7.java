package Day02;

import java.util.Scanner;

public class Day02_test7 {
	public static void main(String[] args) {
		System.out.println("�������� �Է¹޾� �� ���� ����ϱ�");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �������� �Է��ϼ��� : ");
		
		int radius = scanner.nextInt();
		float area = (float)(radius * radius * 3.14);
		
		System.out.println("�� ���� : " + area);
		
		scanner.close();
	}

}
