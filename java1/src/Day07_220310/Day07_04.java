package Day07_220310;

public class Day07_04 {
	public static void main(String[] args) {
		
		// 1. �ܺ�ȣ�� �ϱ� ���� �ݵ�� �ʿ��Ѱ�?? ��ü ����!!!!!
		Car2 myCar = new Car2();
		
		// 2. �ڵ��� �õ� �ɱ�
		myCar.keyTurnOn();// �μ� X, ��ȯ X
		
		// 3. �ڵ��� ���� �޼��� ȣ��
		myCar.run();// �μ� X, ��ȯ X
		
		// 4. ���� �ӵ� Ȯ�� �޼��� ȣ��
		int speed = myCar.speed;
		System.out.println("���� �ӵ� : " +speed);
		
	}

}
