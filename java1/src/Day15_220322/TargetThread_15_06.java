package Day15_220322;

public class TargetThread_15_06 extends Thread{
	@Override
	public void run() {
		while(true) {
		for(long i=0; i<1000000000; i++) {}
		try {Thread.sleep(1500);} catch (Exception e) {}
		for(long i=0; i<1000000000; i++) {}
		}
	}
}
