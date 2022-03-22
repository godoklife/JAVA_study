package Day15_220322;

public class Day05_04 {
	public static void main(String[] args) {
		
		// 12장 : 쓰레드
		
		
		음악_15_04 m1 = new 음악_15_04();
			// 음악_15_04클래스는 Thread클래스를 상속받았기때문에 start()를 바로 호출 가능하다.
		m1.start();
		
		채팅_15_04 c1 = new 채팅_15_04();	
			// runnable 인터페이스는 start를 갖고 있지 않음. 따라서 쓰래드 객체 생성, 생성자에 c1을 넣어준 뒤 실행해야함.
		Thread thread = new Thread(c1);
		thread.start();
		
		while(true) {
			System.out.println("프로그램 실행 중.");
			try {
				Thread.sleep(500);
			} catch (Exception e) {	}
			
			
			
			
			
			
		}	// w e
	} // m e
}	// c e
