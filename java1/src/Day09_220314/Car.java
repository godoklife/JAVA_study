package Day09_220314;
	// Day09_05
public class Car {
	
	// 1. 필드	(변수, 객체, static변수 가능)
	Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);
	// 2. 생성자
	
	// 3. 메서드
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if(frontLeftTire.roll()==false) {
			stop();
			return 1;
		}
		// 타이어가 회전했는데 펑크이면 false, 수명이 남았으면 true
		if(frontRightTire.roll()==false) {
			stop();
			return 2;
		}
		if(backLeftTire.roll()==false) {
			stop();
			return 3;
		}
		if(backRightTire.roll()==false) {
			stop();
			return 4;
		}
		return 0;	// 리턴이 0이면 펑크가 없다는것
	}
	void stop() {
		System.out.println("자동차가 멈춥니다.");
		
	}
}
