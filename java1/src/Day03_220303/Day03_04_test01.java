package Day03_220303;

import java.util.Scanner;

public class Day03_04_test01 {
	public static void main(String[] args) {
		System.out.println("국어, 영어, 수학 점수를 입력받아 평균 90이상이면 A등급, 80이상이면 B, 나머지 탈락 스위치만 사용");
		
		Scanner scanner = new Scanner(System.in);
		int kor, eng, math, avg;
		
		System.out.println("국어 점수 입력 : ");
		kor = scanner.nextInt();
		
		System.out.println("영어 점수 입력 : ");
		eng = scanner.nextInt();
		
		System.out.println("수학 점수 입력 : ");
		math = scanner.nextInt();
		
		avg = (kor+eng+math)/3;
		System.out.println("평균 : "+avg);
		
		switch(avg/10) {	
			// 1자리수는 필요 없으니 날리는것임. 스위치문에서 1자리수까지 포함한 채로 작성하려면 노가다 너무 심함.
		case 9 : System.out.println("A등급");	break;
		case 8 : System.out.println("B등급");	break;
		default : System.out.println("탈락");
		}
		
		scanner.close();
	}
}
