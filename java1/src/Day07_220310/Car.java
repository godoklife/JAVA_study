package Day07_220310;

public class Car {
	// Ŭ���� ����
	
	// 1. �ʵ� ( �����Ͱ� ����Ǵ� �κ� )
	int gas;
	// 2. ������
		// ������ ���� ���ϸ� �����Ϸ��� �ڵ����� �⺻������ ����.
	// 3. �ż��� ( �Լ��� �����)
		// 1. gas�� �ܺηκ��� �Է¹޾Ƽ� ���ο� �����ϴ� �޼���
	void setGas(int gas) {	// �μ� O, ��ȯ X
//	���� X �޼���� ( �μ�1�� )
		this.gas = gas;
// ���κ����� �ܺκ����� �̸��� ���� �� �����ϴ� ���?
		// this.gas = gas  -> ���� gas = �ܺο��� ���� gas
	}
	
		// 2.
	boolean isLeftGas() {	//�μ� X, ��ȯ O
//  ��ȯ�� ����  �޼����(�μ� 0��)
		if(gas==0) {
			System.out.println("Not enough gas");
			return false;	// ���� ������ ������ ������ false ��ȯ
		}
		else {
			System.out.println("Gas�� �ֽ��ϴ�.");
			return true;	// ������ ������ true ��ȯ
		}
	}	// isLeftGas end
	
	// 3. gas�� 0�϶����� -1�� �ݺ� ���ҿ��� ����
		// 0�̸� ���� ����
	void run() {	
		while(true) {
			if(gas>0) {
			System.out.println("�޸��ϴ�. (���� �ܷ� : " +this.gas+")");
			this.gas--;
			}
			else {
				System.out.println("|||||||����ϴ�. (���� �ܷ� : " +this.gas+")");
				break;	// return;���� ��ä ����
			}
				
		}
	}
	
}
