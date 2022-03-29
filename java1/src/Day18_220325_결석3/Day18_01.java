package Day18_220325_결석3;

import java.util.ArrayList;

public class Day18_01 {
	
	// P.722 컬랙션 프레임워크
		// 개인 노션 18일차에 정리했습니다.
	public static void main(String[] args) {
		
		// 1. 리스트 클래스로 객체 선언 [ 리스트 안에 저장할 항목의 자료형 -> 제네릭 ] 
		ArrayList<String> list = new ArrayList<String>();
			// 1. ArrayList : 리스트 클래스
				// 2. <제네릭> : 리스트 클래스 내부에 들어가는 자료형 지정
					// 3. list : 리스트 객체 이름 -> 내맘대로
						// 4. new ArrayList<제네릭,생략가능>(길이,생략가능,기본값 10) 
		// 2. 리스트 객체명.add ( 객체명 = 제네릭타입 ) : 리스트 객체 내 요소 추가
		list.add("java"); // 자동으로 인덱스 0에 저장됨
		list.add("jdbc"); // 인덱스 1에 저장
		list.add("servlet/jsp");	// 인덱스 : 2
		System.out.println("리스트 내 요소들 확인 : "+ list);	
			// 무식하게 메모리주소가 나오지 않고 "[java, jdbc, servlet/jsp]" 출력됨.
		list.add(2, "Database");	// 2번 인덱스에 요소 저장. 서블릿은 자동으로 3번인덱스로 변경.
		System.out.println("리스트 내 요소들 확인 : "+ list);	
			// 설명 생략
		list.add("iBATIS");	// 4번 인덱스에 저장됨.
		
		// 3. 리스트객체명.size() : 리스트객체 내 요소들의 개수 [ 길이, =인덱스+1 ]
		System.out.println("list.size() : "+list.size());
		
		// 4. 리스트객체명.get(인덱스) : 해당 인덱스의 요소 호출
		System.out.println("list.get(2) : "+list.get(2));
		
		// 5-1. 반복문 활용
		for(int i=0; i<list.size(); i++) {	// 0부터 해당 리스트 객체의 길이-1까지 i가 1씩 증가하며 반복
			String tmp = list.get(i);	// i번 인덱스의 요소를 tmp문자열에 대입
			System.out.println(i + " : " +tmp);	// 출력
		}
		
		// 5-2. 반복문 활용
		int indexCount = 0;
		for(String tmp : list) {
			System.out.println(indexCount+" : "+tmp);
			indexCount++;
		}
		
		// 6. 리스트객체명.remove(인덱스 또는 객체)
		list.add("java");	// java는 0번, 5번 인덱스에 위치함.
		System.out.println("삭제 전 리스트 출력 : "+list);
		list.remove(2);
		System.out.println("2번 인덱스 삭제 후 확인 : "+list);
		list.remove(2);
		System.out.println("2번 인덱스 또 삭제 후 확인 : "+list);
		list.remove("java");
		System.out.println("java 객체 삭제 후 확인"+list);	
		// 중복값이 있을 경우 앞에거 하나만 지우는걸 알 수 있다.
		list.clear();
		System.out.println("리스트 싹 다 날리는 .clear() : "+list);
	}
}
