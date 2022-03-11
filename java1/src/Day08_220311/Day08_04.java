package Day08_220311;

public class Day08_04 {	// c s
	public static void main(String[] args) {	// m s
		
		// P. 267~ 268 : Setter, Getter 메서드
			// 필드는 private로 사용되는 경우가 매우매우많다
			// 외부에서 필드에 접근할수 없다.
			// why?? 외부에서 필드에 직접접근을 제한하고 메서드를 통한 필드 접근만을 허용.
			// Setter 메서드 : 필드 데이터 변경
			// Getter 메서드 : 필드 데이터 호출
		
		// 1. 객체 생성
		Car myCar = new Car();
		// 2. 객체 내 메서드 호출
		myCar.setSpeed(-50);	// 잘못된 값 입력
		// 3. 확인
		System.out.println("현재 속도 : "+ myCar.getSpeed());
		// 4. 정상값 입력
		myCar.setSpeed(100);
		// 5. 확인
		System.out.println("현재 속도 : "+ myCar.getSpeed());
		// 6. 
		if(!myCar.isStop()) {	// 정지 상태가 !아니면
			myCar.setStop(true);// 장비를 정지합니다.
			System.out.println("정지했습니다.");
		}
		
		
		System.out.println("현재 속도 : "+myCar.getSpeed());
		
	}	// m e
}	// c e
