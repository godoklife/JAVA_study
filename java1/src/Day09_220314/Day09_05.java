package Day09_220314;

public class Day09_05 {
	
	public static void main(String[] args) {
		// 1. 객체 생성 [ 자동차 1대 생성 ]
		Car myCar = new Car();
			// 클래스 내 타이어 객체가 4개 존재
		
		// 2. 메서드 호출
		for(int i=0; i<=5; i++) {
			myCar.run();
		}
	}
}
