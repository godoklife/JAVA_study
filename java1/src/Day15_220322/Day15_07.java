package Day15_220322;

public class Day15_07 {
	public static void main(String[] args) {
		
		// P.601 쓰레드 제어 예제
			// 1. sleep(밀리세크) : 주어진 시간 동안 일시 정지
		
		// P.603 양보 yield() 예제
		ThreadA_15_07 threadA_15_07 = new ThreadA_15_07();
		ThreadB_15_07 threadB_15_07 = new ThreadB_15_07();
		
		threadA_15_07.start();
		threadB_15_07.start();
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		threadA_15_07.work=false;
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		threadA_15_07.work=true;
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		threadA_15_07.stop=true;
		threadB_15_07.stop=true;
		
		
	}
}
