package Day03_220303;

import java.util.Scanner;

public class Day03_test02 {
	public static void main(String[] args) {
		System.out.println("3���� ������ �Է¹޾Ƽ� ���� ū ���� ���");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1) ������ �Է��ϼ��� : ");
		int num1 = scanner.nextInt();
		
		System.out.println("2) ������ �Է��ϼ��� : ");
		int num2 = scanner.nextInt();
		
		System.out.println("3) ������ �Է��ϼ��� : ");
		int num3 = scanner.nextInt();
		
		int max = num1;	// max�� ù��° �� ����
		if(max < num2)
			max = num2;
		if(max < num3)
			max = num3;
		
		System.out.println(max);
		
		scanner.close();
//		if (max<num3) {	// ���� max���� num3�� �� ũ�� ��ü
//			int tmp = num3;	// �ӽú��� [ ���ҿ� ]
//			num3 = max;
//			max = tmp;
//		}
		
	}
}
