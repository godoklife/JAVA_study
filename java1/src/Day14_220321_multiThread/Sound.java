package Day14_220321_multiThread;

public class Sound extends Thread{
	static boolean stop = true;	// ���� ���� ��� �÷���
	
	public void soundStop(boolean stop) {
		this.stop = stop;
		if(stop) {
			System.out.println("�뷡 �ѱ�======");
		}
		else {
			System.out.println("�뷡 ����.");
		}
	}
	
	
	@Override
	public void run() {
		while(stop) {
			System.out.println("~~~ �Ҹ� ��� �� ~~~");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}
