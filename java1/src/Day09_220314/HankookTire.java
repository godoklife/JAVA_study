package Day09_220314;

public class HankookTire extends Tire {
			// ����Ŭ���� 	extends	����Ŭ����
	// 1. �ʵ�
	
	// 2. ������
	public HankookTire(String location, int maxRotation)
	{
		super(location, maxRotation);
		// super(�μ�1, �μ�2)	// ����Ŭ���� �� [�μ�2��] ������ ȣ��
	}
	
	// 3. �޼���
	@Override	// ����Ŭ���� �� �޼��带 ������ [ ���� ] 
	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation<maxRotation) {
			System.out.println(maxRotation + "�ѱ�Ÿ�̾� ���� : " + (maxRotation - accumulatedRotation) + "ȸ ���ҽ��ϴ�.");
			return true;
		}
		else {
			System.out.println("***"+location+"�ѱ�Ÿ�̾� ��ũ ***");
			return false;
		}
	}	// roll END
}	// class END
