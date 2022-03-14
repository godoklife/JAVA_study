package Day09_220314;

public class Day09_03 {
	public static void main(String[] args) {
		
		// P.294~ 295
			// 만일 super() 생략시 컴파일러가 자동으로 추가해줌.
			// super() : 부모클래스 내 빈 생성자 호출
			// super(인수1, 인수n...) ㅣ 부모클래스 내 [n개 인수] 생성자 호출
			
		// 1. 서브클래스로 객체 생성
		Student student = new Student("김용준", "123123-123123", 1);
		
		// 2. 서브클래스로 만든 객체로 슈퍼클래스 내 멤버 접근
		System.out.println("name : "+student.name);
		System.out.println("ssn : "+student.ssn);
		System.out.println("studnet no : "+student.studentNo);
		
		
	}
}
