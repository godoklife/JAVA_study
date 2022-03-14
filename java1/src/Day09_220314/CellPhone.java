package Day09_220314;

public class CellPhone {	// 클래스 선언
	
	// 1. 필드
	String model;
	String color;
	
	// 2. 생성자
	
	// 3. 메서드
	void powerOn() {
//	반환타입 메서드명(인수) {실행코드}	// 인수도 없고 반환타입도 없음.
//	반환타입이 void인 경우에만! return 생략 가능.		
		System.out.println("전원을 켭니다.");
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
	
	void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	void sendVoice(String message) {
//	반환타입 메서드명(인수) {실행코드}	
//	message라는 외부에서 들어오는 인수가 있으며, 반환은 없음.
		System.out.println("본인 : "+message);
	}
	
	void receiveVoice(String message) {
		System.out.println("상대방 : "+message);
	}
	
	void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
