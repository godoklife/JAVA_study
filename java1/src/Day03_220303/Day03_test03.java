package Day03_220303;

import java.util.Scanner;

public class Day03_test03 {
	public static void main(String[] args) {
		System.out.println("4���� ������ �Է¹޾Ƽ� ���� ū ���� ����Ͻÿ�");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("����1 " );
		int num1 = scanner.nextInt();
		
		System.out.println("����2 " );
		int num2 = scanner.nextInt();
		
		System.out.println("����3 " );
		int num3 = scanner.nextInt();
		
		System.out.println("����4 " );
		int num4 = scanner.nextInt();
		
		int max = num1;
		
		if (max < num2)
			max = num2;
		if (max < num3)
			max = num3;
		if (max < num4)
			max = num4;

		System.out.println(max);
		
		scanner.close();
	}
}
