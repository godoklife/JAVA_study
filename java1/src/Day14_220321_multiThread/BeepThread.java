package Day14_220321_multiThread;

import java.awt.Toolkit;

public class BeepThread extends Thread{
	
	// �� Ŭ������ Thread Ŭ������ ��ӹ޾����� �ٸ� Ŭ������ ��ӹ��� �� ����.
	
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i = 0; i<5; i++) {
			System.out.println("Thread���");
			try {
				Thread.sleep(500);
			} catch (Exception e) {	}
		}
		
	}
	
}
