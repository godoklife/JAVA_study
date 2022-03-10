package Day07_220310;

import java.util.Scanner;

public class Day07_02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가스 값을 입력해보시오.");
		// 1. 객체 선언 [ 빈 생성자 = 기본 생성자 ]
		Car myCar = new Car();
		// 2. 메서드 호출 [ 인수 1개 ]
		myCar.setGas(scanner.nextInt());	// myCar.gas = 5; 이랑 결과는 같으나 캡슐화를 통한 정보의 은닉을 위함. 직접적으로 데이터 넣는 일은 매우 드믊.
		
		if(myCar.isLeftGas()) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		}
		else
			System.out.println("개스를 충전하세요.");
		
		
	}
}
