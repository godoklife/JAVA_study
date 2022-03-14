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
		
		int problemLocation = myCar.run();
		switch(problemLocation) {
		case 1: 
			System.out.println("앞 왼쪽 한국타이어 교체");
			myCar.frontLeftTire = new HankookTire("앞왼쪽", 15);
			// 슈퍼클래스 객체라면 = new 서브클래스(); 가능
			// 상속을 받아야만 가능.
			break;	// switch문 탈출.
		case 2: 
			System.out.println("앞 오른쪽 금호타이어 교체");
			myCar.frontRightTire = new KumhoTire("앞오른쪽", 13);
			break;
			
		case 3: 
			System.out.println("뒤 왼쪽 한국타이어 교체");
			myCar.backLeftTire = new HankookTire("뒤 왼쪽", 15);
			break;
			
		case 4:
			System.out.println("뒤 오른쪽 금호타이어 교체");
			myCar.backRightTire = new KumhoTire("뒤 오른쪽", 13);
			break;
		}
		
		
	}	// main END
}	// class END
