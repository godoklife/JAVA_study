package Day03_220303;

import java.util.Scanner;

public class Day03_test05 {
	public static void main(String[] args) {
		System.out.println("4���� ������ �Է¹޾Ƽ� �������� / ������������ �����Ͻÿ�.");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("����1 :");
		int num1 = scanner.nextInt();
		
		System.out.println("����2 :");
		int num2 = scanner.nextInt();
		
		System.out.println("����3 :");
		int num3 = scanner.nextInt();
		
		System.out.println("����4 :");
		int num4 = scanner.nextInt();
		
		if (num1 > num2) {	
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		if (num1 > num3) { int tmp = num1; num1 = num3; num3 = tmp; }
		if (num1 > num4) { int tmp = num1; num1 = num4; num4 = tmp; }
		
		if (num2 > num3) { int tmp = num2; num2 = num3; num3 = tmp; }
		if (num2 > num4) { int tmp = num2; num2 = num4; num4 = tmp; }
		
		if (num3 > num4) { int tmp = num3; num3 = num4; num4 = tmp; }

		System.out.println("��������");
		System.out.printf("ù��° : %d, �ι�° : %d, ����° : %d, �׹�° : %d\n", num1, num2, num3, num4);
		
		if (num1 < num2) {
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		if (num1 < num3) { int tmp = num1; num1 = num3; num3 = tmp; }
		if (num1 < num4) { int tmp = num1; num1 = num4; num4 = tmp; }
		
		if (num2 < num3) { int tmp = num2; num2 = num3; num3 = tmp; }
		if (num2 < num4) { int tmp = num2; num2 = num4; num4 = tmp; }
		
		if (num3 < num4) { int tmp = num3; num3 = num4; num4 = tmp; }
		
		
		
		System.out.println("��������");
		System.out.printf("ù��° : %d, �ι�° : %d, ����° : %d, �׹�° : %d\n", num1, num2, num3, num4);
		scanner.close();
	}
}
