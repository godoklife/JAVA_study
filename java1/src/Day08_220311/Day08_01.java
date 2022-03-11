package Day08_220311;

public class Day08_01 {	// c s
	public static void main(String[] args) {	// m s
		
		// P.238 : static
			// ���� ���� 
			// �������� ������ = ���α׷� ��������� ���Ǵ� �޸�
			
		// * Ŭ���� �� �ʵ�, �޼��忡 �����ϴ� ���
			// 1. ��ü ���� -> ��ü.��� [ static �ɹ��� �ƴ� ��! ] 
				// ��ü�� ������ �� new �����ڸ� ���� ��ü (�� ��� ����) �޸� �Ҵ�
		Calculater calculater = new Calculater();
		
		System.out.println("��ü�� �̿��� ��� ���� : "+calculater.pi);
		
			// 2. Ŭ������.�ɹ� [ static ����϶�! ]
				// Ŭ���� �ε� �� �޼��� ������ static���� �޸� �Ҵ�
		System.out.println("��ü ���� ��� ���� : "+Calculater.pi);
		
		// * new �����ڷ� �޸𸮿� �Ҵ� ��Ű��, static���� �׻� ���� ��Ű�� �˸°� ����.
		//---------------------------------------------------------------
		
		double result1 = 10 * 10 * Calculater.pi;
		int result2 = Calculater.plus(10, 5);
		int result3 = Calculater.minus(10, 5);
		
		System.out.println("result1 : "+result1);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
		
		
	}	// m e
}	// c e
