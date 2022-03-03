package Day03_220303;

import java.util.Scanner;

public class Day03_test07 {
	public static void main(String[] args) {
		System.out.println("점수를 입력받아 90점 이상이면 A등급");
		System.out.println("점수를 입력받아 80점 이상이면 B등급");
		System.out.println("점수를 입력받아 70점 이상이면 C등급");
		System.out.println("그 외는 재시험");
		System.out.println("--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요.");
		int point = scanner.nextInt();
		
		if(point >= 90) System.out.println("A등급");
		else if(point >= 80) System.out.println("B등급");
		else if(point >= 70) System.out.println("C등급");
		else System.out.println("재시험");
		
		scanner.close();
	}
}
