package Day15_220322;

public class 채팅_15_04 implements Runnable{

	@Override
	public void run() {
		// 병렬처리 할 코드 작성부
		
		try {
			Thread.sleep(400);
		} catch (Exception e) {	}
		
			while(true) {
			System.out.println("========= 채팅 실행 중 =========");
			try {
				Thread.sleep(500);
			} catch (Exception e) {	}
		}	
	}
}
