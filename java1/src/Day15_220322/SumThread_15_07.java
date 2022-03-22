package Day15_220322;

public class SumThread_15_07 extends Thread{
	private long sum;

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			sum+=i;
		}
	}
}
