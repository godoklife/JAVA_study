package Day14_220321_multiThread;

import java.awt.Toolkit;

public class BeepTask implements Runnable{
					// �������̽�	[Runnable]
	
	// ���ø����� ���� �� �߻�޼��� �����ϱ�!!!!!
		// ctrl + space_bar
	
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// �Ҹ����� Ŭ����. �߿��Ѱ� �ƴ�.
		for(int i=0; i<5; i++) {
			System.out.println("run");
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}	// for END
	}	// run END
}	// class END
