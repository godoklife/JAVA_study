package Day07_220310;

public class Calculater {
	
	// �޼����
	
	// 1. �ʵ�
	
	
	// 2. ������
		// ���� ������ ������ 1���� ������
		// �⺻ �����ڰ� �ڵ����� �߰��ȴ�!
		// �⺻�����ڶ� ? �Ű������� ���°�
	
	 // 3. �޼���
	void powerOn() {	// 1. �μ� X(�Ұ�ȣ ���� �����), ��ȯ X(���� Ÿ���� void)
		System.out.println("������ �մϴ�.");
		// 1. void : ���� Ÿ��
			// void?? �Լ��� ����Ǹ鼭 ������ ����Ÿ�� ����!!�� ��.
			// void�� �϶��� return ���� ����. [ ��, ����� �߰��� ���� �Լ� ����. ���� ���ɾ� ���� X ]
		// 2. powerOn : �޼��� �̸� [ �ƹ��ų� ] 
		// 3. �Ұ�ȣ( ) : �Ű������� ��ġ. [ �Լ��� ������ ������ �� ]
		// 4. �߰�ȣ { } : ���� �ڵ尡 ��ġ.
	}
		
	int plus(int x, int y) {
		int result = x+y;
		return result;
			// result�� �Լ��� ȣ���ߴ� ��ġ�� �ǵ��ư���. 
				// String.equals("ABC"); �� �ش� ��ġ�� true, false ��ȯ�ϴ°�ó��.
	}
	// 1. int : ��ȯ�� Ÿ�� [ int �� ����Ÿ�� ��ȯ�ȴ�! ] ��ȯ O
		// 5. return ��ȯ��;
			// ���� Ÿ���� int �̱� ������ return �������� int�� ����Ÿ�� �;� �Ѵ�.
	// 2. plus : �޼��� �̸� [ �� �ǹ� ����. �ҹ��ڷ� �ϴ°� ���� ]
	// 3. ( int x, int y) : �Լ� ȣ��� ������ ����Ÿ x, y�� int������ �ްڴ� ����!
	// 4. { ����� } : �����
	
	
	double divide(int x, int y) {	// �μ� O, ��ȯ O
//  ����Ÿ��  �޼���� ( �μ�1, �μ�2 ) { ����� }
		double result = (double)x / y;
			// (�ڷ���) ������ : ��������ȯ
				// int���� double������ ������ȯ
					// ��?? ������ �� �Ҽ����� ���ü� �ִµ�, int / int �� �ϸ� �Ҽ����� �սǵ�.
		return result;
	}
	
	void powerOff() {	// �μ� X, ��ȯ X
		System.out.println("������ ���ϴ�.");
	}
	
	
	
	
	
	
	
	
}