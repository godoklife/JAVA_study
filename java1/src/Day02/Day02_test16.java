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
						
		int tmp = (num1 > num2) ? num1 : num2;
		int max = (tmp > num3) ? tmp : num3;
		
		tmp = (num1 < num2) ? num1 : num2;
		int min = (tmp < num3) ? tmp : num3;
		int mid = (num1 > num2) ? ((num1 > num3) ? ((num2 > num3) ? num2 : num3) : num1) : ((num2 > num3) ? ((num1 > num3) ? num1 : num3) : num2);
		
		
//		int b = num1 > num2 ? num1 : num2;
//		b = b > num3 ? b : num3;
//		b = b > num1 ? b : num1;
		
		

		System.out.println("최대값 : " + max);
		System.out.println("중간값 : "+ mid);
		System.out.println("최소값 : "+ min);
		
		scanner.close();
	}
	
}
