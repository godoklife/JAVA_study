package Day15_220322;

public class ����_15_04 extends Thread{
	@Override
	public void run() {
		// ����ó�� �� �ڵ� �ۼ���
		try {
			Thread.sleep(200);
		} catch (Exception e) {	}
		
		while(true) {
		System.out.println("���� ��� ��.");
		try {
			Thread.sleep(500);
		} catch (Exception e) {	}
		}
	}
}
