package Day03_220303;

import java.util.Scanner;

public class Day03_test04 {
	public static void main(String[] args) {
		System.out.println("3���� ������ �Է¹޾Ƽ� ������������ �����Ͻÿ�.");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("����1 :");
		int num1 = scanner.nextInt();
		
		System.out.println("����2 :");
		int num2 = scanner.nextInt();
		
		System.out.println("����3 :");
		int num3 = scanner.nextInt();
		
		if(num1>num2) {
			// ��ü [ ���� = �ΰ� ������ ������ ��ü��� ]
			int tmp = num1;	// �ӽú��� = ����1;
			num1 = num2;	// ����1 = ����2;
			num2 = tmp;		// ����2 = �ӽú���;
		}
		
		if(num1>num3) {
			int tmp = num1;
			num1 = num3;
			num3 = tmp;
		}
		
		if(num2>num3) {
			int tmp = num2;
			num2 = num3;
			num3 = tmp;
		}
		
		System.out.printf("ù���� %d �ι�° %d ����° %d", num1, num2, num3);
		
		scanner.close();
	}
}
