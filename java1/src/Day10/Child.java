package Day10;

public class Child extends Parent{
	
	private String name;
	
	public Child() {
		this("홍길동");	// 현 클래스 내 생성자 호출 -> public Child(String name) 호출됨.
		System.out.println("Child() call");
	}
	
	public Child(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}
}
