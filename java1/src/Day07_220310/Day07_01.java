package Day07_220310;

public class Day07_01 {	// c s
	public static void main(String[] args) {	// m s
		//�޼��� ȣ����
			// 1. �޼��尡 �����ϴ� Ŭ������ ��ü�� �ʿ�.
			// 2. ��ü��.�޼����()
				// .(��ħǥ) : ���ٿ�����(�ʵ峪 �޼��带 ȣ��� ���)
				// ex.) scanner.nextInt();
		// 1. ��ü ����
		Calculater myCalc = new Calculater();
		// Ŭ������	��ü��	= �޸� �Ҵ� ������ ();
		
		// 2. �޼����� ȣ��
		myCalc.powerOn();	// Calculater Ŭ������ myCalc ��ü�� powerOn�޼��带 ȣ��
		
		// 3. �޼��� ȣ�� [ �μ� 2��¥�� ]
		myCalc.plus(5,10);	// ���� �غ��� �ƹ��͵� �ȳ���.
		int result1 = myCalc.plus(5,10);
		// Calculater Ŭ������ myCalc��ü�� plus �޼���� �μ� 2���� ���� ������� result1�� ����.
		System.out.println("myCalc.plus(5,10);");
		System.out.println("myCalc.plus�� result1�� ������ �� : " +result1);
		System.out.println("myCalc.plus�� ���� println�� ȣ���� �� : " +myCalc.plus(5,  10));
		
		
		byte x = 10;
		byte y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("myCalc.divided�� result2�� ������ �� : " +result2);
		
		
		myCalc.powerOff();
		
		
	}	// m e
}	// c e
