package Day03_220303;

import java.util.Scanner;

public class Day03_test05 {
	public static void main(String[] args) {
		System.out.println("4개의 정수를 입력받아서 오름차순 / 내림차순으로 정렬하시오.");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수1 :");
		int num1 = scanner.nextInt();
		
		System.out.println("정수2 :");
		int num2 = scanner.nextInt();
		
		System.out.println("정수3 :");
		int num3 = scanner.nextInt();
		
		System.out.println("정수4 :");
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

		System.out.println("오름차순");
		System.out.printf("첫번째 : %d, 두번째 : %d, 세번째 : %d, 네번째 : %d\n", num1, num2, num3, num4);
		
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
		
		
		
		System.out.println("내림차순");
		System.out.printf("첫번째 : %d, 두번째 : %d, 세번째 : %d, 네번째 : %d\n", num1, num2, num3, num4);
		scanner.close();
	}
}
