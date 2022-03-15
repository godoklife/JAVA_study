package Day10;

public class 축구 implements GamePad{
	
	@Override
	public void Abutton() {
		System.out.println("슈팅");
	}
	@Override
	public void Bbutton() {
		System.out.println("수비");
	}
	@Override
	public void Cbutton() {
		System.out.println("선수교체");
	}
}
