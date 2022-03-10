package Day07_220310;

public class Calculater2 {
	
	// 1. 필드
	// 2. 생성자
	// 3. 메서드
		// 1. 실행 메서드
		// P. 227 예제
	void execute() {	// 인수 X, 반환 X
		double result = avg(7, 10);
		println("실행결과:"+result);
	}
	
		// 2. 평균 메서드
	double avg(int x, int y) {	// 인수 O, 반환 O
		double sum = plus(x, y);
		double result = sum / 2;
		return result;
	}
		// 3. 더하기 메서드
	int plus(int x, int y) {	// 인수 O, 반환 O
		int result = x+y;
		return result;
	}
		// 4. 결과출력 메서드
	void println(String message) {	// 인수 O, 반환 X
		System.out.println(message);
	}
	
	
}
