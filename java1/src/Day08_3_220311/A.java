package Day08_3_220311;

public class A {	// ������ Ŭ���� �������� ���������� �ǹ� X
					// �ٸ� Ŭ����, ��Ű������ ���������ڰ� ����.
//������ Ŭ�������� A

	// 1. �ʵ�
	A a1 = new A(true);		// �� Ŭ�������� public A(Boolean B) {} ȣ��
	A a2 = new A(1);		// �� Ŭ�������� default ȣ��
	A a3 = new A("���ڿ�");	// ���� Ŭ�������� private A (String s) {} ȣ�� ����
	
	
	public int field1;
	int field2;
	private int field3;
	
	
	// 2. ������
	public A (Boolean b) {
		field1 = 1;
		field2 = 123;
		field3 = 11;
		
		method1();
		method2();
		method3();
		
	}	// �� ����	(default)
	A (int b) {}			// �� ��Ű�� ��
	private A (String s) {}	// �� Ŭ���� ��
		
	// 3. �޼���
	public void method1() {}
	void method2() {}
	private void method3() {}
	
	
}
