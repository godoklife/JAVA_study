package Day09_220314;
//Day09_05
public class KumhoTire extends Tire{
			// ����Ŭ����	extends	����Ŭ����
	
	// 1. �ʵ�
	
	// 2. ������
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
			// ����Ŭ���� �� ������ ȣ�� ( = ����)
	}
	// 3. �޼���
	@Override	// ����Ŭ���� �� �޼��带 ������ [ ���� ] 
	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation<maxRotation) {
			System.out.println(maxRotation + "��ȣŸ�̾� ���� : " + (maxRotation - accumulatedRotation) + "ȸ ���ҽ��ϴ�.");
			return true;
		}
		else {
			System.out.println("***"+location+"��ȣŸ�̾� ��ũ ***");
			return false;
		}
	}	// roll END
}