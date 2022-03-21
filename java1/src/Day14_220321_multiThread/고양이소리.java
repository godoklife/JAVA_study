package Day14_220321_multiThread;

public class 绊剧捞家府 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
		System.out.println("成成成");
		try {
			Thread.sleep(500);
		} catch (Exception e) {}
		}	// for END
	}
}
