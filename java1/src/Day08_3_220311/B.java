package Day08_3_220311;

public class B {	
// A�� ��Ű���� ������ class�� �ٸ�.
	// public, default ��� ����
	// private�� Ŭ������ �ٸ� ��� ȣ�� �Ұ�.
	
	// 1. �ʵ�
		A a1 = new A(true);		// �ٸ� Ŭ�������� public A(Boolean B) {} ȣ��
		A a2 = new A(1);		// �ٸ� Ŭ�������� default ȣ��
//		A a3 = new A("���ڿ�");	// �ٸ� Ŭ�������� private A (String s) {} ȣ�� �Ұ�
	
		public B() {
			A a = new A(true);
			a.field1 = 123;
			a.field2 = 3412;
//			a.field3 = 123;		// private�� ȣ�� �Ұ���!!
			
			a.method1();
			a.method2();
//			a.method3();		// private �Ұ���!
			
		}
		
		
		
		
		
		// 2. ������
		
			
		// 3. �޼���
}
