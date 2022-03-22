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
		
		
		
		
		// P.607 join(); 예제
		
		SumThread_15_07 sumThread_15_07 = new SumThread_15_07();
		
		sumThread_15_07.start();
		
		try {sumThread_15_07.join();} catch (Exception e) {}
			// 이게 없으면 sumThread의 for문이 끝나기 전에 getSum이 실행되어벌임.
				// 따라서 0이 출력되버림.
			// .join()이 작동하면 섬쓰레드가 연산을 마치고 getSum이 실행되니 5050 출력됨.
		try {Thread.sleep(100);} catch (Exception e) {}
		
		System.out.println("1~100의 합 : "+sumThread_15_07.getSum());
		
		
		
	}
}
