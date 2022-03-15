package Day10;

import Day10_인터페이스연습.RemoteControl;

public class Day10_02 {
	public static void main(String[] args) {
		// 인터페이스
				// 노션에 정리했읍니다. [ 10일차 ]
			
		// 1. 인터페이스 객체 선언
		RemoteControl rc;
		//인터페이스명	  객체명;
		
		// 인터페이스에 텔레비전 클래스 메모리 할당
		rc = new Television();
		rc.turnOn();
		
		rc.setVolume(20);
		
		rc.turnOff();
		
		
		// 인터페이스 내 클래스 메모리 교체
		System.out.println("rc = new Audio();");
		rc = new Audio();	// rc객체를 테레비에서 오디오로 교체!
		
		rc.turnOn();
		rc.setVolume(30);
		rc.setVolume(5);
		rc.turnOff();
		
		RemoteControl rc2 = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("익명구현객체 on");
			}
			
			@Override
			public void turnOff() {
				System.out.println("익명구현객체 off");
				
			}
			
			@Override
			public void setVolume(int volume) {
				System.out.println("익명구현객체 volume");
				
			}
		};
		
		rc2.turnOn();
		rc2.turnOff();
		rc2.setMute(true);
		
		// 정적 메서드 호출
		RemoteControl.changeBattery();	// 객체 없이 호출 가능하다.
		
		// 메모리 할당 받는 방법
			// 메모리 할당 하는 이유?? 
				//외부 클래스&인터페이스 내 필드, 메서드, 저장 기능 사용하려면 메모리에 할당 해주어야만 함.
			// 1. new 연산자
			// 2. static 연산자
		
		
	}
}
