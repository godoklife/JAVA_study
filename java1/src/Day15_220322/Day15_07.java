package Day15_220322;

public class Day15_07 {
	public static void main(String[] args) {
		
		// P.601 ������ ���� ����
			// 1. sleep(�и���ũ) : �־��� �ð� ���� �Ͻ� ����
		
		// P.603 �纸 yield() ����
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
		
		
		
		
		// P.607 join(); ����
		
		SumThread_15_07 sumThread_15_07 = new SumThread_15_07();
		
		sumThread_15_07.start();
		
		try {sumThread_15_07.join();} catch (Exception e) {}
			// �̰� ������ sumThread�� for���� ������ ���� getSum�� ����Ǿ����.
				// ���� 0�� ��µǹ���.
			// .join()�� �۵��ϸ� �������尡 ������ ��ġ�� getSum�� ����Ǵ� 5050 ��µ�.
		try {Thread.sleep(100);} catch (Exception e) {}
		
		System.out.println("1~100�� �� : "+sumThread_15_07.getSum());
		
		
		
	}
}
