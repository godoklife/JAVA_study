package Day15_220322;

public class 사람_15_01 extends 직업_15_01{
	// 필드
	String 이름 = "사람";
	
	public 사람_15_01() {
		
	}

	public 사람_15_01(String 이름) {
		this.이름 = 이름;
	}
	
	public void 이름호출() {
		System.out.println("사람 이름 호출 : "+this.이름);
	}
	
}
