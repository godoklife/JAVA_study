package Day09_220314;
	// Day09_05
public class Car {
	
	// 1. �ʵ�	(����, ��ü, static���� ����)
	Tire frontLeftTire = new Tire("�տ���", 6);
	Tire frontRightTire = new Tire("�տ�����", 2);
	Tire backLeftTire = new Tire("�ڿ���", 3);
	Tire backRightTire = new Tire("�ڿ�����", 4);
	// 2. ������
	
	// 3. �޼���
	int run() {
		System.out.println("[�ڵ����� �޸��ϴ�.]");
		if(frontLeftTire.roll()==false) {
			stop();
			return 1;
		}
		// Ÿ�̾ ȸ���ߴµ� ��ũ�̸� false, ������ �������� true
		if(frontRightTire.roll()==false) {
			stop();
			return 2;
		}
		if(backLeftTire.roll()==false) {
			stop();
			return 3;
		}
		if(backRightTire.roll()==false) {
			stop();
			return 4;
		}
		return 0;	// ������ 0�̸� ��ũ�� ���ٴ°�
	}
	void stop() {
		System.out.println("�ڵ����� ����ϴ�.");
		
	}
}
