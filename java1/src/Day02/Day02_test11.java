package Day02;

import java.util.Scanner;

public class Day02_test11 {
	public static void main(String[] args) {
		System.out.println("키와 체중을 입력받아 BMI 출력하기");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("키를 입력하세요");
		int height = scanner.nextInt();
		
		System.out.println("체중을 입력하세요");
		int weight = scanner.nextInt();
		
		float BMI = weight / (float)( (height / 100) * (height / 100) );
		System.out.println("BMI는 " + BMI + " 입니다.");
		
		scanner.close();
	}
}
