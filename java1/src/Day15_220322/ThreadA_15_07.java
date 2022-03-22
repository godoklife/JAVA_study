package Day15_220322;

public class ThreadA_15_07 extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("ThreadA 작업 내용");
			}
			else {
				Thread.yield();// work가 false가 되면 다른 스레드에게 실행을 양보한다.
			}
		}
		System.out.println("ThreadA 종료.");
	}
}
