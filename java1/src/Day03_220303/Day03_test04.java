package Day03_220303;

import java.util.Scanner;

public class Day03_test04 {
	public static void main(String[] args) {
		System.out.println("3개의 정수를 입력받아서 오름차순으로 정렬하시오.");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수1 :");
		int num1 = scanner.nextInt();
		
		System.out.println("정수2 :");
		int num2 = scanner.nextInt();
		
		System.out.println("정수3 :");
		int num3 = scanner.nextInt();
		
		if(num1>num2) {
			// 교체 [ 스왑 = 두개 변수에 데이터 교체방법 ]
			int tmp = num1;	// 임시변수 = 변수1;
			num1 = num2;	// 변수1 = 변수2;
			num2 = tmp;		// 변수2 = 임시변수;
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
		
		System.out.printf("첫번쨰 %d 두번째 %d 세번째 %d", num1, num2, num3);
		
		scanner.close();
	}
}
