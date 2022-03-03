package Day03_220303;

public class Day03_01 {	//	c s
	public static void main(String[] args) {	// m s
		
		// 1일차 : 출력, 입력
		// 2일차 : 저장(변수), 계산(연산)
		// 제어문
			// 조건식이 true이면 실행문을 실행. 이외에는 실행 X
			// 형태
				// 1. if(조건) 실행문;						(예제 1, 2)
				// 2. if(조건) 실행문;[참일 때 실행 ] 			(예제 3)
				//		else 실행문;[ 거짓일 때 실행 ]
				// 3. 실행문이 2줄 이상일때 중괄호로 묶음처리 권장	(예제 4-1, 4-2)
				// 4. 경우의 수가 다수일때 [ 조건이 다수일 때 ]	(예제 5)
				//		if(조건1) { 실행문[참1]; }
				//		else if(조건2) { 실행문[참2]; }
				//		else if(조건3) { 실행문[참3]; }
				//		else if(조건4) { 실행문[참4]; }
				//		else if(조건5) { 실행문[참5]; }
				//		else if(조건6) { 실행문[참6]; }
				//		else { 실행문[거짓]; }	// 위의 조건 전부다 해당 안되면 실행
				// 5. if 중첩 [ 실행문 자리에 if문이 들어갈 수 있음 ]
				//		if(조건식) {
				//			if(조건식) { 실행문; }
				//			else { 실행문; }
				//		}
		
		
		
		
		// 예제1
		if (3>1) System.out.println("예제1) 3은 1보다 큽니다.");
			// 만약 3이 1보다 크다면 출력. 이외에는 출력치 않음.
		
		// 예제2
		if (3>5) System.out.println("예제2) 3은 5보다 큽니다.");
			// 만약 3이 5보다 크다면 출력. 이외에는 출력치 않음.[ 출력하지 않는다 ]
		
		// 예제3
		if (3>1) System.out.println("예제3) 3은 1보다 큽니다.");
		else System.out.println("예제3) 3이 1보다 작다");
			// 만약 3이 1보다 크면 if문의 실행문 실행
			// 아니면 else의 실행문 실행
		
		// 예제4-1
		if (3>2) System.out.println("예제4-1) ture"); System.out.println("예제4-1) false");	
			// 중괄호로 안묶으면 false println은 조건문참이든 거짓이든 계속 실행됨.
		if (3>2) {
			System.out.println("예제4-2) ture"); 
			System.out.println("예제4-2) false");	// 이 false println은 조건문이 true일때만 실행
		}

		//예제 5
		if (3>5) System.out.println("예제5) 3이 5보다 크다");
		else if (3>4)System.out.println("예제5) 3이 4보다 크다.");
		else if (3>3)System.out.println("예제5) 3이 3보다 크다.");
		else if (3>2)System.out.println("예제5) 3이 2보다 크다.");
		else System.out.println("true는 없다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// m e
}	// c e
