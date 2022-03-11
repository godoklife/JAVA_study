package Day08_220311;
// A클래스와 B클래스 패키지가 다름.

import Day08_2_220311.B;

public class C {
	
//	A a;	// A클래스는 default라서 다른 패키지에서 호출 불가.
	
	B b;	// B클래스는 public이라 다른 패키지에서 호출 가능.
	
}
