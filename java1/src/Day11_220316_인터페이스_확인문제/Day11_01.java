package Day11_220316_인터페이스_확인문제;

public class Day11_01 {
	// P. 386 확인문제
		// 1. 3 [ 인터페이스의 맴버 : 1. 상수필드 2. 추상메서드 3. 디폴트메서드 4. 정적메서드
		// 2. 4 [ 인터페이스 변수 = 구현객체 ] 
			// 구현객체 ?? 클래스가 implements한 객체
	
		// 3. 사용 class : Dog, Cat
//	private static void printSound(Soundable soundable) {
////	접근제한자	정적		반환타입	메서드명	(인수 [ 변수, 배열, 객체, 인터페이스 ] )	
//						//	지금은  (인터페이스 객체)
//		System.out.println(soundable.Sound());
//	}
//	
//	public static void main(String[] args) {
//		printSound(new Cat());
//		printSound(new Dog());
//	}
//	
	
	// 4. 
		 // Dao : DB접근객체, 
//	public static void dbWork(DataAccessObject dao) {
//		dao.select();
//		dao.insert();
//		dao.update();
//		dao.delete();
//	}
//	public static void main(String[] args) {
//		dbWork(new OracleDao());
//		dbWork(new MySquDao());
//	}
	
	// 5. 익명객체 [ 인터페이스가 직접 구현 ]
		// 구현 객체 : 인터페이스 객체명 = new 클래스();
		// 익명 객체 : 인터페이스 객체명 = new 인터페이스() { 구현 };  세미콜론!!!
			// 익명 객체는 보통 1회용으로 쓸때 주로 사용.
			// 구현 객체는 몇번 재활용할때는 사용.
	static Action action = new Action() {	// 이게 익명 객체.
		
		@Override
		public void work() {	//
			System.out.println("복사를 합니다.");
		}
	};
	
	public static void main(String[] args) {
		action.work();
	}
	
}
