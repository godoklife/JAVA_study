package Day07_220310;

public class Car2 {
	// 1. �ʵ�
	int speed;
	
	// 2. ������
		// �����ڰ� ������ �⺻�����ڸ� �����Ϸ��� �ڵ����� �߰�!!
	// 3. �޼���
	int getSpeed() {	// �μ� X, ��ȯ O
		return speed;
	}	// getSpeed END
	
	void keyTurnOn() {	// �μ� X, ��ȯ X
		System.out.println("Ű�� �����ϴ�");
	}	// keyTurnOn END
	
	void run() {	// �μ� X, ��ȯ X
		for(int i=10; i<=50; i+=10) {
			// * i�� 10���� 50���� 10������ �����ϸ� �ݺ�
			speed = i;	// i�� speed�ʵ忡 ����
			System.out.println("�޸��ϴ�. �ü� : "+speed+" km/h");
		}	// run END
	}
}
