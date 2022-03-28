package Day17_220324_결석2;

public class 코스<T> {
	// < 제네릭 이름 > : 외부로부터 들어오는 자료형 -> 내가 임의로 지정 가능.
	
	// 1. 필드
	private String name;
	// 문자열 변수 : 과정명
	private T[] students;
	
	// ??? 배열 : 학생 배열 -> 외부에서 들어온 자료형 [ 매개 ]
		// ????????????????
	
	// 2. 생성자
		// 외부로부터 과정명과 인원수를 받아서, 인원수만큼 제네릭타입으로 배열 내 메모리 할당.
	public 코스() {
		// TODO Auto-generated constructor stub
	}

	public 코스(String name, int capacity) {
		this.name = name;
		students = (T[]) new Object[capacity];
			// * 매개타입으로 new(메모리할당) 불가
			// 1. new Object[인수로 받은 인원수] : 인원수 만큼 Object 배열 길이 선언
			// 2. Object 배열 -> T[] 배열로 강제형변환
			// * super-> sub클래스로 강제형변환은 당연?히 가능
	}
	
	// 3. 메서드
		// 과정명 호출 메서드
	public String getName() {
		return name;
	}
		// 학생 배열 호출 매서드
	public T[] getStudents() {
		return students;
	}
		// 학생 배열에 객체 추가하는 메서드(ArrayList 클래스 설계 방식과 유사)
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}	// add end
	
}	// c e
