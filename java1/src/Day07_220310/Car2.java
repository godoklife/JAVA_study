package Day07_220310;

public class Car2 {
	// 1. 필드
	int speed;
	
	// 2. 생성자
		// 생성자가 없으면 기본생성자를 컴파일러가 자동으로 추가!!
	// 3. 메서드
	int getSpeed() {	// 인수 X, 반환 O
		return speed;
	}	// getSpeed END
	
	void keyTurnOn() {	// 인수 X, 반환 X
		System.out.println("키를 돌립니다");
	}	// keyTurnOn END
	
	void run() {	// 인수 X, 반환 X
		for(int i=10; i<=50; i+=10) {
			// * i는 10부터 50까지 10단위로 증가하며 반복
			speed = i;	// i를 speed필드에 대입
			System.out.println("달립니다. 시속 : "+speed+" km/h");
		}	// run END
	}
}
