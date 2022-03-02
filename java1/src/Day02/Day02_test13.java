package Day02;

import java.util.Scanner;

public class Day02_test13 {
	public static void main(String[] args) {
		System.out.println("중간고사, 기말고사, 수행평가를 입력받아 반영비율 별 계산하기");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("중간 점수 : ");
		int 중간점수 = scanner.nextInt();
		
		System.out.println("기말 점수 : ");
		int 기말점수 = scanner.nextInt();

		System.out.println("수행평가 점수 : ");
		int 수행평가 = scanner.nextInt();
		
		float 최종점수 = (float)((중간점수*.3) + (기말점수*.3) + (수행평가*.4));
		
		System.out.println("반영 비율 : 중간고사 30%, 기말고사 30%, 수행평가 40%");
		System.out.printf("최종 점수 : %.2f", 최종점수);
		
		scanner.close();
	}
}
