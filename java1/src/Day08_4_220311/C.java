package Day08_4_220311;

import Day08_3_220311.A;

public class C {
	// P. 262
	// AŬ������ ��Ű�� �ٸ�. Ŭ������ �ٸ�.
		// public�� ��� ����.
	
	A a1 = new A(true);
	
	public void c() {
		A a = new A(true);
		a.field1 = 123;
//		a.field2 = 3412;	// default�� �Ұ�.
//		a.field3 = 123;		// private�� ȣ�� �Ұ���!!
		
		a.method1();
//		a.method2();		// default �Ұ�!
//		a.method3();		// private �Ұ���!
		
	}
	
}
