package Day15_220322;

public class Day05_04_calc {
	public static void main(String[] args) {
		
		// p. 591 ����ȭ ����
			// 
		
		// 1. ���� ��ü ����
		Calc_15_04 ����1 = new Calc_15_04();
		
		
		// 2. 
		User1_15_04 ���1 = new User1_15_04();
		���1.setCalc(����1);
		���1.start();
		
		// 3. 
		User2_15_04 ���2 = new User2_15_04();
		���2.setCalc(����1);
		���2.start();
	}
}
