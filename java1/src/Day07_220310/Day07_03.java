package Day07_220310;

public class Day07_03 {
	public static void main(String[] args) {
		
		// 메서드 호출시
			// 내부호출 : 메소드가 선언된 클래스[파일] 내 메서드 호출시
				// 메서드명만 호출
				// avg(인수1, 인수2);
			// 외부호출 : 메서드가 선언된 다른 클래스[다른 파일] 내 메서드 호출시
				// 객체를 통해 메서드명 호출
				// myCalc.avg(인수1, 인수2);
		Calculater2 myCalc = new Calculater2();
		myCalc.execute();
	}
}
