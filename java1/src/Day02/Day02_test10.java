package Day02;

import java.util.Scanner;

public class Day02_test10 {
	public static void main(String[] args) {
		System.out.println("키를 정수로 입력받아 표준체중 출력하기");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("키를 정수로 입력하시오 : ");
		//int height = scanner.nextInt(); // 사용해도 되지만 최적화를 생각해서 ㄴㄴ
		
		System.out.println("입력하신 키의 표준체중은 " + ((scanner.nextInt() - 100 ) * 0.9) + "Kg 입니다.");
		
		
		
		scanner.close();
	}
}
