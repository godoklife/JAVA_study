package Day09_220314;
//Day09_05
public class KumhoTire extends Tire{
			// 서브클래스	extends	슈퍼클래스
	
	// 1. 필드
	
	// 2. 생성자
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
			// 수퍼클래스 내 생성자 호출 ( = 복붙)
	}
	// 3. 메서드
	@Override	// 슈퍼클래스 내 메서드를 재정의 [ 수정 ] 
	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation<maxRotation) {
			System.out.println(maxRotation + "금호타이어 수명 : " + (maxRotation - accumulatedRotation) + "회 남았습니다.");
			return true;
		}
		else {
			System.out.println("***"+location+"금호타이어 펑크 ***");
			return false;
		}
	}	// roll END
}