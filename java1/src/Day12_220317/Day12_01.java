package Day12_220317;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Day12_01 {
	public static void main(String[] args) throws IOException {
		
		// P.496 String 클래스
	byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};	
	
	String str1 = new String(bytes);	
	// 자바는 기본적으로 아스키코드 사용. 따라서 bytes의 내용을 아스키 코드로 해석함.
	System.out.println(str1);
	
	String str2 = new String(bytes, 6, 4);	// 6번 인덱스(74)부터 4개를 집어넣는다.
	System.out.println(str2);
	
	// P.498 예제2
		// System.out : 시스템 클래스 내 출력 필드
		// System.in : 시스템 클래스 내 입력 필드
	
	byte[] bytes2 = new byte[100];
	
	System.out.println("입력 : ");
	int readByteno = System.in.read(bytes2);
		// 외부통신 : 자바프로그램 외 [ 키보드, 네트웤 등등 ] 입출력 일반예외 발생!!
	System.out.println("입력받은 바이트 : "+Arrays.toString(bytes2));
	// 소문자 a 입력하고 엔터 누르면 배열에 97, 13, 10 저장.
		// 97 : a
		// 13 : 줄바꿈
		// 10 : 개행(맨 앞으로)
	
	
	String str = new String(bytes2);
		//  readByteno-2 : 엔터를 누름으로써 생기는 줄바꿈과 개행을 빼고 읽어들임.
	System.out.println("입력받은 바이트 -> 문자열 변환 : "+str);
	
	Scanner scanner = new Scanner(System.in);
	scanner.next();			// 바이트->문자열 변환
	scanner.nextInt();		// 바이트->정수열 변환
	scanner.nextDouble();	// 바이트->실수형 변환
	
	
	}
}
