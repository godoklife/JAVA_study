package Day08_220311;

public class Day08_04 {	// c s
	public static void main(String[] args) {	// m s
		
		// P. 267~ 268 : Setter, Getter �޼���
			// �ʵ�� private�� ���Ǵ� ��찡 �ſ�ſ츹��
			// �ܺο��� �ʵ忡 �����Ҽ� ����.
			// why?? �ܺο��� �ʵ忡 ���������� �����ϰ� �޼��带 ���� �ʵ� ���ٸ��� ���.
			// Setter �޼��� : �ʵ� ������ ����
			// Getter �޼��� : �ʵ� ������ ȣ��
		
		// 1. ��ü ����
		Car myCar = new Car();
		// 2. ��ü �� �޼��� ȣ��
		myCar.setSpeed(-50);	// �߸��� �� �Է�
		// 3. Ȯ��
		System.out.println("���� �ӵ� : "+ myCar.getSpeed());
		// 4. ���� �Է�
		myCar.setSpeed(100);
		// 5. Ȯ��
		System.out.println("���� �ӵ� : "+ myCar.getSpeed());
		// 6. 
		if(!myCar.isStop()) {	// ���� ���°� !�ƴϸ�
			myCar.setStop(true);// ��� �����մϴ�.
			System.out.println("�����߽��ϴ�.");
		}
		
		
		System.out.println("���� �ӵ� : "+myCar.getSpeed());
		
	}	// m e
}	// c e
