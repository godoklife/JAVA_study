package Day08_bank;

import java.util.Random;

public class Member { // c s

	int ano ;
	String id ;
	String password ;
	String name ;
	String phone ;
	
	public Member() {}
	public Member(String id, String password, String name, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	public Member(int ano, String id, String password, String name, String phone) {
		this.ano = ano;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	boolean signup(){ // 회원가입 메소드 시작
		Random random = new Random();
		System.out.println("---------- 회원가입 페이지 ----------");
		System.out.print("아이디 : "); String id = Menu.scanner.next();
		for (Member temp : Menu.members) { // id 중복검사 for문 시작
			if (temp != null && temp.id.equals(id)) {
				System.out.println("알림) 현재 사용중인 아이디입니다.");
				return false;
			}
		} // id 중복검사 for문 종료
		
		System.out.print("비밀번호 : "); String password = Menu.scanner.next();
		System.out.print("이름 : "); String name = Menu.scanner.next();
		System.out.print("전화번호 : "); String phone = Menu.scanner.next();
		
		int ano = random.nextInt(10000)+10001; // 10000~20000 랜덤으로 생성
		
		///////////////////////////////////////////
		//////////////////중복검사 해야함//////////////
		///////////////////////////////////////////
		
		Member member = new Member(ano, id, password, name, phone);	
		System.out.println("알림) 회원가입 완료.");
		System.out.println("알림) 회원님의 계좌번호는 : " + ano);
		return true;
	} // 회원가입 메소드 종료
	
	String login(){ // 로그인 메소드 시작
		System.out.println("---------- 로그인 페이지 ----------");
		System.out.print("아이디 : "); String id = Menu.scanner.next();
		System.out.print("비밀번호 : "); String password = Menu.scanner.next();
		for (Member temp : Menu.members) {
			if (temp != null && temp.id.equals(id) &&
				temp != null && temp.password.equals(password)) {
				// members배열내 객체와 아이디 비밀번호 일치하면 로그인성공 & 아이디 반환
				return id; 
			}
		}
		return null; // 반환값 id,admin,null 일 경우의 수로 분리
	} // 로그인 메소드 종료
	
	void findid(){ // 아이디찾기 메소드 시작
		System.out.println("---------- 아이디찾기 페이지 ----------");
		System.out.print("이름 : "); String name = Menu.scanner.next();
		System.out.print("전화번호 : "); String phone = Menu.scanner.next();
		for(Member temp : Menu.members) { // 이름,전화 일치찾기 for문 시작
			if(temp != null && temp.name.equals(name) &&
				temp.phone.equals(phone)) {
				System.out.println(name+"님의 아이디는 : " + temp.id);
				return; // 이름,전화 일치하면 종료
			}
		} // 이름,전화 일치찾기 for문 종료
		System.out.println("알림) 동일한 회원정보가 없습니다.");
	} // 아이디찾기 메소드 종료
	
	void findpw(){ // 비밀번호 찾기 메소드 시작
		System.out.println("---------- 비밀번호찾기 페이지 ----------");
		System.out.print("아이디 : "); String id = Menu.scanner.next();
		System.out.print("전화번호 : "); String phone = Menu.scanner.next();
		for(Member temp : Menu.members) { // 이름,전화 일치찾기 for문 시작
			if(temp != null && temp.id.equals(id) &&
				temp.phone.equals(phone)) {
				System.out.println(id+"님의 비밀번호는 : " + temp.password);
				return; // 이름,전화 일치하면 종료
			}
		} // 이름,전화 일치찾기 for문 종료
		System.out.println("알림) 동일한 회원정보가 없습니다.");
	} // 비밀번호 찾기 메소드 종료	
	
} // c e
