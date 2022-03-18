package Day13_220318;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Day13_02 {
	public static void main(String[] args) {
		
		// P.539
			// Date 클래스 : 시스템 날짜 / 시간 읽을수 있도록 제공.
				// java.util 클래스 임포트 해줘야함. java.sql 말고!!!!
		
		Date date = new Date();	// date 객체 생성
		System.out.println("현재 날짜와 시간 : "+ date);
		System.out.println("객체 정보 메서드 : "+date.toString());
		
			// SimpleDateFormat 클래스 : 날짜 / 시간 포맷 변환
		SimpleDateFormat asd = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		// 날짜에 형식 적용하기.
		System.out.println("날짜 형식 변경 후 : "+asd.format(date));
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

		// P.540 
			// Calendar 클래스 : 운영체제 시간대의 날짜, 시간에 대한 정보
		Calendar now = Calendar.getInstance();	// Calendar클래스는 객체 별도로 선언 ㄴㄴ. 이미 선언되어있음.
		System.out.println(now.get(Calendar.YEAR));
		
		
		// Calendar 클래스를 통해 얻은 요일(숫자)-> 한글 변환 
		int week = now.get(Calendar.DAY_OF_WEEK);	// 1: 일요일, 2: 월요일... 7:토요일.
		String 요일 = null;
		switch(week){
			case 2: 요일="월요일"; break;
			case 3: 요일="화요일"; break;
			case 4: 요일="수요일"; break;
			case 5: 요일="목요일"; break;
			case 6: 요일="금요일"; break;
			case 7: 요일="토요일"; break;
			case 1: 요일="일요일";
		}
		
		System.out.println(요일);
		
		
		// 오전 오후 표현
		
		System.out.println("오전 / 오후, 0: 오전 | 1: 오후 출력값 : "+now.get(Calendar.AM_PM));	// 0 : 오전, 1 : 오후
		String 오전오후 = null;
		switch(now.get(Calendar.AM_PM)) {
		case 0: 오전오후="오전";	break;
		case 1: 오전오후="오후";
		}
		
		System.out.println("오전오후 변환 후 출력 : "+오전오후);
		
		
		System.out.println("시 : "+now.get(Calendar.HOUR));
		System.out.println("분 : "+now.get(Calendar.MINUTE));
		System.out.println("초 : "+now.get(Calendar.SECOND));
		
		// ZonedDateTime 클래스 : 세계 협정시계
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
		System.out.println("협정시 : "+zonedDateTime);
		zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println("아시아/서울 : "+zonedDateTime);
		
		
		
		
		
		
	}	// main END
}	// class END
