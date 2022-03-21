package Day14_220321_multiThread;

public class Movie extends Thread{
	
	static boolean stop = true;
	
	public void Moviestop (boolean stop) {
		this.stop = stop;
		if(stop)
			System.out.println("영상 재생을 시작합니다.");
		else
			System.out.println("영상 재생을 중지합니다.");
	}
	
	public void run() {
		while(stop) {
			System.out.println("~~~ 영상 재생 중 ~~~");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
	
	
}
