package Day14_220321_multiThread;

public class Sound extends Thread{
	static boolean stop = true;	// 실행 여부 기록 플래그
	
	public void soundStop(boolean stop) {
		this.stop = stop;
		if(stop) {
			System.out.println("노래 켜기======");
		}
		else {
			System.out.println("노래 끄기.");
		}
	}
	
	
	@Override
	public void run() {
		while(stop) {
			System.out.println("~~~ 소리 재생 중 ~~~");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}
