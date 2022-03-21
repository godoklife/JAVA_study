package Day14_220321_multiThread;

public class CalcThread extends Thread{
	
	public CalcThread(String name) {
		setName(name);	// 인수로 받은 데이터로 쓰레드 이름 변경
	}
	
	// 멀티쓰레드 구현 [ 오버라이드 ] 
	@Override
	public void run() {
		for(long i=0; i<2000000000; i++) {
			// 그냥 cpu에 부하 거는 목적
		}
		System.out.println("현재 실행중인 쓰레드 이름 : "+ getName());
	}
}
