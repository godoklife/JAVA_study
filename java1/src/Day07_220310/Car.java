package Day07_220310;

public class Car {
	// 클래스 선언
	
	// 1. 필드 ( 데이터가 저장되는 부분 )
	int gas;
	// 2. 생성자
		// 생성자 선언 안하면 컴파일러가 자동으로 기본생성자 생성.
	// 3. 매서드 ( 함수의 연산부)
		// 1. gas를 외부로부터 입력받아서 내부에 저장하는 메서드
	void setGas(int gas) {	// 인수 O, 반환 X
//	리턴 X 메서드명 ( 인수1개 )
		this.gas = gas;
// 내부변수와 외부변수의 이름이 같을 때 구분하는 방법?
		// this.gas = gas  -> 내부 gas = 외부에서 들어온 gas
	}
	
		// 2.
	boolean isLeftGas() {	//인수 X, 반환 O
//  반환값 논리형  메서드명(인수 0개)
		if(gas==0) {
			System.out.println("Not enough gas");
			return false;	// 내부 변수에 깨스가 없으면 false 반환
		}
		else {
			System.out.println("Gas가 있습니다.");
			return true;	// 가스가 있으면 true 반환
		}
	}	// isLeftGas end
	
	// 3. gas가 0일때까지 -1씩 반복 감소연산 실행
		// 0이면 실행 종료
	void run() {	
		while(true) {
			if(gas>0) {
			System.out.println("달립니다. (가스 잔량 : " +this.gas+")");
			this.gas--;
			}
			else {
				System.out.println("|||||||멈춥니다. (가스 잔량 : " +this.gas+")");
				break;	// return;으로 대채 가능
			}
				
		}
	}
	
}
