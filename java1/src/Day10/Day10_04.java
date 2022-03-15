package Day10;

import java.util.ArrayList;

public class Day10_04 {
	
	// 문법
	// 1. 입출력	2. 변수 3. 연산자 4. 제어문/반복문 5. 배열 | 6. 클래스 7. 인터페이스
		// 클래스, 인터페이스는 객체지향에 있음.
	public static void main(String[] args) {
		
		// 배열	vs 리스트
		// 배열[인덱스 0부터 차례대로 저장]
		String[] 배열이름 = new String[100];
		System.out.println("배열 : "+배열이름);
		배열이름[0] = "유재석";	
		System.out.println("배열[0] : "+배열이름[0]);
		
		// 리스트[ 클래스 기반의 배열구조 ]
		ArrayList<String> 리스트이름 = new ArrayList<>();
		// ArrayList<자료형> 이름 = new ArrayList<>();
			// <자료형> : 자료형
			// 리스트명 : 리스트 이름 아무거나
			// new : 메모리 할당
			// ArrayList<>(); : 생성자
		리스트이름.add("김용준");
		리스트이름.add("김용준");
		리스트이름.add("김용준");
		System.out.println("리스트 : "+리스트이름);
		리스트이름.add("유재석");	// 인덱스번호 몰라도 추가 가능.
		System.out.println("리스트[0] : "+리스트이름.get(0));
			// 리스트명.get(인덱스) : 해당 인덱스의 객체 호출 메서드
		System.out.println("리스트 길이(사이즈) : "+리스트이름.size());
			// 리스트명.size() : 해당 리스트의 길이 호출 메서드
	}
}
