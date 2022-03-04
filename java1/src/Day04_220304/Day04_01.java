package Day04_220304;

import java.util.Scanner;

public class Day04_01 {	// c s
	public static void main(String[] args) {	// m s
		
		// 제어문 : if, switch
		// 반복문 : for, while
			// 1. 초기값	2. 조건식	3. 증감식	4. 실행문
			// while문의 형태
			// 1. 초기값; 
			// while( 2. 조건식 ) {
			// 	4. 실행문;
			//	3. 증감식;
			//	}
		// for문 예1)
		for(int i=1; i<=10; i++) { 
			System.out.println(i);
		}
		System.out.println("\n예제 끝1\n");
		
		
		// while문 예1) [ 상단 for문과 동일한 출력 ] 
		int i = 1; // 1. 초기값
		while (i<=10) {	// 2. 조건식
			System.out.println(i + " "); 	// 4. 실행문
			i++;	// 3. 증감
		}	// while end
		System.out.println("\n예제 끝2\n");

		
		// for 예2) 1~100 누적합계
		int sum=0;
		for(int j=1; j<=100; j++)
			sum += j;
		
		System.out.println(sum);
		System.out.println("\n예제 끝3\n");

		
		// while 예2) 1~100 누적합계
		int j=1; // 1. 초기값
		int sum2 =0;
		while(j<=100) {	// 2. 조건문
			sum2 += j;	// 4. 실행문
			j++;		// 3. 증감식
		}
		
		System.out.println(sum2);
		System.out.println("\n예제 끝4\n");

		
		// while 예3) 무한루프
		while(true) {	// 조건식이 true 실행	// true=상수 => 무한루프
			System.out.println("무한루프");
			System.out.println("3을 입력하면 루프 탈출");
			Scanner scanner = new Scanner(System.in);
			int exit = scanner.nextInt();
			
			if(exit==3)
				break;		// if만을 제외한 가장 가까운 반복문, 제어문 탈출
		}
		System.out.println("\n예제 끝5\n");

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// m e
}	// c e
