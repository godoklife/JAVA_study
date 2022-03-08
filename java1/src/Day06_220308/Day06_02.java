package Day06_220308;

public class Day06_02 {	// c s
	public static void main(String[] args) {	// m s
		Car myCar = new Car();	// 객체 생성
			// 1. Car : 정의된 클래스명
			// 2. MyCar : 객체 이름 [ 아무거나, 가능하면 클래스명 소문자 권장 ]
			// 3. new : 메모리 할당 연산자
			// 4. Car() : 생성자
		
		// 2. 객체 내 필드 호출		[ .(마침표) : 접근연산자 ]
		System.out.println("제작 회사 : " +myCar.company);
			// myCar 객체 내 필드 접근
			// 객체명.멤버명
		System.out.println("모델명 : "+myCar.model);
			// myCar의 model 필드 호출
		System.out.println("색상 : "+myCar.color);
			// myCar.color : color 필드 호출
		System.out.println("최고속도 : "+myCar.maxSpeed);
			// myCar.maxspeed : maxspeed 필드 호출
		System.out.println("현재속도 : "+myCar.speed);
			// myCar.speed : speed 필드 호출
		
	
		
		
		
	}	// m e
}	// c e
