package Day15_220322;

public class Day05_04 {
	public static void main(String[] args) {
		
		// 12�� : ������
		
		
		����_15_04 m1 = new ����_15_04();
			// ����_15_04Ŭ������ ThreadŬ������ ��ӹ޾ұ⶧���� start()�� �ٷ� ȣ�� �����ϴ�.
		m1.start();
		
		ä��_15_04 c1 = new ä��_15_04();	
			// runnable �������̽��� start�� ���� ���� ����. ���� ������ ��ü ����, �����ڿ� c1�� �־��� �� �����ؾ���.
		Thread thread = new Thread(c1);
		thread.start();
		
		while(true) {
			System.out.println("���α׷� ���� ��.");
			try {
				Thread.sleep(500);
			} catch (Exception e) {	}
			
			
			
			
			
			
		}	// w e
	} // m e
}	// c e
