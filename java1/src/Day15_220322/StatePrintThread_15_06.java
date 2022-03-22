package Day15_220322;

public class StatePrintThread_15_06 extends Thread{

	private Thread targetThread;
	
	public StatePrintThread_15_06(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		while(true) {
			Thread.State state = targetThread.getState();	// 쓰레드 상태 얻기
			System.out.println("타겟 쓰레드 상태 : "+ state);
			
			if(state==Thread.State.NEW) {
				targetThread.start();
			}
			
			if(state==Thread.State.TERMINATED) {
				break;
			}
			
			try {Thread.sleep(500);} catch (Exception e) {}
		}
	}
}
