package day01;

public class Day01_2 { // c s (class start)
	// 1. 출력
		// 1. print()	: 출력만
		// 2. printf()	: 출력에 꾸미기(f가 format, 형식임)
		// 3. println()	: 출력 후 줄바꿈 포함
			// 형식문자
				// %s : 문자열 들어가는 자리
				// %c : 문자 
				// %d : 정수
			// 제어문자
				// \n : 줄바꿈
				// \t : 들여쓰기[5칸 띄워쓰기]
				// \\ : \
				// \" : "
	
	// 1. System : 시스템 클래스 [ 입출력 관련 만들어진 코드 제공 ]
	// 2. out : 출력 스트림
	// 3. print() : 출력 함수
	// 4. 세미콜론 : 한줄 코드의 끝을 알림
	// * 시스템 클래스 내 out 이라는 출력스트림을 톨래 print 함수를 사용해서 console에 원하는 대로 출력할 수 있다.
	public static void main(String[] args) { // m s (main start)
		
		// 1. 기본출력
		System.out.print("print");		// ; 코드 단위 종료
		System.out.print("자바 1일차");	// 문자에는 큰 따옴표 처리
		System.out.print(123);			// 단, 숫자에는 큰 따옴표 처리 X
			// * 미리 만들어진 단어 [ 예약어 ] 를 제외한 모든 문자는 " " 처리
		// 2. 자동완성 ( syso + ctrl + space_bar)
		System.out.println("syso + 스페이스바는 println");
		System.out.println(123);
		
		// 3. 형식 출력
		System.out.printf("%s", "printf에 %s로 호출");
		System.out.printf("\njava %d일차", 1);
		
		// 예제1 [ 출석부 ]
		System.out.println("\n\t\t[[출석부]]");
		System.out.println("----------------------------------------");
		System.out.println("이름\t1교시\t2교시\t3교시\t비고");
		System.out.println("강호동\t출석\t결석\t출석");
		System.out.println("유재석\t출석\t결석\t출석");
		System.out.println("----------------------------------------");
		
		// 예제2 [ 예제1번을 printf로 바꿔보시오 ]
		System.out.printf("\n\t\t%s", "[[출석부]]");
		System.out.printf("\n%s", "----------------------------------------");
		System.out.printf("\n%s\t%s\t%s\t%s\t%s", "이름", "1교시", "2교시", "3교시", "비고");
		System.out.printf("\n%s\t%s\t%s\t%s\t", "강호동", "출석", "결석", "출석");
		System.out.printf("\n%s\t%s\t%s\t%s\t", "유재석", "출석", "결석", "출석");
		System.out.printf("\n%s", "----------------------------------------\n\n");
		
		// 문제1 : 고양이
		System.out.println("\\    /\\");	// 백슬래시 출력시 \\
		System.out.println(" )  ( ')");
		System.out.println("(  /  )");
		System.out.println(" \\(_)|");
		
		// 문제2 : 강아지 
				/*
						|\_/|
						|q p|   /}
						( 0 )"""\
						|"^"`    |
						||_/=\\__|
				*/
		System.out.println("\n|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");	// 큰따옴표 출력시 \"
		System.out.println("|\"^\"'    |");
		System.out.println("||_/=\\\\__|");
		
	} // m e (main end)
	
} // c e (class end)
