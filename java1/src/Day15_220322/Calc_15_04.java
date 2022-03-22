package Day15_220322;

public class Calc_15_04 {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		// 2초간 일시 정지
		try {Thread.sleep(2000);} catch (Exception e) {}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
}
