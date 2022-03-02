package Day02;

import java.util.Scanner;

public class Day02_test7 {
	public static void main(String[] args) {
		System.out.println("반지름을 입력받아 원 넓이 출력하기");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("원의 반지름을 입력하세요 : ");
		
		int radius = scanner.nextInt();
		float area = (float)(radius * radius * 3.14);
		
		System.out.println("원 넓이 : " + area);
		
		scanner.close();
	}

}
