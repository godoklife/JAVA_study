package Day10_인터페이스연습;

public interface RemoteControl {	// 인터페이스 선언
	
	
	// 멤버
		// 1. 상수 필드 	: 고정된 데이터
	public int MAX_VOLUME = 10;	// 리모컨의 최대 볼륨
	public int MIN_VOLUME = 0;	// 리모컨의 최소 볼륨
	
		// 2. 추상 메서드	: 선언 O, 구현 X
	public void turnOn();		// {} 중괄호 생략 -> [ 구현 안해! ]
	public void turnOff();		// 상동.
	public void setVolume(int volume);	// 상동.
	
		// 3. 디폴트 메서드	: 선언 O, 구현 O	[ java8 이상 ]
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리 합니다.");
		} else {
			System.out.println("무음 해제 합니다");
		}
	}	// setMute END
	
		// 4. 정적 메서드	: 선언 O, 구현 O,	[ java8 이상, 객체없이 호출 가능(static) ]
	static void changeBattery() {
		System.out.println("건전지를 교체합니다");
	}
	
	
	
	
	
}
