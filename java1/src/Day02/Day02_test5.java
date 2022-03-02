package Day02;

import java.util.Scanner;

public class Day02_test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num = scanner.nextInt();
		
		System.out.println("7의 배수이면서 짝수인가? " + ((num%7==0) && (num%2==0)));
		//System.out.println("7의 배수이면서 짝수인가? " + ((scanner.nextInt()%7==0) && (scanner.nextInt()%2==0)));
		
		scanner.close();
	}
}
