package Day13_220318;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_03_Calendar_Scanner {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 1. 캘린더 클래스 내 현재 날짜, 시간 객체 호출
		
		// 2. 연도, 월, 일
		System.out.println("연도 입력 ");
		int year = scanner.nextInt();
		System.out.println("달 입력");
		int month = scanner.nextInt();	// 1월이면 0을 반환하기 때문에 +1을 해주는것!!!

		달력(year, month);
	}	// main END
	
	public static void 달력(int year, int month) {
		
		Calendar calendar = Calendar.getInstance();	// 이미 객체가 선언된 API임. new연산자 필요 ㄴㄴ
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		// * 해당 월의 1날의 요일 찾기?
			// 1. 사용자 정의 캘린더 설정.
		calendar.set(year, month-1, 1);	// calendar 객체를 2022년 3월 1일로 설정.
			// 2. 3월 1일의 요일
		int sweek = calendar.get(Calendar.DAY_OF_WEEK);
			// 3. 3월의 마지막 일
		int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		// 3. 출력
		System.out.println("====================== "+year+"년 "+month+"월 ======================");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		// * 현재 월 1일의 위치 앞에 공백 채우기
		for(int i=1; i<sweek; i++) {
			System.out.printf("\t");
		}
		
		// 1일부터 마지막날짜 까지 출력.
		for(int i = 1; i<=eday; i++) {
			System.out.print(i+"\t");
			// 토요일마다 줄바꿈 처리
			if(sweek%7==0) 
				System.out.println("");
			
			sweek++;
		}
	}
	
}	// class END
