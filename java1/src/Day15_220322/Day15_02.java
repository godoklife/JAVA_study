package Day15_220322;

public class Day15_02 {
	public static void main(String[] args) {
		
		// 1. 인터페이스
			
		
		// 예시1) 구현객체 만들기
		게임패드_15_02 pad1 = new 메이플스토리_15_02();
		//인터페이스명	객체명 = new (구현한)클래스명();
		
		// 예시2) 익명객체 만들기
		게임패드_15_02 pad2 = new 게임패드_15_02() {
			@Override
			public void C버튼() {	}
			@Override
			public void B버튼() {	}
			@Override
			public void A버튼() {}
		};
		
		pad1 = new 피파온라인_15_02();
		
		게임_15_02 g1 = new 게임_15_02();
		g1 = new 메이플스토리_15_02();
		g1 = new 피파온라인_15_02();
		
	}
}
