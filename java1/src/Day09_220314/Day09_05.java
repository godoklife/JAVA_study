package Day09_220314;

public class Day09_05 {
	
	public static void main(String[] args) {
		// 1. ��ü ���� [ �ڵ��� 1�� ���� ]
		Car myCar = new Car();
			// Ŭ���� �� Ÿ�̾� ��ü�� 4�� ����
		
		// 2. �޼��� ȣ��
		for(int i=0; i<=5; i++) {
			myCar.run();
		}
		
		int problemLocation = myCar.run();
		switch(problemLocation) {
		case 1: 
			System.out.println("�� ���� �ѱ�Ÿ�̾� ��ü");
			myCar.frontLeftTire = new HankookTire("�տ���", 15);
			// ����Ŭ���� ��ü��� = new ����Ŭ����(); ����
			// ����� �޾ƾ߸� ����.
			break;	// switch�� Ż��.
		case 2: 
			System.out.println("�� ������ ��ȣŸ�̾� ��ü");
			myCar.frontRightTire = new KumhoTire("�տ�����", 13);
			break;
			
		case 3: 
			System.out.println("�� ���� �ѱ�Ÿ�̾� ��ü");
			myCar.backLeftTire = new HankookTire("�� ����", 15);
			break;
			
		case 4:
			System.out.println("�� ������ ��ȣŸ�̾� ��ü");
			myCar.backRightTire = new KumhoTire("�� ������", 13);
			break;
		}
		
		
	}	// main END
}	// class END
