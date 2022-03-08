package Day06_220308;

public class Day06_05 {
	public static void main(String[] args) {
		
		// P.207
		
		// 1. 생성자 없이 필드에 값 넣기
		Korean k1 = new Korean();
			k1.name = "유재석";
			k1.ssn = "000202-1231231";
		System.out.println("k1의 이름"+k1.name);
		System.out.println("k1의 국적"+k1.nation);
		System.out.println("k1의 민번"+k1.ssn);

		// 2. 생성자를 통해 필드에 값 넣기
		Korean k2 = new Korean("박자바", "111-111");
		System.out.println("k2의 이름"+k2.name);
		System.err.println("k2의 국적"+k2.nation);
		System.out.println("k2의 민번"+k2.ssn);
		
		//////////////////////////////////////////////
		Korean 한국인1 = new Korean();
			// 한국인 1번은 이름이 없고, 국적이 대한민국이고, 민번X
		
		Korean 한국인2 = new Korean("유재석");
			// 한국인 2번은 이름이 유재석이고, 국적이 대한민국이고, 민번 X
		
		Korean 한국인3 = new Korean("강호동", "12312-123123");
			// 한국인 3번은 이름이 강호동이고, 민번이 있고, 국적이 대한민국이다.
		
		Korean 한국인4 = new Korean("일본", "신동엽", "123123-12");
			// 한국인 4번은 국적이 일본이고, 이름이 신동엽이고, 민번이 있다.
		
	}
}
