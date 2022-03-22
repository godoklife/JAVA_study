package Day15_220322;

public class User2_15_04 extends Thread{
	private Calc_15_04 calc_15_04;
	
	public void setCalc(Calc_15_04 calc_15_04) {
		this.setName("User2");
		this.calc_15_04 = calc_15_04;
	}
	
	@Override
	public void run() {
		calc_15_04.setMemory(50);
	}
}
