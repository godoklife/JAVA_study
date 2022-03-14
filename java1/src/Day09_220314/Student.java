package Day09_220314;

public class Student extends People {
		//  서브클래스명 extends 수퍼클래스명
	// 1. 필드
	public int studentNo;
	// 2. 생성자
	public Student(String name, String ssn, int studentNo) {
		// 부모클래스 내 멤버 필드 초기화 방법 2가지
			// 1. 필드에 접근한다
			// this.name = name;
			// this.ssn = ssn;
			// 2. 생성자에 접근
			// super(name, ssn)
		super(name, ssn);
		this.studentNo = studentNo;
		
	}
	// 3. 메서드
	
	
}
