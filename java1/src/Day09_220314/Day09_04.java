package Day09_220314;

public class Day09_04 {
	public static void main(String[] args) {
		
		// P.296~ 297 오버라이딩
			// @Override : 재정의
			// 동일한 인수와 메서드명은 원칙상으로는 불가능.
			// 오버라이드의 목적 : 동일한 이름의 메서드를 재정의 [ 수정 ]
				
		
		int r = 10;	// 원의 반지름 변수
		
		// 1. 수퍼클래스로 객체 생성
		Calculator calculator = new Calculator();
		System.out.println("원 면적 : "+ calculator.areaCircle(r));
		
		// 2. 서브클래스로 객체 생성
		Computer computer = new Computer();
		System.out.println("컴퓨터 원 면적 : "+computer.areaCircle(r));
		
		// * 슈퍼클래스와 서브클래스 내 메서드는 다르다!!!
		
		Test test = new Test();
		System.out.println("테스트 원 면적 : "+ test.areaCircle(r));
		
		
		
	}
}
