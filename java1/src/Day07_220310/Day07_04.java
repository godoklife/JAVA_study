package Day07_220310;

public class Day07_04 {
	public static void main(String[] args) {
		
		// 1. 외부호출 하기 위해 반드시 필요한것?? 객체 선언!!!!!
		Car2 myCar = new Car2();
		
		// 2. 자동차 시동 걸기
		myCar.keyTurnOn();// 인수 X, 반환 X
		
		// 3. 자동차 전진 메서드 호출
		myCar.run();// 인수 X, 반환 X
		
		// 4. 현재 속도 확인 메서드 호출
		int speed = myCar.speed;
		System.out.println("현재 속도 : " +speed);
		
	}

}
