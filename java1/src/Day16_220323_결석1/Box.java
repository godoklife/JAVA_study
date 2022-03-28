package Day16_220323_결석1;

public class Box {
	// 1. 필드
	private Object object;	// super class [ 최상위 클래스 ]
	// 2. 생성자
	// 안 만들면 컴파일러가 알아서 기본생성자 만듦
	
	// 3. 메서드
	public void set(Object object) {
		System.out.println("test");
		this.object = object;
	}
	
	public Object get() {
		return this.object;
	}
}
