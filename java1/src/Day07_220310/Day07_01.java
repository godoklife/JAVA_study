package Day07_220310;

public class Day07_01 {	// c s
	public static void main(String[] args) {	// m s
		//메서드 호출방법
			// 1. 메서드가 존재하는 클래스의 객체가 필요.
			// 2. 객체명.메서드명()
				// .(마침표) : 접근연산자(필드나 메서드를 호출시 사용)
				// ex.) scanner.nextInt();
		// 1. 객체 선언
		Calculater myCalc = new Calculater();
		// 클래스명	객체명	= 메모리 할당 생성자 ();
		
		// 2. 메서드의 호출
		myCalc.powerOn();	// Calculater 클래스의 myCalc 객체의 powerOn메서드를 호출
		
		// 3. 메서드 호출 [ 인수 2개짜리 ]
		myCalc.plus(5,10);	// 실행 해봐야 아무것도 안나옴.
		int result1 = myCalc.plus(5,10);
		// Calculater 클래스의 myCalc객체의 plus 메서드로 인수 2개를 던진 결과값을 result1에 저장.
		System.out.println("myCalc.plus(5,10);");
		System.out.println("myCalc.plus를 result1에 저장한 값 : " +result1);
		System.out.println("myCalc.plus를 직접 println에 호출한 값 : " +myCalc.plus(5,  10));
		
		
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("myCalc.divided를 result2에 저장한 값 : " +result2);
		
		
		myCalc.powerOff();
		
		
	}	// m e
}	// c e
