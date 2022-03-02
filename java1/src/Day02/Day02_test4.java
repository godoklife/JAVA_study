package Day02;

import java.util.Scanner;

public class Day02_test4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		
		System.out.println("입력한 정수가 홀수인가 : " + ((scanner.nextInt()%2)==1));
		
		scanner.close();
	}
}
