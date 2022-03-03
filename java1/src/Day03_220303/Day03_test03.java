package Day03_220303;

import java.util.Scanner;

public class Day03_test03 {
	public static void main(String[] args) {
		System.out.println("4개의 정수를 입력받아서 가장 큰 수를 출력하시오");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수1 " );
		int num1 = scanner.nextInt();
		
		System.out.println("정수2 " );
		int num2 = scanner.nextInt();
		
		System.out.println("정수3 " );
		int num3 = scanner.nextInt();
		
		System.out.println("정수4 " );
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
