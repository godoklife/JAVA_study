/*
 * MVC 모델 중에서 현제 파일을 M, Model이라고 한다.
 * 
 */



package Day08_220311;

public class 클래스설계예제 {

	// 회원클래스를 설계한다고 합시다.
	
	
	// 1. 필드 [ private 강력권장 ]
	private String id;
	private String password;
	private String name;
	private String point;
	
	// 2. 생성자
		// 권장사항 : 깡통(ctrl + space_bar), 풀 생성자(
		// 1. 필드 0개 [ 빈 생성자 ]
		// 2. 필드 3개 [ 특정 생성자, 회원가입시 사용 예정 ]
		// 3. 필드 4개 [ 풀 생성자, 모든 회원정보 호출시 사용 예정 ] 
	
	public 클래스설계예제() {
		// TODO Auto-generated constructor stub
	}
	
	public 클래스설계예제(String id, String password, String name, String point) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.point = point;
	}

	// 3. 메서드
		// private 필드 사용시 get or set 메서드
		// 우클릭 - Source - Generate getter and setter
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	
	
	
	
}
