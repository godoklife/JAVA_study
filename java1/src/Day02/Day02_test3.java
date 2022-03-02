package Day02;

import java.util.Scanner;

public class Day02_test3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오 : ");
		int num = scanner.nextInt();
		
		System.out.println("입력한 값이 7의 배수인가? : " + (num%7==0));
		scanner.close();
				
	}
	
}
