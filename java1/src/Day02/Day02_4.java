package Day02;

public class Day02_4 {

	public static void main(String[] args) {
		// P. 64 연산자
		/*
		 * 1. 산술
		 * 	// 1. 더하기+ 2. 빼기- 3. 곱하기* 4. 나누기(몫)/ 5. 나머지%
		 * 
		 * 2. 비교 [ 결과값은 true, false로 반환 ]
		 * 	> 초과	<미만
		 * 	>= 이상	<= 이하
		 * 	== 같다	!= 다르다
		 * 
		 * 3. 논리 [ 2개 이상의 비교연산자 사용시 ]
		 * 	&&	AND
		 * 	||	OR
		 * 	!	NOT
		 * 
		 * 4. 대입
		 * 	=	: 오른쪽 값이 왼쪽으로 이동 [ 저장 ]
		 *  +=	:  오른쪽 값이 왼쪽값과 더하기 후에 왼쪽값에 저장
		 *  	변수명 = 변수명 + 10
		 *  	// 1. 변수를 호출.
		 *  	// 2. 변수에 10을 저한다.
		 *  	// 3. 해당 변수에 더한 값을 대입한다.
		 *  	변수명 += 10
		 *  	// 1. 변수를 호출
		 *  	// 2. 오른쪽 값을 더한 후에 변수에 대입.
		 *  -=, *=, /=, %= 도 있음.
		 * 
		 * 5. 증감 [ 일정 간격으로 변화가 있을때 자주 사용. ]
		 * 	// 1. ++ : 1 증가		2. -- : 1 감소
		 * 	// 선위증가 : 우선 증가 후 명령어 실행	++x
		 * 	// 후위증가 : 명령어 실행 후 증가		x++
		 * 	
		 * 6. 삼항연산자 [ 조건연산자 ]
		 * 	조건식 ? 참 : 거짓
		 */
		
		
		// 산술연산자 예제
		
		int 정수1 = 10; int 정수2 = 20;	// 10과 20을 저장하는 두개의 변수 선언
		System.out.println("더하기 : "+정수1+정수2);		// 문자열 + 정수 -> 연결연산자
		System.out.println("더하기 : "+(정수1+정수2));	// 문자열 + (정수1 + 정수2 ) 
		System.out.println("빼기 : " + (정수1-정수2));
		System.out.println("곱하기" + (정수1 * 정수2));
		System.out.println("나누기(몫)" + (정수1 / 정수2));
		System.out.println("나머지 : " + (정수1 % 정수2));
		
		
		// 증감연산자 예제
		정수1++;	// 변수명 뒤에 ++ 할 경우 해당 변수 내 데이터 에 +1
		System.out.println("정수1 : " + 정수1);
		정수1--;	// 변수명 뒤에 -- 할 경우 -1
		System.out.println("정수1 : " + 정수1);
		
		System.out.println("선위증가 : " + ++정수1);
		System.out.println("후위증가 : " + 정수1++);
		System.out.println("후위증가 후 : " + 정수1);
		
		System.out.println("선위감소 : " + --정수1);	// 1 감소 후 출력
		System.out.println("후위감소 : " + 정수1--); 	// 출력 후 1 감소
		System.out.println("정수1 : "+ 정수1);
		
		
		// 비교연산자 예제
		System.out.println("이상 : " + (정수1>=정수2) ); 	// 값이 false로 반환된다.
		System.out.println("이하 : " + (정수1<=정수2) );	// 참
		System.out.println("초과 : " + (정수1>정수2) );
		System.out.println("미만 : " + (정수1<정수2) );
		System.out.println("같다 : " + (정수1==정수2) );
		System.out.println("같지않다 : " + (정수1!=정수2) );
		
		
		// 논리연산자 예제
			// AND &&	: 두개 이상의 연산자 모두 true 이면 결과도 true, 이외는 false 반환
			// OR ||	: 2개 이상의 연산자 중 하나라도 true이면 결과도 true, 전부 false일때만 false 반환.
		int 정수3 = 30;	int 정수4 = 40;
		System.out.println(" and : " + (정수1 >= 정수2 && 정수4 >= 정수3) );	// false 반환
		System.out.println(" or : " + (정수1 >= 정수2 || 정수4 >= 정수3) );	// true 반환
		System.out.println(" not : " + !(정수1 >= 정수2 || 정수4 >= 정수3) );	// true를 not 연산하여 false 반환.
		
		
		// 대입연산자 예제
		정수1 = 정수1 + 10;	System.out.println("정수1 : " + 정수1);
		정수1 += 10;			System.out.println("정수1 : " + 정수1);
		정수1 -= 10;			System.out.println("정수1 : " + 정수1);
		정수1 /= 10;			System.out.println("정수1 : " + 정수1);
		
		
		// 삼항연산자 예제
		int 점수 = 85;
		char 등급 = 점수 > 90 ? 'A' : 'B';	// 점수 변수가 90을 초과하면 A, 아니면 B를 등급에 대입.
		System.out.println("등급 : " + 등급);
		
		char 등급2 = 점수 > 90 ? 'A' : 점수 > 80 ? 'B' : 'C';
			// 조건식 ? 참 : 거짓 [ 조건식 ? 참 : 거짓 ]
			// 점수 변수가 90을 초과하면 A 대입, 아니면 80을 초과하면 B 대입, 아니면 C
		// 조건 하나짜리는 가끔 쓰지만, 조건 두개 이상은 지저분하기 때문에 if문같은 조건문을 사용한다.
		
		
		
		
	}
	
}
