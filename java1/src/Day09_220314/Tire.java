package Day09_220314;
//Day09_05
public class Tire {	// Ŭ���� ����
	
	
	// 1. �ʵ�
	public int maxRotation;			// �ִ� ȸ���� ( Ÿ�̾� ���� )
	public int accumulatedRotation;	// ���� ȸ����
	public String location;			// Ÿ�̾��� ��ġ	
	
	// 2. ������ [ ��ü ������ �ʱⰪ ]
	public Tire(String location, int maxRotation) {
					// Ÿ�̾� �ʱⰪ, �ִ� ȸ����
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	// 3. �޼���
	public boolean roll() {	// Ÿ�̾ ȸ���ϴ°� ������ �޼���
		++accumulatedRotation;	// ���� ȸ���� 1 ����
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+"tire���� : " + (maxRotation - accumulatedRotation)+"ȸ ���ҽ��ϴ�.");
			return true;
		}
		else {
			System.out.println("***"+location+"Tire ��ũ ***");
			return false;
		}
	}	// roll END
}	// class END
