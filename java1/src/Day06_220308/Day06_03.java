package Day06_220308;

import java.util.Scanner;

public class Day06_03 {	// c s
	public static void main(String[] args) {	// m s
		
		
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];	// 객체의 배열화
		
		while(true) {	// 프로그램 실행 무한루프 [ 종료조건 X ]
			
			System.out.println("회원제[클래스 버전]");
			System.out.println("[1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			System.out.print("선택>");
			int ch = scanner.nextInt();
			
			if(ch == 1) {	// 회원가입 if문 시작
				// 1. id, pw, name, phone 입력받기 => 변수 4개
				// 2. 객체 생성
				// 3. 입력받은 변수 4개를 객체 내 필드에 저장하기
				// 4. 여러개 객체를 저장하는 배열에 저장
				
				
				
				System.out.println("회원가입 매뉴입니다.");
				System.out.print("ID : ");
				String id = scanner.next();
				System.out.print("PW : ");
				String password = scanner.next();
				System.out.print("이름 : ");
				String name = scanner.next();
				System.out.print("전화번호 : ");
				String phone = scanner.next();
				
				// 2. 객체 생성
				Member member = new Member();
				
				// 3. 객체에 저장하기
				member.id = id;
				member.pw = password;
				member.name =name;
				member.phone = phone;
				
				// * 아이디 중복체크
					// 1. 배열내 객체 중 입력한 아이디와 동일한 아이디를 찾기.
				boolean idcheck = false;	// 아이디 중복 여부값 저장 변수
				for(Member temp : memberlist) {
					// * memberlist 배열 내 객체들을 '하나씩' temp에 대입 반복.
					if(temp != null && temp.id.equals(id)) {
						System.out.println("알림) 사용중인 아이디 입니다.");
						idcheck = true;	// 아이디가 중복임을 저장
						break;	// 넣어도 되고 안넣어도 되나 이미 중복값을 찾았기 때문에 중단시키는게 효율성면에서 좋다.
					}
				}
				
				// 아이디가 중복이 아닐 경우 저장.
				
				if(idcheck==false) {	// 아이디 중복 여부값 저장하는 변수 확인
					// 4. 여러개 객체를 저장하는 배열에 저장
						// 1. 공백 인덱스를 찾기 [ 왜? 공백이 아니면 덮어씌우기가 되버림. ]
					int i = 0; // 인덱스 위치 변수
					for(Member temp : memberlist) {
						// * memberlist 배열 내 member 객체를 하나씩 꺼내와서 temp에 저장 반복.
						// 2. 공백에 인덱스에 객체 객체 저장.
						if(temp == null) {	// 만약 해당 객체가 공백이면
							memberlist[i] = member;	// 해당 인덱스에 여지껏 입력받은것 저장된 객체 대입
							i++;	// 인덱스 값 UP
							System.err.println("회원가입이 완료되었습니다");
							break;	// for문 탈출
						}
					}
				}
			}	// 회원가입 if end
			
			else if(ch == 2) {	// 로그인 if문 시작
				boolean logincheck = false;	// true : 로그인 성공, false : 로그인 실패 
				// 1. 입력 받기
				System.out.println("\t로그인 매뉴입니다.");
				System.out.print("ID : ");
				String loginid = scanner.next();
				System.out.print("PW : ");
				String loginpassword = scanner.next();
				
				// 2. 기존 배열 [ 회원리스트 ] 내 입력받은 값과 비교
				for(Member temp : memberlist) {
					// temp라는 Member 객체를 만들고 
					if(temp != null && temp.id.equals(loginid) 
							&& temp.pw.equals(loginpassword)) {
						System.err.println("알림) 로그인 성공");
						logincheck = true;	// 로그인 성공 했다는 기록 남기기
					}
				}
				
				// 3. 로그인 성공 유무 확인(로그인 성공시 실행되지 않음)
				if(logincheck==false) {
					System.out.println("아이디나 비밀번호를 확인하세요.");
				}
				
			}	// 로그인 if end
			
			else if(ch == 3) {	// 아이디 찾기 if문 시작
				boolean findresult=false;
				// 1. 이름과 연락처를 입력받는다.
				System.out.println("\t아이디찾기 매뉴입니다.");
				System.out.print("이름 :");
				String name = scanner.next();
				System.out.print("연락처 :");
				String phone = scanner.next();
				
				// 2. 배열내 동일한 이름과 연락처가 있는지 확인한다.
				for(Member temp : memberlist) {	// 3. 동일한 객체가 있으면 해당 아이디 출력
					if(temp!=null && temp.name.equals(name) && temp.name.equals(phone)) {
						System.out.println("알림) 아이디 찾기 성공");
						System.out.println("회원 아이디 : "+ temp.id);
						findresult = true;
						break;	// 아이디 찾았으니 break 걸어서 멈추기.
					}
				}				
				// 4. 없으면 없다고 출력
				if(findresult==false) {
					System.err.println("동일한 회원정보가 없습니다.");
				}
			}	// 아이디 찾기 if end
			
			else if (ch == 4){	// 비밀번호 찾기 if문 시작
				boolean findpw = false;
				System.out.println("\t비밀번호찾기 매뉴입니다");
				System.out.print("ID : ");
				String id = scanner.next();
				System.out.println("전화번호 : ");
				String phone = scanner.next();
				
				for(Member temp : memberlist) {
					if(temp!=null && temp.id.equals(id) && temp.phone.equals(phone)) {
						System.out.println("알림) 비밀번호 찾기 성공");
						System.out.println("회원 비밀번호 : " + temp.pw);
						findpw=true;
					}
				}
				if(findpw==false) {
					System.err.println("일치하는 회원정보가 없습니다.");
				}
			}	// 비밀번호 찾기 if end
			
			else
				System.out.println("잘못 누르셨습니다.");
		}	// while end
	}	// m e
}	// c e
