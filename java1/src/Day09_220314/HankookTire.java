package Day09_220314;

public class HankookTire extends Tire {
			// 서브클래스 	extends	수퍼클래스
	// 1. 필드
	
	// 2. 생성자
	public HankookTire(String location, int maxRotation)
	{
		super(location, maxRotation);
		// super(인수1, 인수2)	// 슈퍼클래스 내 [인수2개] 생성자 호출
	}
	
	// 3. 메서드
	@Override	// 슈퍼클래스 내 메서드를 재정의 [ 수정 ] 
	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation<maxRotation) {
			System.out.println(maxRotation + "한국타이어 수명 : " + (maxRotation - accumulatedRotation) + "회 남았습니다.");
			return true;
		}
		else {
			System.out.println("***"+location+"한국타이어 펑크 ***");
			return false;
		}
	}	// roll END
}	// class END
