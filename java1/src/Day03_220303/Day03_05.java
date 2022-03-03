package Day03_220303;

public class Day03_05 {	// c s
	public static void main(String[] args) {	// m s
		
		// 반복문 : 1. for	2. while	3. do.while[x]
		// for : 
			// 어디서부터 어디까지 몇개씩 증가/감소 하면서 반복 처리
			// 1부터 10까지 3씩 증가하면서 반복처리 = 4번 실행됨.
			// 필수요소 : 1. 초기값	2. 조건식	3. 증감식
			// 형태
			//		for(1. 초기값 ; 2. 조건식 ; 3. 증감식 ) {
			//			반복실행문;
			//		}
			
		// for문의 중첩
			// for1 ( ) { for2 ( ) { for3 ( ) { } } }
		
		
		// P.121 예제
		for(int i = 1 ; i <= 10 ; i++ ) {
			// int i = 1	: 초기값 선언 [ i는 반복변수 ]
				// i <= 10	: 조건식 [ i가 10 이하이면 실행 아니면 for문 탈출 ]
					// i++ 	: 증감식 [ 실행문 실행 후 증가 혹은 감소 단위 ]
			// * 변수 i는 1부터 10까지 1씩 증가하면서 실행문 반복 처리.
			System.out.println(i+" ");
		}
		System.out.println("P.121 예제 출력 끝.\n");
		
		
		// P.122 예제
		int sum=0;
		for (int i=1; i<=100; i++)
			sum += i;
		
		System.out.println(sum);
		System.out.println("P.122 예제 출력 끝.\n");
		
		
		// 예제3 : 1부터 100까지 7배수의 누적 합계를 구하시오
		int sum2 = 0;
		for (int i=0; i <= 100; i += 7)
			sum2 += i;
		
		System.out.println(sum2);
		System.out.println("예제3 출력 끝.\n");
		
		
		// 예제3_2 : 1부터 100까지 7배수의 누적 합계를 for와 if를 사용해 구하시오
		int sum3 = 0;
		for(int i=1; i<=100; i++) {
			if(i%7==0) sum3 += i;
		}
		
		System.out.println(sum3);
		System.out.println("예제3_2 출력 끝.\n");
		
		
		// 예제4 : 2단 구구단 만들기
		for(int 곱=1; 곱<=9; 곱++) {
			System.out.println("2 * " + 곱 + "= "+ (2*곱));
		}
		
		System.out.println("예제4 출력 끝.\n");
		
		
		// P.124 예제 : 2단~9단 구구단 만들기 [ 단, 곱 둘 다 변수 ] 
			// 단 : 2부터 9까지 8번 증가
			// 곱 : 1부터 9까지 9번 증가
				// 단 1번 실행될 때 마다 곱 9번 실행
			// * 구구단 총 72번 실행
		for(int 단=2; 단<=9; 단++) {
			System.out.printf("-----%d단-----\n", 단);
			for(int 곱=1; 곱<=9; 곱++)
				System.out.printf("%d * %d = %d\n", 단, 곱, 단*곱);
		}
		
		System.out.println("P.124 예제 출력 끝.\n");
		
		
		
		
		
		
		
		
		
		
		
		
	}	// m e
}	// c e
