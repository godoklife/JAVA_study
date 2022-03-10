package Day07_220310;

public class Calculater {
	
	// 메서드부
	
	// 1. 필드
	
	
	// 2. 생성자
		// 만약 생성자 선언이 1개도 없으면
		// 기본 생성자가 자동으로 추가된다!
		// 기본생성자란 ? 매개변수가 없는것
	
	 // 3. 메서드
	void powerOn() {	// 1. 인수 X(소괄호 속이 비었음), 반환 X(리턴 타입이 void)
		System.out.println("전원을 켭니다.");
		// 1. void : 리턴 타입
			// void?? 함수가 종료되면서 나가는 데이타가 없다!!는 뜻.
			// void형 일때는 return 생략 가능. [ 단, 실행부 중간에 사용시 함수 종료. 이하 명령어 실행 X ]
		// 2. powerOn : 메서드 이름 [ 아무거나 ] 
		// 3. 소괄호( ) : 매개변수가 위치. [ 함수로 들어오는 데이터 들 ]
		// 4. 중괄호 { } : 실행 코드가 위치.
	}
		
	int plus(int x, int y) {
		int result = x+y;
		return result;
			// result는 함수를 호출했던 위치로 되돌아간다. 
				// String.equals("ABC"); 가 해당 위치에 true, false 반환하는것처럼.
	}
	// 1. int : 반환의 타입 [ int 형 데이타가 반환된다! ] 반환 O
		// 5. return 반환값;
			// 리턴 타입이 int 이기 때문에 return 다음에는 int형 데이타가 와야 한다.
	// 2. plus : 메서드 이름 [ 별 의미 없음. 소문자로 하는게 관례 ]
	// 3. ( int x, int y) : 함수 호출시 들어오는 데이타 x, y를 int형으로 받겠다 선언!
	// 4. { 실행부 } : 실행부
	
	
	double divide(int x, int y) {	// 인수 O, 변환 O
//  리턴타입  메서드명 ( 인수1, 인수2 ) { 실행부 }
		double result = (double)x / y;
			// (자료형) 변수명 : 강제형변환
				// int형을 double형으로 강제변환
					// 왜?? 나누기 후 소수점이 나올수 있는데, int / int 형 하면 소수점이 손실됨.
		return result;
	}
	
	void powerOff() {	// 인수 X, 반환 X
		System.out.println("전원을 끕니다.");
	}
	
	
	
	
	
	
	
	
}
