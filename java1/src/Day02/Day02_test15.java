package Day02;

import java.util.Scanner;

public class Day02_test15 {
	public static void main(String[] args) {
		System.out.println("나이를 입력받아 10세 이상이면 학생, 20세 이상이면 성인, 40세 이상이면 중년으로 출력하시오");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("나이를 입력하시오 : ");
		int age = scanner.nextInt();
		
		String 분류 = age >= 40 ? "중년" : age >= 20 ? "성인" : age >= 10 ? "학생" : "분류없음";
		
		System.out.println(분류);
		
		scanner.close();
	}
}
