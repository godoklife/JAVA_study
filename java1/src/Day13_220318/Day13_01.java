package Day13_220318;

public class Day13_01 {
	public static void main(String[] args) {
		
		// P. 534 Math Ŭ����(java.lang��Ű��=import ���ʿ�.) : ���� ���� �޼��� ����. ��ü ���� ��� ����!
		
		System.out.println("���밪 : "+Math.abs(-5));	// Math.abs(����) : ���밪 ��ȯ
		System.out.println("���밪 : "+Math.abs(-3.14));
		
		System.out.println("�ø��� : "+Math.ceil(5.3487));	// �Ҽ��� ù°�ڸ����� �ø�
		System.out.println("�ø��� : "+Math.ceil(-5.3));		// -5 ���
		
		System.out.println("������ : "+Math.floor(5.3487));	// �Ҽ��� ù°�ڸ����� ����
		System.out.println("������ : "+Math.floor(-5.322));		// -6 ���
		
		System.out.println("�ִ밪 : "+Math.max(5,  9));		// �� �� �� ū �� ��ȯ
		System.out.println("�ִ밪 : "+Math.max(-5,  -9));	// �� �� �� ū �� ��ȯ
		
		System.out.println("�ִ밪 : "+Math.min(5,  9));		// �� �� �� ���� �� ��ȯ
		System.out.println("�ִ밪 : "+Math.min(-5,  -9));	// �� �� �� ���� �� ��ȯ
		
		System.out.println("������ : "+Math.random());		// 0.0~1.0 ������ �������� ��ȯ
		
		System.out.println("�ݿø� : "+Math.rint(5.5));		// ����� ������ �Ǽ��� (�ݿø��ϰ� ��Ȯ�ϰ� ������ ����.)(�Ǽ� ��ȯ)
		System.out.println("�ݿø� : "+Math.rint(-5.5));
		
		System.out.println("�ݿø� : "+Math.round(5.5));		// ������ �Ҽ� ù°�ڸ����� �ݿø�(���� ��ȯ)
		System.out.println("�ݿø� : "+Math.round(-5.5));
		
		double value = 12.3456;
		double tmp1 = value * 100;
		long tmp2 = Math.round(tmp1);
		double v16 = tmp2 / 100.0;
		System.out.println("v16 : "+tmp2);
		
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		
		// P. 536 Math.random()�� ����� �ֻ��� ����� [ 1 ~ 6 ������ �������� ]
		System.out.println("0~1������ �Ǽ��� : "+Math.random());	// 0~1
		System.out.println(Math.random()*6);					// 0~1 * 6 = 0~6
		System.out.println(Math.random()*6+1);					// 0~6 +1 = 1~7	-> ��Ȯ���� 1.0~6.9
		int num = (int)(Math.random()*6+1);						// int������ ��������ȯ �����ν� �Ҽ��� ��� ����.
		System.out.println(num);
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
		
		
		
		
		
	}
}
