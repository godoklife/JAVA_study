package Day14_220321_multiThread;

public class �������Ҹ� extends Thread{
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
		System.out.println("�۸۸�");
		try {
			Thread.sleep(500);
		} catch (Exception e) {}
		}	// for END
	}
}
