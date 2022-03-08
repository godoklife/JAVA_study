package Day06_220308;

public class Board {
	// * 보드 클래스 선언
	
	// 1. 필드
	String title;
	String content;
	String writer;
	String password;
	
	// 2. 생성자 [ 클래스 이름과 동일한 생성자명 ]
		// 이클립스에서 생성자 자동생성하는법
		// 에디터 우클릭 -> source -> 제너레이트 컨스트럭터 using fields
	
		// 1. 빈 생성자
	Board(){}
		// 2. 1개 필드를 받는 생성자
	Board(String title){
		this.title = title;
		// this.필드명 => 내부변수(1. 필드 에 있는 변수)
		// * 외부로부터 들어온 제목을 내부에 저장
	}
		// 3. 2개 필드를 받는 생성자
	Board(String title, String content){
		this.title = title;
		this.content = content;
	}
		// 4. 3개 필드를 받는 생성자
	Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
		// 5. 4개 필드를 받는 생성자
	Board(String title, String content, String writer, String password) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
	}
	
	// 3. 메서드
	
}
