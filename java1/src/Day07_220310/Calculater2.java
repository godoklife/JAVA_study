package Day07_220310;

public class Calculater2 {
	
	// 1. �ʵ�
	// 2. ������
	// 3. �޼���
		// 1. ���� �޼���
		// P. 227 ����
	void execute() {	// �μ� X, ��ȯ X
		double result = avg(7, 10);
		println("������:"+result);
	}
	
		// 2. ��� �޼���
	double avg(int x, int y) {	// �μ� O, ��ȯ O
		double sum = plus(x, y);
		double result = sum / 2;
		return result;
	}
		// 3. ���ϱ� �޼���
	int plus(int x, int y) {	// �μ� O, ��ȯ O
		int result = x+y;
		return result;
	}
		// 4. ������ �޼���
	void println(String message) {	// �μ� O, ��ȯ X
		System.out.println(message);
	}
	
	
}
