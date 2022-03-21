package Day14_220321_multiThread;

import java.awt.Toolkit;

public class BeepThread extends Thread{
	
	// 이 클래스는 Thread 클래스를 상속받았으니 다른 클래스를 상속받을 수 없다.
	
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i<5; i++) {
			System.out.println("Thread띵띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {	}
		}
		
	}
	
}
