package Day14_220321;

public class Day14_03_메서드 {
	public static void main(String[] args) {
		
		// 메서드 = 함수
			// 1. 인수O, 반환 O
			// 메서드를 호출하는 방법 [ 1. 객체를 통해, 2. static ]
		
		// 1. 객체 생성 후 호출
		메서드_컨트롤러 컨트롤러 = new 메서드_컨트롤러();
		컨트롤러.carIn1("1234");
		
		// 2. static형 객체 직접 호출
		메서드_컨트롤러.carIn2("1234");
		
		
	}
}
