package Day02;

import java.util.Scanner;

public class Day02_test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int num1 = scanner.nextInt();
		
		System.out.println("다른 정수 입력 : ");
		int num2 = scanner.nextInt();
		
		System.out.println("입력한 두 정수 중 더 큰것은 " + 
		(num1>num2 ? num1 : num1==num2 ? "두 수가 같습니다." : num2) );
	
		scanner.close();
		
	}

}
