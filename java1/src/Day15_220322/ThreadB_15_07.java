package Day15_220322;

public class ThreadB_15_07 extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("ThreadB �۾� ����");
			}
			else {
				Thread.yield();// work�� false�� �Ǹ� �ٸ� �����忡�� ������ �纸�Ѵ�.
			}
		}
		System.out.println("ThreadB ����.");
	}
}
