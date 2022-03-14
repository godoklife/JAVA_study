package Day09_220314;

public class Computer extends Calculator{
			// 서브클래스 extends 수퍼클래스
	// 1. 필드
	
	// 2. 생성자
	
	// 3. 메서드
		// * 오버라이딩 [ 부모클래스 내 메서드 재정의(수정) ]
		// ctrl + space_bar 눌러봥. 오버라이드 머시기 뜰꺼임.
	
	@Override	// 상속 준 부모가 가지고 있는 메서드 호출
	double areaCircle(double r) {
		System.out.println("computer 객체의 areaCircle() 실행");
		return Math.PI*r*r;
		//return super.areaCircle(r);
	}
}
