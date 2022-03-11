package Day08_220311;

public class Calculater {
	
	// 자료형 앞에 static을 붙이면 따로 객체 생성 없이 클래스.필드 또는 클래스.메서드 접근 가능
	
	// 1. 필드
	static double pi = 3.14159;
	// 정적 변수
	
	// 2. 생성자
	public Calculater() {
		// TODO Auto-generated constructor stub
	}
	// 3. 메서드
	static int plus(int x, int y) {
		return x+y;
	}
	
	static int minus(int x, int y) {
		return x-y;
	}
	
}
