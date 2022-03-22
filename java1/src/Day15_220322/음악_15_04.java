package Day15_220322;

public class 음악_15_04 extends Thread{
	@Override
	public void run() {
		// 병렬처리 할 코드 작성부
		try {
			Thread.sleep(200);
		} catch (Exception e) {	}
		
		while(true) {
		System.out.println("음악 재생 중.");
		try {
			Thread.sleep(500);
		} catch (Exception e) {	}
		}
	}
}
