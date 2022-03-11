package Day08_4_220311;

import Day08_3_220311.A;

public class C {
	// P. 262
	// A클래스와 패키지 다름. 클래스도 다름.
		// public만 사용 가능.
	
	A a1 = new A(true);
	
	public void c() {
		A a = new A(true);
		a.field1 = 123;
//		a.field2 = 3412;	// default도 불가.
//		a.field3 = 123;		// private는 호출 불가능!!
		
		a.method1();
//		a.method2();		// default 불가!
//		a.method3();		// private 불가능!
		
	}
	
}
