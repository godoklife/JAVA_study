package Day19_220328;

import java.util.HashSet;

public class Day19_01 {
	public static void main(String[] args) {
		
		
		// P.737
		// 1. Hashset 클래스로 객체 선언
		HashSet<String> set = new HashSet<>();
								// 형태(제네릭)을 뒷쪽에 넣어줘도 안넣어줘도 되지만 같은걸로 넣어줘야함.
		// HashSet<String> set = new HashSet<int>();	이거는 안된다는 얘기
		// 1) HashSet : 컬랙슨 프레임워크 클래스
			// 2) <제네릭> : Set클래스 안에 들어가는 자료형
				// 3) set : 객체명 
					// 4) new : 객체 생성시 메모리 할당 생성자
						// 5) HashSet<제네릭(생략가능)>() : 생성자
		// 2. set 객체 내 객체 넣기 [ set객체명.add(객체명) ]
		set.add("java");	System.out.println("확인 : "+ set);
		set.add("test");	System.out.println("확인 : "+ set);
		set.add("자바아아아아");	System.out.println("확인 : "+ set);
		
		// 3. set객체내 객체 수
		System.out.println();
		
		
	}
}
