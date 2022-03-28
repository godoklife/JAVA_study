package Day19_220328;

import java.util.HashMap;

public class Day19_03 {
	public static void main(String[] args) {
		// P.740
		// 1. Map 컬랙션 = Json
			// * 키(객체), 값(객체) = 엔트리 라고 부름.
			// 키 : set 컬랙션 사용(중복 불가능)
			// 값 : list 컬랙션 사용(중복 가능)
			// HashMap 클래스 
				// 1. map객체명.put( key객체, value객체) : 엔트리 (키=값) 추가
				// 2. map객체명.size() : 엔트리 개수 반환
				// 3. map객체명.get(key객체) : 해당 키의 value 호출
				// 4. map객체명.keySet() : map 객체나 모든 키 호출
				// 5. map객체명.values() : map 객체 내 모든 값 호출
					// * key를 알고 있으면 값을 알 수 있다.
					// for(제네릭 임시객체명 : map) { 실행문 }
//		예시)			for(String tmp : map.keySet()) {
//						System.out.println(tmp + " : " + map.get(tmp));
//							// HashMap객체명.get(Key값) -> 해당 value 반환
//					}
				// 6. map객체명.remove(키객제) : 해당 key포함 key와 연결된 value 삭제.
				// 7. map객체명.clear() : 해당 map객체 모든 엔트리 초기화.
		
			// * List 컬랙션 : 순서별(인덱스) 저장 = 배열과 유사
			// * Set 컬랙션 : 순서 없는 저장 : 증축 불가능
			// * Map 컬랙션 : Key(Set형태)와 Value(List형태)로 이루어진 엔트리를 여러개 저장
		
		// P.743 예제
		// 1. HashMap Class의 객체 선언
		HashMap<String, Integer> map = new HashMap<>();
			// K = key, V = value
// HashMap : 컬랙선 프레임워크 map 클래스
	// < 제네릭, 제네릭 > : K = key, V = value 로 구성    <- 핵심 키워드
		// map : 객체 이름.
			// new : 객체 생성시 메모리 할당 연산자
				// HashMap<>() : 생성자
		
		// 2. map 객체에 추가
		map.put("강호동", 30);
		System.out.println("확인 : "+map);
			// 리스트 = 출력시 대괄호 [ 객체, 객체, 객체 ] 
			// 셋트 = 출력시 대괄호 [ 객체, 객체, 객체 ] 
			// 맵 = 출력시 중괄호 { 키 = 값 }
		map.put("유재석", 40); System.out.println("확인 : "+map);
		map.put("이명박", 50); System.out.println("확인 : "+map);
		map.put("유재석", 40); System.out.println("확인 : "+map);
		map.put("유재석", 40); System.out.println("확인 : "+map);
		map.put("유재석", 45); System.out.println("확인 : "+map);	// 유재석의 value가 다르더라도 key는 중복기 안되기에 기존 유재석에 45가 덮어씌워짐.
		
		// 3. map의 사이즈 호출
		System.out.println("map 객체 내 엔트리 수 : "+ map.size());
		
		// 4. key 호출을 통한 value의 반환
		System.out.println("map 객체 내 값 호출 (key 호출시 ->value 반환) : "+map.get("유재석"));
		
		// 5. 모든 key 호출
		System.out.println("map 객체 내 모든 key 호출  : "+map.keySet());	// 세트의 형태로 반환
		
		// 6. 모든 value 호출
		System.out.println("map 객체 내 모든 value 호출 : "+map.values());	// 리스트의 형태로 반환	
		
		// 7. 반복문 활용 [ key 반복문 이용해서 모든 value 호출 가능 ]
		for(String tmp : map.keySet()) {
			System.out.println(tmp + " : " + map.get(tmp));
				// HashMap객체명.get(Key값) -> 해당 value 반환
		}
		
		// 8. 삭제
		map.remove("이명박");
		System.out.println("확인 : "+map);
		
		// 9. 싹 다 삭제
		map.clear();
		System.out.println("확인 : "+map);
		
	}
}
