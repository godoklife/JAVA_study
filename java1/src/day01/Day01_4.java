package day01;

import java.util.Scanner;

public class Day01_4 {	// c s
	
	public static void main(String[] args) {	// m s
		
		// 예제1 : 한명의 이름, 1교시, 2교시, 3교시 출석 여부를 입력 받아 출력
					// 입력 -> 저장 -> 출력
		// 1. 입력 객체 선언
		Scanner scan = new Scanner(System.in);
		
		// 2. 입력 받을 데이터 안내
		System.out.println("이름 : ");
		
		// 3. 입력 받은 데이터 가져오기 -> 다른곳에 저장
		String 이름 = scan.next();
		
		System.out.println("1교시 : ");	
		String 교시1 = scan.next();		// 변수명의 첫 글자는 숫자가 될 수 없음.
		
		System.out.println("2교시 : ");	
		String 교시2 = scan.next();
		
		System.out.println("3교시 : ");	
		String 교시3 = scan.next();
		
		// 4. 출력
		System.out.println("\t[[출석부]]");
		System.out.println("------------------------------");
		System.out.println("이름\t1교시\t2교시\t3교시");
		System.out.println(이름 + "\t" + 교시1 + "\t" + 교시2 + "\t" + 교시3);	// 위에서 선언된 이름은 문자처리 X
		System.out.println("------------------------------");
		
		scan.close();
		
		
		
	}	// m e
}	// c e
