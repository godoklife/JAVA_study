package Day15_220322;

public class ThreadA_15_07 extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("ThreadA �۾� ����");
			}
			else {
				Thread.yield();// work�� false�� �Ǹ� �ٸ� �����忡�� ������ �纸�Ѵ�.
			}
		}
		System.out.println("ThreadA ����.");
	}
}
