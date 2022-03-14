package Day09_220314;
//Day09_05
public class Tire {	// 클래스 선언
	
	
	// 1. 필드
	public int maxRotation;			// 최대 회전수 ( 타이어 수명 )
	public int accumulatedRotation;	// 누적 회전수
	public String location;			// 타이어의 위치	
	
	// 2. 생성자 [ 객체 생성시 초기값 ]
	public Tire(String location, int maxRotation) {
					// 타이어 초기값, 최대 회전수
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	// 3. 메서드
	public boolean roll() {	// 타이어가 회전하는걸 구현한 메서드
		++accumulatedRotation;	// 누적 회전수 1 증가
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+"tire수명 : " + (maxRotation - accumulatedRotation)+"회 남았습니다.");
			return true;
		}
		else {
			System.out.println("***"+location+"Tire 펑크 ***");
			return false;
		}
	}	// roll END
}	// class END
