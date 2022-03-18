package Day13_220318;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Day13_04_DemicalFormat {
	public static void main(String[] args) throws Exception {
		
		// P. 544 DecimalFormat 클래스
		
		double num = 1234567.89;
		
		System.out.println("초기값 : 1234567.89");
		DecimalFormat df = new DecimalFormat("");
		System.out.println("DecimalFormat("+") : "+df.format(num));
		
		df = new DecimalFormat("0");
		System.out.println("DecimalFormat(0"+") : "+df.format(num));
		
		df = new DecimalFormat("0.0");
		System.out.println("DecimalFormat(0"+") : "+df.format(num));
		
		df = new DecimalFormat("#");
		System.out.println("DecimalFormat(#"+") : "+df.format(num));
		
		df = new DecimalFormat("#.#");
		System.out.println("DecimalFormat(#.#"+") : "+df.format(num));
		
		df = new DecimalFormat("0000000000.00000");
		System.out.println("DecimalFormat(0000000000.00000"+") : "+df.format(num));
		
		df = new DecimalFormat("###########.#####");
		System.out.println("DecimalFormat(##########.#####"+") : "+df.format(num));
		
		df = new DecimalFormat("#.0");
		System.out.println("DecimalFormat(#.0"+") : "+df.format(num));
		
		//****************자주 쓰는 형식, 천단위 구분 쉼표
		df = new DecimalFormat("#,##0원");
		System.out.println("DecimalFormat(#,##0원"+") : "+df.format(num));
		
		df = new DecimalFormat("#,###원");
		System.out.println("DecimalFormat(0"+") : "+df.format(0));	// 0 원 출력
		
		df = new DecimalFormat("0,000원");
		System.out.println("DecimalFormat(0"+") : "+df.format(0));	// 0,000 원 출력
		
		df = new DecimalFormat("0.0E0");
		System.out.println("DecimalFormat(0.0E0"+") : "+df.format(num));	// E : 지수문자
		
		df = new DecimalFormat("[양]+#,### ; [음]-#,###");
		System.out.println("DecimalFormat([양]+#,### ; [음]-#,###"+") : "+df.format(num));	// 세미콜론을 기준으로 양, 음수 구분 후 사용함.
		
		df = new DecimalFormat("#,###%");
		System.out.println("DecimalFormat(#,###%"+") : "+df.format(num));
		
		df = new DecimalFormat("\u00A4 #,###");
		System.out.println("DecimalFormat(\u00A4"+") : "+df.format(num));
		
		System.out.println("====================================================");
		
		// P. 547 MessageFormat 클래스 : 문자 형식 변환
		
		String id = "java";
		String name= "신용권";
		String tel = "010-123-5678";
		String text = "회원 ID : {0} \n회원 이름 : {1} \n회원 전화 : {2}";
		String result1 = MessageFormat.format(text, id, name, tel);
		System.out.println(result1);

		String sql = "insert info member values( {0}, {1}, {2} )";
		Object[] test = {id, name, tel};
		String result2 = MessageFormat.format(sql, test);
		System.out.println(result2);
		
		
		System.out.println("====================================================");

		
		// JAVA 7 버전 이전 : Date, 이후에는 여러가지 API 추가중임!!
		LocalDate currDate = LocalDate.now();	// new 사용 X static 메서드임.
		System.out.println("현제 날짜 : "+currDate);
		
		LocalTime currTime = LocalTime.now();
		System.out.println("현재 시간 : "+currTime);
		
		// Date 현재 날짜 / 시간 [ 조작이 안되거나 비교기능이 불충분하다! ]
		// VS
		// LocalDate : 현재 날짜	LocalTime : 현재 시간	LocalDateTime : 현재 날짜 시간
		
		LocalDateTime currdatetime = LocalDateTime.now();
		System.out.println("현재날짜 / 시간 : "+currdatetime);
		
		// **** 비교대상간의 시간차 계산
		Instant instant1 = Instant.now();
		
		Thread.sleep(1000);	// 1초 대기 [ 코드 흐름을 1초동안 일시 정지시김 ] -> 일반예외 발생
		Instant instant2 = Instant.now();
		
		if(instant1.isBefore(instant2)) {
			System.out.println("instant1이 더 빠름.");
		}else if(instant1.isAfter(instant2)) {
			System.out.println("instant2가 더 빠름.");
		}
		
		System.out.println("차이(ns) : "+instant1.until(instant2, ChronoUnit.NANOS));
		
	}
}
