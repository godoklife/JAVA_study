package Day02;

import java.util.Scanner;

public class Day02_test9 {
	public static void main(String[] args) {
		System.out.println("��ٸ��� ���� ���ϱ�");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ ���̸� �Է��Ͻÿ� : ");
		double Upside = scanner.nextDouble();
		
		System.out.println("�غ��� ���̸� �Է��Ͻÿ�");
		double Downside = scanner.nextDouble();
		
		System.out.println("������ ���̸� �Է��Ͻÿ�");
		double Height = scanner.nextDouble();
		
		
		System.out.println("��ٸ��� ���̴� " + ( ( (Upside * Downside) * Height ) / 2 ) );
		
		scanner.close();
	}
}
