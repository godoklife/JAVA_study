package Day02;

import java.util.Scanner;

public class Day02_test10 {
	public static void main(String[] args) {
		System.out.println("Ű�� ������ �Է¹޾� ǥ��ü�� ����ϱ�");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ű�� ������ �Է��Ͻÿ� : ");
		//int height = scanner.nextInt(); // ����ص� ������ ����ȭ�� �����ؼ� ����
		
		System.out.println("�Է��Ͻ� Ű�� ǥ��ü���� " + ((scanner.nextInt() - 100 ) * 0.9) + "Kg �Դϴ�.");
		
		
		
		scanner.close();
	}
}
