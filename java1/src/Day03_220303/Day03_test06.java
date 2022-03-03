package Day03_220303;

import java.util.Scanner;

public class Day03_test06 {
	public static void main(String[] args) {
		System.out.println("점수 1개를 입력받아서 90점 이상이면 합격, 그 외 불합 출력");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("점수 입력 : ");
		int point = scanner.nextInt();
		
		if (point>=90) System.out.println("합격입니다");
		else System.out.println("불합격입니다");
		
		scanner.close();
	}
}
