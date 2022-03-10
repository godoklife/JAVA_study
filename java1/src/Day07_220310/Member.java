/*
 * Day07_05_bookApp
 * 
 * 맴버 관리 클래스
 * 
 */

package Day07_220310;

public class Member {
	
	// 1. 필드
	int mno;			// 회원번호
	String id;			// 아이디
	String password;	// 비밀번호
	String name;		// 이름
	String phone;		// 연락처
	
	// 2. 생성자
		// 임의생성
	
	// 3. 메서드
		// 1. 회원가입 메서드 [ 인수 X, 반환 O ]
	boolean signup() {	// 가입 성공시 true, 실패시 false 반환
		System.out.println("회원가입 페이지 동작중");
		return true;
	}
		// 2. 로그인 메서드	[ 인수 X, 반환 O ]
	String login() {	// 로그인 성공시 아이디, 실패시 null 반환
		return "아이디";
	}
		// 3. 아이디 찾기 메서드	[ 인수 X, 반환 X ]
	void findid() {
		
	}
		// 4. 비번 찾기 메서드	[ 인수 X, 반환 X ]
	void findpw() {
		
	}
		// 5. 회원 탈퇴 메서드
		// 6. 회원정보 수정 메서드
	
}
