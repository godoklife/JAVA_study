package Day17_220324_결석2;

public class 사람<T> {
	// T = 내가 임의로 지정한 제네릭... 이나 일반적으로 T = Type으로 씀
	
	// 1. 필드
	private String name;
	private int age;
	
	// 2. 생성자
	public 사람() {
		// TODO Auto-generated constructor stub
	}
	public 사람(String name) {
		this.name = name;
	}
	
	
	// 3. 메서드(게터, 세터)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}	// c e