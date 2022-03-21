package Day14_220321_multiThread;

import java.awt.Toolkit;

public class Day14_04 {
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// 소리 관련 메서드 제공. 별로 쓸일없음
		
		
		// P. 581 예제1
			// 싱글스레드 (main메서드)
			// 0.5초 간격으로 소리 출력
			// 그 후 0.5초 간격으로 띵 출력
		for(int i=0; i<5; i++) {
			toolkit.beep();	// 소리 출력
			try {
				Thread.sleep(500);	// 일반예외 발생
			} catch (Exception e) {	}
		}
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		
		System.out.println("==============싱글스레드 완료=====================");
		
		
		// P.582 예제2 Runnable 인터페이스 사용
			// 멀티스레드
		// 1. 인터페이스의 구현객체
		Runnable beepTask = new BeepTask();
		// 2. Thread 클래스 객체 생성시 생성자에 구현객체 넣기.
		Thread thread = new Thread(beepTask);
		// 3. thread 객체 내 start()메서드 호출.
		thread.start();
//		
//		for(int i=0; i<5; i++) {
//			toolkit.beep();	// 소리 출력
//			try {
//				Thread.sleep(500);	// 일반예외 발생
//			} catch (Exception e) {	}
//		}
//		
		for(int i=0; i<5; i++) {
			System.out.println("main");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
		
		System.out.println("===============런너블 인터페이스 완료===================");
		
		
		// P.584 예제3 thread
		
		// 1. 클래스 객체 생성
		Thread thread2 = new BeepThread();
		// 슈퍼클래스 	   = 자식클래스의 생성자
		// 			부모 <--- 자식 [ 자동형변환 ]
		//			부모 ---> 자식 [ 강제형변환 ]
		// 2. Thread 객체 내 start() 메서드 호출
			// start메서드의 역할 : run메서드 호출 -> 멀티스레드 실행
		thread2.start();
		
		// 출력
		for(int i=0; i<5; i++) {
			System.out.println("main띵띵");
			try {
				thread.sleep(500);	// 
			} catch (Exception e) {	}
		}
		System.out.println("==============쓰레드 클래스 완료====================");

		// 인터페이스 사용 방법
			// 1. 클래스에게 implements 당한 후 구현. => 구현객체
			// 2. 인터페이스에 new 연산자를 통한 추상메소드를 구현 => 익명객체
		
		// * 익명 쓰레드 객체
		
		Runnable runnable = new Runnable() {	// 여기서 Runnable은 인터페이스임.
			// 인터페이스에 new 연산자 사용시(메모리 할당시)
			// 추상메서드를 먼저 구현!!!
			// 추상메서드를 구현하지 않으면 익명객체 선언 불가능.
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0; i<5; i++) {
					System.out.println("익명Thread객체 띵띵");
					try {
						Thread.sleep(500);
					} catch (Exception e) {	}
				}
			}
		};
		
		Thread thread3 = new Thread(runnable);
		thread3.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("main띵띵");
			try {
				thread.sleep(500);	// 
			} catch (Exception e) {	}
		}
		
		
		System.out.println("==============익명 객체 쓰레드 완료====================");

		
		
		System.out.println("main메서드 안에 있는 스레드 이름 : "+ thread.currentThread().getName());
			// Thread.currentThread() : 현 코드를 읽어주는(실행중인) 스레드 호출
				// .getName() : 스레드 이름 호출 | setName() : 스레드 이름 변경
		System.out.println("작업스레드 1 이름 : "+thread.getName());
		System.out.println("작업스레드 2 이름 : "+thread2.getName());
		System.out.println("작업스레드 3 이름 : "+thread3.getName());
		
		System.out.println("===================================================");

		
		
		// P. 590
		
		for(int i=1; i<=10; i++) {
			
			// i는 1부터 차례대로 생성되지만, CPU는 순환할당에 의해 처리하므로
			// 차례대로 i가 출력되지 않음.(선입선출이 아님.)
			Thread thread4 = new CalcThread("Thread"+i);
			if(i!=10){
				thread4.setPriority(Thread.MIN_PRIORITY);
			}
			else {
				thread4.setPriority(Thread.MAX_PRIORITY);
			}
			thread4.start();
			
		}
		
		

		
	}
}
