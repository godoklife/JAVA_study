package Day08_bank_test;

public class Member {

	// 1. 필드
		String name, phoneNumber, id, pw, ano;
		
		// 2. 생성자
		public Member(String name, String phoneNumber, String id, String pw) {	// 초기 회원가입시 사용할 생성자
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.id = id;
			this.pw = pw;
		}

		// 3. 메서드
		
		boolean join() {
			System.out.println("=============회원가입 메뉴입니다.=============");
			while(true) {
				System.out.print("ID : ");
				String newID = Menu.scanner.next();
				for(Member tmp : Menu.member) {
					if(tmp.id.equals(newID) && tmp.id != null) {
						System.out.println("중복된 아이디 입니다. 다른 아이디를 입력하세요.");
						return false;
					}	// 아이디 중복검사 for if문 END
				}	// 아이디 중복검사 for END
				System.out.print("PW : ");	
				String newPW = Menu.scanner.next();
				System.out.print("이름 : ");
				String newName = Menu.scanner.next();
				System.out.print("연락처 : ");
				String newphoneNumber = Menu.scanner.next();
				
				Member newmember = new Member(newName, newphoneNumber, newID, newPW);	// 입력받은 데이타들을 집어넣기 전에 객체화시킴
				int i=0;	// 인덱스 카운트용 변수
				for(Member tmp : Menu.member) {
					if(tmp!=null) {
						Menu.member[i] = newmember;
					}
					i++;
				}	// 배열에 저장용 for문 END
			}	// join while END
		}	// join END
	
}

