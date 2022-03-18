package Day13_220318;

import java.util.Calendar;

public class Day13_03 {
	public static void main(String[] args) {
		
		// 1. 캘린더 클래스 내 현재 날짜, 시간 객체 호출
		Calendar calendar = Calendar.getInstance();	// 이미 객체가 선언된 API임. new연산자 필요 ㄴㄴ
		// 2. 연도, 월, 일
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;	// 1월이면 0을 반환하기 때문에 +1을 해주는것!!!
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		// * 해당 월의 1날의 요일 찾기?
			// 1. 사용자 정의 캘린더 설정.
		calendar.set(year, month-1, 1);	// ex. 3월 1일
		System.out.println("사용자가 날짜 만들기 : "+calendar.toString());
			// 2. 3월 1일의 요일
		int sweek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(sweek);
			// 3. 3월의 마지막 일
		
	
		
		
		System.out.println("====================== "+year+"년 "+month+"월 ======================");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
	}	// main END
}	// class END
