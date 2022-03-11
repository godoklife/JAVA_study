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
	
	boolean signup(){
		Random random = new Random();
		System.out.println("---------- 회원가입 페이지 ----------");
		System.out.print("아이디 : "); String id = Menu.scanner.next();
		for (Member temp : Menu.members) {
			if (temp != null && temp.id.equals(id)) {
				System.out.println("알림) 현재 사용중인 아이디입니다.");
				return false;
			}
		}
		System.out.print("비밀번호 : "); String password = Menu.scanner.next();
		System.out.print("이름 : "); String name = Menu.scanner.next();
		System.out.print("전화번호 : "); String phone = Menu.scanner.next();
		
		
		int ano = random.nextInt(10000)+10001;	// 10000~20000 까지 계좌번호 발급
		
		Member member = new Member(ano, id, password, name, phone);	
		System.out.println("알림) 회원가입 완료.");
		System.out.println("알림) 회원님의 계좌번호는 : " + ano);
		return true;
	}
	void login(){}
	void findid(){}
	void findpw(){}
	
	
	
} // c e
