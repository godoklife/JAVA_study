// 연습문제 6번

/*
 * 자식 클래스가 메모리할당[객체생성]을 하면 부모클래스 내 생성자 우선 호출.
 * 	// this.필드명 : 현 클래스 내 필드 호출
 * 	// this.메서드명() : 현 클래스 내 메서드 호출
 * 	// this() : 현 클래스 내 생성자 호출
 * 	// super.필드명 : 부모 클래스 내 필드 호출
 *	// super.메서드명() : 부모 클래스 내 메서드 호출
 *	// super() 부모 클래스 내 생성자 호출
 *	// 1. 자식 클래스 내 기본생성자 호출				출력4분
 *	// 2. 부모 클래스 내 기본생성자 호출				출력2번
 *	// 3. 부모 클래스 내 [ 1개 인수 ] 생성자 호출	출력1번
 *	// 4. 자식 클래스 내 [ 1개 인수 ] 생성자 호출	출력3번
 */


package Day10;

public class ChildExample {
	public static void main(String[] args) {
		Child child = new Child();
	}
}
