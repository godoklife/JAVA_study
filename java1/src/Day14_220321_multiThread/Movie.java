package Day14_220321_multiThread;

public class Movie extends Thread{
	
	static boolean stop = true;
	
	public void Moviestop (boolean stop) {
		this.stop = stop;
		if(stop)
			System.out.println("���� ����� �����մϴ�.");
		else
			System.out.println("���� ����� �����մϴ�.");
	}
	
	public void run() {
		while(stop) {
			System.out.println("~~~ ���� ��� �� ~~~");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
	
	
}
