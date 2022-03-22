package 시험연습3;

import java.util.ArrayList;

public class Control {
	
	// 리스트의 이상적인 위치는 컨트롤부.
	public static ArrayList<Car> carList = new ArrayList<>();
	
	
	// 입차 메서드
	public static boolean 입차(String 차량번호) {	//리턴값은 주차 성공 여부
		// 입차 코드 작성
			// 1. 입력받은 차량번호(인수)를 가져온다.
		// 중복체크 함 해봐
			// 2. 입차날짜를 구한다.
			// 3. 입차시간을 구한다.
			// *** 출차시간, 금액은 여기서 연산 ㄴㄴ
			// 4. 차량번호, 입차날짜, 입차시간 => 3개변수 -> 1객체화
			// 5. 차량객체를 배열이나 리스트에 저장.
			// 6. 파일처리 || DB처리
		
		return false;
	}
	// 출차 메서드
	public static boolean 출차(String 차량번호) {
		// 출차 코드 작성
			// 1. 입력받은 차량번호(인수)를 가져온다.
			// 2. 배열 || 리스트 내 동일한 차량번호 찾는다.
			// 3. 출차시간(=현재시간)을 구한다.
			// 4. 입차시간 - 출차시간 계산 (API 사용시 .until)(주차한 분-30분무료)/10분*1000원
			// 5. 찾은 차량번호의 인덱스의 출차시간과 금액을 대입.
		return false;
			
	}
	
	
}
