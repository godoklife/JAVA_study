package Day02;

import java.util.Scanner;

public class Day02_test16 {
	public static void main(String[] args) {
		System.out.println("3개의 정수를 입력받아 오름차순으로 정렬");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요.(1) :");
		int num1 = scanner.nextInt();
		
		System.out.println("정수를 입력하세요.(2) :");
		int num2 = scanner.nextInt();
		
		System.out.println("정수를 입력하세요.(3) :");
		int num3 = scanner.nextInt();
		
		int a = num1;
		
		a = a > num2 ? a : num2;
		a = a > num3 ? a : num3;
		a = a > num1 ? a : num1;
		
		num1 = a;
		

		System.out.println(a);
		
		scanner.close();
	}
	
}
