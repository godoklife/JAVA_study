package Day02;

import java.util.Scanner;

public class Day02_test11 {
	public static void main(String[] args) {
		System.out.println("Ű�� ü���� �Է¹޾� BMI ����ϱ�");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ű�� �Է��ϼ���");
		int height = scanner.nextInt();
		
		System.out.println("ü���� �Է��ϼ���");
		int weight = scanner.nextInt();
		
		float BMI = weight / (float)( (height / 100) * (height / 100) );
		System.out.println("BMI�� " + BMI + " �Դϴ�.");
		
		scanner.close();
	}
}
