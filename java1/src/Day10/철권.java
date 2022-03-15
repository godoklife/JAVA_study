package Day10;

public class 철권 implements GamePad{
	// 게임 클래스에 게임패드 인터페이스 연결
		// * 추상 메서드를 클래스 내 실제로 구현
		// -> 버튼에 대한 기능 구현
	
	@Override
	public void Abutton() {
		System.out.println("공격");
	}
	@Override
	public void Bbutton() {
		System.out.println("방어");
	}
	@Override
	public void Cbutton() {
		System.out.println("점프");
	}

}
