package Day08_220311;

public class Day08_02 {
	public static void main(String[] args) {
		
		// P.245 : final
			// 상수, 최종값
			// 사용되는 방법 : 1. 필드 선언시, 2. 생성자에서
		
		
		// 1. 객체 생성
		Person p1 = new Person("123123-123123", "아무개");
		
		// 2. rorcp so vlfem tnwjd
		// p1.nation = "USA";			// final 필드가 아니라면 수정 가능함.
		
		// p1.ssn = "123123123-12";		// 그러나 final 붙어있으므로 수정 불가능!
		
		p1.name = "홍길동";
		
		
		
	}
}
