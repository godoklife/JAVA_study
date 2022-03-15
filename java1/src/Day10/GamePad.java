package Day10;

public interface GamePad {
	// 1. 상수 필드
	
	// 2. 추상 메서드
	public abstract void Abutton();
	public abstract void Bbutton();
	public abstract void Cbutton();
	
	// 3. 디폴드 메서드
	default void gamePadEnd() {
		System.out.println("게임패드 종료 ");
	}
	
	// 4. 정적 메서드	
	static void charging() {
		System.out.println("게임패드 충전");
	}
}
