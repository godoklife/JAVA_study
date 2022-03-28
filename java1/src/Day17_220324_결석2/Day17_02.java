package Day17_220324_결석2;

public class Day17_02 {
	public static void main(String[] args) {
		
		// P.661~662
		
		// 1. box 객체 생성 [ 제네릭 : Integer ]
		Box<Integer> box1 = new Box<>();
		// 2. 메서드 호출 후 결과값을 객체에 대입
		box1 = Util.<Integer>boxing(100);
		// 3. 다시 꺼내서 확인(int형)
		System.out.println("box1.get() : " + box1.get());	// 출력값 : (int)100
		
		// P. 662~ 663
		
		// 1. p1 객체를 선언하는데 생성자에 정수 1과 문자열 사과 넣기
			// 이유?? 제네릭이 Integer, String
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "사과");
		// 2. 새로운 객체 p2 선언
		Pair<Integer, String> p2 = new Pair<>(1, "사과");	// new Pair에서 제네릭 생략가능
		
		// 3. 비교메서드 호출
		boolean result0 = Util.compare(p1, p2);	// ?????????????????
		System.out.println("제네릭 없이 비교한 result0 : "+result0);
		boolean result1 = Util.<Integer,String>compare(p1, p2);
		System.out.println("제네릭을 함유한 result1 : "+result1);
		
		// 4. 결과 정리
		if(result1)	System.out.println("동일한 객체");
		else System.out.println("동일하지 않은 객체");
				
		
		Pair<Integer, String> p3 = new Pair<Integer, String>(2, "과자");
		Pair<Integer, String> p4 = new Pair<Integer, String>(3, "과자");
		
		boolean result2 = Util.compare(p3, p4);
			// key와 value를 and연산하여 참,거짓 반환
		System.out.println(result2);
			// 거짓 출력
		
		
	}	// m e
}	// c e
