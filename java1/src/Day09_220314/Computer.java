package Day09_220314;

public class Computer extends Calculator{
			// ����Ŭ���� extends ����Ŭ����
	// 1. �ʵ�
	
	// 2. ������
	
	// 3. �޼���
		// * �������̵� [ �θ�Ŭ���� �� �޼��� ������(����) ]
		// ctrl + space_bar �����g. �������̵� �ӽñ� �㲨��.
	
	@Override	// ��� �� �θ� ������ �ִ� �޼��� ȣ��
	double areaCircle(double r) {
		System.out.println("computer ��ü�� areaCircle() ����");
		return Math.PI*r*r;
		//return super.areaCircle(r);
	}
}
