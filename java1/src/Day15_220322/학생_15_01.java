package Day15_220322;

public class 학생_15_01 extends 사람_15_01{
			// 자식클래스	상속		수퍼클래스
	// 필드
	String 이름 = "학생";
	// 이름이 들어가있음.
	
	public 학생_15_01() {}
	
	
	
	public 학생_15_01(String 이름) {
		super(이름);
	}



	// 메서드
	public void 이름호출() {
		System.out.println("super.이름 : "+super.이름);
		System.out.println("this.이름 : "+this.이름);
		System.out.println("이름 : "+이름);
	}
	
}
