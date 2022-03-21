package Day14_220321_multiThread;

import java.awt.Toolkit;

public class BeepTask implements Runnable{
					// 인터페이스	[Runnable]
	
	// 임플리먼츠 사용시 꼭 추상메서드 구현하기!!!!!
		// ctrl + space_bar
	
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// 소리내는 클래스. 중요한거 아님.
		for(int i=0; i<5; i++) {
			System.out.println("run");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}	// for END
	}	// run END
}	// class END
