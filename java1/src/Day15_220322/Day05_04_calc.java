package Day15_220322;

public class Day05_04_calc {
	public static void main(String[] args) {
		
		// p. 591 동기화 예제
			// 
		
		// 1. 계산기 객체 생성
		Calc_15_04 계산기1 = new Calc_15_04();
		
		
		// 2. 
		User1_15_04 사람1 = new User1_15_04();
		사람1.setCalc(계산기1);
		사람1.start();
		
		// 3. 
		User2_15_04 사람2 = new User2_15_04();
		사람2.setCalc(계산기1);
		사람2.start();
	}
}
