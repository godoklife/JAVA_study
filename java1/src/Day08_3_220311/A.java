package Day08_3_220311;

public class A {	// 동일한 클래스 내에서는 접근제한자 의미 X
					// 다른 클래스, 패키지에서 접근제한자가 역할.
//전번위 클래스선언 A

	// 1. 필드
	A a1 = new A(true);		// 현 클래스에서 public A(Boolean B) {} 호출
	A a2 = new A(1);		// 현 클래스에서 default 호출
	A a3 = new A("문자열");	// 같은 클래스에서 private A (String s) {} 호출 가능
	
	
	public int field1;
	int field2;
	private int field3;
	
	
	// 2. 생성자
	public A (Boolean b) {
		field1 = 1;
		field2 = 123;
		field3 = 11;
		
		method1();
		method2();
		method3();
		
	}	// 전 범위	(default)
	A (int b) {}			// 현 패키지 내
	private A (String s) {}	// 현 클래스 내
		
	// 3. 메서드
	public void method1() {}
	void method2() {}
	private void method3() {}
	
	
}
