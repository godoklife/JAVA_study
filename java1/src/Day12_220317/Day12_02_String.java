package Day12_220317;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Day12_02_String {
	public static void main(String[] args) throws IOException {
		
		// P. 499 String 메서드
		// charAt() : 문자열에서 특정 문자 추출
		String ssn = "930101-1212121";
		char sex = ssn.charAt(7);
		
		switch(sex) {	// switch 제어문 [switch(검사대상) { }
		case'1': // 1번에 아무것도 없으니 3번이 실행.
		case'3': System.out.println("남자"); break;
		case'2': // 2번에 아무것도 없으니 4번이 실행.
		case'4': System.out.println("여자"); break;	// 여기는 마지막이니까 break 선택
		}
		
		// P.501 equals() : 문자열 비교
			// 기본자료형을 사용하는 변수는 연산자 사용 가능
			// String 클래스 사용하는 객체는 == 연산자 사용 불가 [ 대신 .equals(문자열) 사용 ]
		
		String strVar1 = new String("이름이다아아");
		String strVar2 = ("이름이다아아");
			// String 클래스만!!! new 연산자 없이 객체 선언 가능. 오직 String 클래스만.
		
		if(strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}
		
		
		// P. 502 .getBytes() : 문자열 -> 바이트열로 변환
		String str = "안녕하세요";
		
		byte[] bytes1 = str.getBytes();	// 문자열 -> 바이트열로 변환
		System.out.println(bytes1.length);
		
		String str1 = new String(bytes1);	// 바이트열 -> 문자열로 변환
		System.out.println(str1);
		
		// 인코딩방식 때문에 일반예외 발생.
		byte[] bytes2 = str.getBytes("EUC-KR");	
		System.out.println("EUC-KR 길이 : "+ bytes2.length);
		
		String str2 = new String(bytes2, "EUC-KR");
		System.out.println("바이트열 -> 문자열 : "+str2);
		
		byte[] bytes3 = str.getBytes("UTF-8");	// 인코딩방식 때문에 일반예외 발생.
		System.out.println("UTF-8 길이 : "+ bytes3.length);
		
		String str3 = new String(bytes3, "UTF-8");
		System.out.println("바이트열 -> 문자열 : "+str3);
		
		
		
		// P. 504 indexOf() : 문자 위치 [ 인덱스 ] 찾기
		String subject = "자바 프로그래밍";
		// 문자열 내 특정문자열 위치[인덱스] 찾기
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);	// 3번 인덱스에서 프로그래밍 찾기 성공
		
		// 문자열내 특정 문자열 위치 [ 인덱스 ] 찾기 / 만약에 없으면 -1 [없다]
		System.out.println(subject.indexOf(" "));
		if(subject.indexOf("자바") != -1) {	// 인덱스는 0번 시작 [ -1 인덱스가 없다 ]
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련 없는 책");
		}
		System.out.println("==============================");
		
		// P. 505 length() : 문자열 길이
		String ssn2 = "123213214523";
		int length = ssn2.length();
		if(length == 13) {
			System.out.println("민번 자리수가 맞습니다.");
		} else {
			System.out.println("민번 자리수가 일치하지 않습니다.");
		}
		
		
	}
}
