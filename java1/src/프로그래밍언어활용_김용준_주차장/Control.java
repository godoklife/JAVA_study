package 프로그래밍언어활용_김용준_주차장;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Control {
	
	ArrayList<Parking> parkingList = new ArrayList<>();
	LocalDate nowDate = LocalDate.now();
	LocalTime nowTime = LocalTime.now();
	
	boolean inCar(String carNum) {	// 입차시 실행되는 메서드
		for(Parking tmp : parkingList) {
			// 1. 차량번호 중복검사
			if(tmp.getCarNum().equals(carNum)) 
				return false;
		}	// f e
		// 2. 차량번호 중복검사 통과시 리스트에 차량번호, 입차일, 입차시간 저장 실행
		Parking parking = new Parking(carNum, nowTime, null, nowDate, 0);
		parkingList.add(parking);
		return true;
	}	// inCar end
	
	int outCar(String carNum) {
		int index = 0;	// parkingList 인덱스 카운트용 변수
		int bill = -1;	
		for (Parking tmp : parkingList) {
			
			// 1. 입력받은 차량번호가 주차장 리스트에 존재하고 출차시간이 null인지[=주차중]인지 확인 후
			if(tmp.getCarNum().equals(carNum) && tmp.getOutTime()==null) {
				bill=0;	// if문에 진입하면 리턴값을 0으로 변경
				int parkedTime = (int)ChronoUnit.MINUTES.between(tmp.getInTime(), nowTime) - 30;

				if(parkedTime < 0) parkedTime=0;

				bill = 1000*(parkedTime/10);	// 10분당 1000원 청구

				Parking parking = new Parking(carNum, tmp.getInTime(), nowTime, tmp.getDate(), bill);	// 객체화 후
				parkingList.set(index, parking);	// 해당 인덱스에 교체
				return bill;	// 정상 처리 완료.
				
			}
			index++;
		}
		return bill;	// outCar메서드가 bill을 리턴할때 초기값인 -1 그대로면 view에서 에러라고 출력.
	}	// f e
}	// c e
