package Day14_220321_multiThread;

/*
 * 사용 클래스
 * 고양이소리
 * 호랑이소리
 * 강아지소리
 */


public class Day14_05 {
	public static void main(String[] args) {
		// 강아지소리, 고양이소리, 호랑이소리 동시에 출력
		// 1. Thread 클래스로부터 extends 
			// 오버라이딩 -> 재정의
		// 2. Runnable 인터페이스로부터 implements
			// 오버라이딩 -> 구현
		// 3. Runnable 인터페이스를 익명 인터페이스로 객체화
			// new 연산자 통해 메모리 할당 후 오버라이딩 -> 구현
		
		// main 쓰레드가 새로 생성된 쓰레드 호출.
		
		// Thread 클래스로부터 상속받은 자식클래스의 객체 생성
		강아지소리 강아지 = new 강아지소리();	
		// 자식클래스의 객체로부터 부모클래스 내 메서드 실행
		강아지.start();	// ->.run() 호출과 같다. [ 멀티쓰레드 시작 ]
		
		고양이소리 고양이 = new 고양이소리();
		고양이.start();
		
		호랑이소리 호랑이 = new 호랑이소리();
		호랑이.start();
		
		
	}
}
