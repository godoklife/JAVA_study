package Day09_220314;

public class Day09_04 {
	public static void main(String[] args) {
		
		// P.296~ 297 �������̵�
			// @Override : ������
			// ������ �μ��� �޼������ ��Ģ�����δ� �Ұ���.
			// �������̵��� ���� : ������ �̸��� �޼��带 ������ [ ���� ]
				
		
		int r = 10;	// ���� ������ ����
		
		// 1. ����Ŭ������ ��ü ����
		Calculator calculator = new Calculator();
		System.out.println("�� ���� : "+ calculator.areaCircle(r));
		
		// 2. ����Ŭ������ ��ü ����
		Computer computer = new Computer();
		System.out.println("��ǻ�� �� ���� : "+computer.areaCircle(r));
		
		// * ����Ŭ������ ����Ŭ���� �� �޼���� �ٸ���!!!
		
		Test test = new Test();
		System.out.println("�׽�Ʈ �� ���� : "+ test.areaCircle(r));
		
		
		
	}
}
