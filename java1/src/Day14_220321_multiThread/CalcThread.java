package Day14_220321_multiThread;

public class CalcThread extends Thread{
	
	public CalcThread(String name) {
		setName(name);	// �μ��� ���� �����ͷ� ������ �̸� ����
	}
	
	// ��Ƽ������ ���� [ �������̵� ] 
	@Override
	public void run() {
		for(long i=0; i<2000000000; i++) {
			// �׳� cpu�� ���� �Ŵ� ����
		}
		System.out.println("���� �������� ������ �̸� : "+ getName());
	}
}
