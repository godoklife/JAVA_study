package Day06_220308;

public class Korean {
	// * Korean 클래스 선언
	
	// 1. 필드 
	String nation = "대한민국";	// 국가 변수에 미리 대한민국을 대입.
	String name;				// 이름 변수는 초기화 X[ null ]
	String ssn;					// 주민번호 변수 [ null ]
	
	// 2. 생성자
		// 조건1 : 생성자 이름 == 클래스 이름 동일해야함.
		// 조건2 : 외부로부터 들어오는 매개값 [ 인수 ] 선언
		// 조건3 : 동일한 생성자 이름을 가질 수 없다.
			// 오버로딩 : 동일한 이름일 경우 재정의
	
	Korean() {	// 1) 빈 생성자
		// 내용물 없음.
	}
	
	Korean(String n) {	// 2) 빈 생성자
		name = n;
	}
	
	Korean( String n, String s) {	// 3) 필드 2개를 갖는 생성자
		name = n;
		ssn = s;
	}
	
	Korean(String nation, String name, String ssn)	{ // 4) 필드 3개를 갖는 생성자
		this.nation = nation;	
			// this.nation은 Korean 클래스 내의 nation을 의미
			// = nation은 외부에서 들어오는것.
		this.name = name;
		this.ssn = ssn;
		// 내부변수 [ 현재 클래스 내 변수 ]
		// 매개변수 [ 외부로부터 들어운 변수 ]
		// 내부변수 == 매개변수 충돌 발생. 그러나 내부변수와 매개변수의 이름을 똑같이 통일하여야 함.
			//  동일할때 표기하는 방법이 있음. [ this. ]
	}
	
	
	
	// 3. 메서드
	
	
	
	
	// 필드
	
	
	// 생성자
}
