package Day10;

public class Child extends Parent{
	
	private String name;
	
	public Child() {
		this("ȫ�浿");	// �� Ŭ���� �� ������ ȣ�� -> public Child(String name) ȣ���.
		System.out.println("Child() call");
	}
	
	public Child(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}
}
