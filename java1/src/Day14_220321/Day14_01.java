package Day14_220321;

public class Day14_01 {
	public static void main(String[] args) {
	
		
		// 객체화
			// 1. 클래스의 객체 생성
		member member2 = new member();
		member member3 = new member();
			// 2. 객체의 필드에 사용
				// 맴버2와 맴버3는 필드를 공유하지 않는다!!
		member2.name = "김용준";
		member2.id = "godoklife";
		member2.password = "asd";
		member2.point = 100;
		
		member3.name = "유재석";
		member3.id = "우왕";
		member3.password = "ㅁㅁ";
		member3.point = 22;
		
		
	}
}
