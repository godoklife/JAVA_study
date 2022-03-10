/*
 * Day07_05_bookApp
 * 
 * 맴버 관리 클래스
 * 
 */

package Day07_220310;

public class Member {
	
	// 1. 필드
	int mno;			// 회원번호 [ 자동번호, 중복X ]
	String id;			// 아이디 [ 중복 X ]
	String password;	// 비밀번호
	String name;		// 이름
	String phone;		// 연락처
	
	// 2. 생성자
	public Member() { }
	
	public Member(int mno, String id, String password, String name, String phone) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}



	// 3. 메서드
		// 1. 회원가입 메서드 [ 인수 X, 반환 O ]
	boolean signup() {	// 가입 성공시 true, 실패시 false 반환
		System.out.println("--------------회원가입 매뉴--------------");
		System.out.print("아이디를 입력해주세요 : ");
		this.id = Day07_05_bookApp.scanner.next();
			// 메모리 아껴쓰기 위해 이 class가 사용될 main class의 스캐너 사용.
		for(Member temp : Day07_05_bookApp.members) {	// 아이디 중복 체크
			if(temp != null && temp.id.equals(id)) {
				System.out.println("알림||| 중복된 아이디 입니다.");
				return false;	// 바로 false값 반환하고 메서드 종료.
			}
		}	// 아이디 중복 체크 for END
		System.out.print("비밀번호를 입력해주세요 : ");
		this.password = Day07_05_bookApp.scanner.next();
		System.out.print("이름을 입력해주세요 : ");
		this.name = Day07_05_bookApp.scanner.next();
		System.out.print("연락처를 입력해주세요 : ");
		this.phone = Day07_05_bookApp.scanner.next();
		
		// * 회원번호 자동 주입 [ 가장 최근에 가입한 회원의 번호 +1 ]
			// null을 찾아서 -1 하면 가장 최근에 가입한 회원의 번호 나옴.
		int bno = 0;	// 회원번호를 저장하는 변수
		int j = 0;	// 인덱스 임시저장용 변수
		for(Member temp : Day07_05_bookApp.members) {
			if(temp==null) {
				if(j==0) {
					bno = 1;
					break;
				}// 만약 첫번째 회원이면 -1 인덱스 나오는거 방지.
				bno = Day07_05_bookApp.members[j-1].mno +1;
					//null값 앞 [ 마지막회원 ] 번호에 +1
				break;
			}
			j++;	
		}
		
		Member member = new Member(mno, id, password, name, phone);
			// 모든 필드를 받는 생자로 객체 생성.
		
		//for (int i=0; i< Day07_05_bookApp.members.length ; i++) 는 아래와 같다.
		int i=0;
		for(Member temp : Day07_05_bookApp.members) {	// 배열내 빈 공간을 찾기위해 temp에 대입하기.
			if (temp==null) {	// temp가 빈 공간이면
				Day07_05_bookApp.members[i] = member;	// 빈 인덱스에 새로운 회원 정보 대입
				System.out.println("회원님의 회원 번호 : "+bno);
				return true;	// 회원가입 성공했으니 true 반환.
			}
			i++;
		}
		return false;	// if문에 들지 못하면 false 반환하고 종료.(회원가입 실패했다고 전달)
		// 1. 네개의 값을 입력받는다 [ id, pw, name, phonenumber ] 
		
		
			// * scanner 객체가 다른 클래스 내 static형태로 선언되어 있음. 
			// * 클래스명 . 필드명
				// -> 무조건 메모리에 올라가 있다.
		// 2. 4개 변수 -> 객체화 -> 1개
		// 3. 배열 내 빈 공간을 찾아서 새로운 회원 [ 객체 ] 만들기
		// 4. 가입 성공시 true 번환, 실패시 false 반환
		
		
		
		
	}	// signup END
	
		// 2. 로그인 메서드	[ 인수 X, 반환 O ]
	String login() {	// 로그인 성공시 아이디, 실패시 null 반환
		return "아이디";
	}
		// 3. 아이디 찾기 메서드	[ 인수 X, 반환 X ]
	void findID() {
		
	}
		// 4. 비번 찾기 메서드	[ 인수 X, 반환 X ]
	void findPW() {
		
	}
		// 5. 회원 탈퇴 메서드
		// 6. 회원정보 수정 메서드
	
}
