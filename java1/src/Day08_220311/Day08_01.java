package Day08_220311;

public class Day08_01 {	// c s
	public static void main(String[] args) {	// m s
		
		// P.238 : static
			// 정적 변수 
			// 공통적인 데이터 = 프로그램 전반저긍로 사용되는 메모리
			
		// * 클래스 내 필드, 메서드에 접근하는 방법
			// 1. 객체 생성 -> 객체.멤버 [ static 맴버가 아닐 때! ] 
				// 객체가 생성될 때 new 연산자를 통해 객체 (내 멤버 포함) 메모리 할당
		Calculater calculater = new Calculater();
		
		System.out.println("객체를 이용한 멤버 접근 : "+calculater.pi);
		
			// 2. 클래스명.맴버 [ static 멤버일때! ]
				// 클래스 로딩 후 메서드 영역에 static변수 메모리 할당
		System.out.println("객체 없이 멤버 접근 : "+Calculater.pi);
		
		// * new 연산자로 메모리에 할당 시키든, static으로 항상 적재 시키든 알맞게 선택.
		//---------------------------------------------------------------
		
		double result1 = 10 * 10 * Calculater.pi;
		int result2 = Calculater.plus(10, 5);
		int result3 = Calculater.minus(10, 5);
		
		System.out.println("result1 : "+result1);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
		
		
	}	// m e
}	// c e
