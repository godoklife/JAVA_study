package Day14_220321_multiThread;

public class 碍酒瘤家府 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
		System.out.println("港港港");
		try {
			Thread.sleep(500);
		} catch (Exception e) {}
		}	// for END
	}
}
