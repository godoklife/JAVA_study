package Day03_220303;

import java.util.Scanner;

public class Day03_test01 {	//	c s
	public static void main(String[] args) {	// m s
		System.out.println("2개의 정수를 입력받아서 더 큰 수를 출력하는 프로그램");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("(1) 정수를 입력하세요");
		int num1 = scanner.nextInt();
		
		System.out.println("(2) 정수를 입력하세요");
		int num2 = scanner.nextInt();
		
		System.out.println("입력하신 정수는 " + num1 + ", " + num2 + " 입니다.");
		
		if(num1 > num2)
			System.out.println("두 정수 중 더 큰 수는 " + num1 + " 입니다.");
		else if(num1 < num2)
			System.out.println("두 정수 중 더 큰 수는 " + num2 + " 입니다.");
		else
			System.out.println("두 정수가 같습니다.");
		
		
		scanner.close();
	}	// m e
}	// c e
