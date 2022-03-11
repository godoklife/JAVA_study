package Day08_3_220311;

public class B {	
// A와 패키지는 같지만 class가 다름.
	// public, default 사용 가능
	// private는 클래스가 다른 경우 호출 불가.
	
	// 1. 필드
		A a1 = new A(true);		// 다른 클래스에서 public A(Boolean B) {} 호출
		A a2 = new A(1);		// 다른 클래스에서 default 호출
//		A a3 = new A("문자열");	// 다른 클래스에서 private A (String s) {} 호출 불가
	
		public B() {
			A a = new A(true);
			a.field1 = 123;
			a.field2 = 3412;
//			a.field3 = 123;		// private는 호출 불가능!!
			
			a.method1();
			a.method2();
//			a.method3();		// private 불가능!
			
		}
		
		
		
		
		
		// 2. 생성자
		
			
		// 3. 메서드
}
