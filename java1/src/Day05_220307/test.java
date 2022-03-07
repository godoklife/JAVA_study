package Day05;

import java.util.Scanner;

public class Day05_4도서대여문제 { // c s

	public static void main(String[] args) { // m s
	
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		String[][] userlist = new String[100][2]; // 1열 아이디 2열 비밀번호
		userlist[0][0] = "admin" ; userlist[0][1] = "1";
		String[][] booklist = new String[100][2]; // 0 이면 대여가능 1 이면 대여중
		
		while(run) {
			System.out.println("----------도서대여 프로그램------------");
			System.out.println("1.회원가입 2.로그인");
			System.out.print("선택>"); int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("--------회원가입 페이지--------");
				System.out.print(" ID : "); String id = scanner.next();
				System.out.print(" PASSWORD : "); String pw = scanner.next();
				
				boolean idcheck = true ;
				
				for(int i = 0 ; i < userlist.length ; i++) {
					if(userlist[i][0] != null && userlist[i][0].equals(id)) {
						System.err.println("알림]] 동일한 아이디가 존재합니다.");
						idcheck = false;	
					}
				}
				
				if(idcheck == true) {
					for(int i = 0 ; i < userlist.length ; i++) {
						if(userlist[i][0] == null) {
							userlist[i][0] = id ; userlist[i][1] = pw ;
							System.err.println("알림]] 회원가입이 되었습니다.");
							break;
						}
					}
				}
			}else if(ch==2) {
				System.out.println("--------로그인 페이지--------");
				System.out.print("ID : "); String id = scanner.next();
				System.out.print("PASSWORD : "); String pw = scanner.next();
				
				boolean logincheck = false;
				for(int i = 0 ; i < userlist.length ; i++) {
					if(userlist[i][0] != null && userlist[i][0].equals(id) && userlist[i][1].equals(pw)) {
						System.err.println("알림]] 로그인 성공");
						logincheck = true;
						
						
						
						
						
						
						
						if(id.equals("admin")) {
							while(true) {
								System.out.println("---------관리자 전용 메뉴---------");
								System.out.println("1.도서등록 2.도서목록 3.도서삭제 4.로그아웃"); 
								int adch = scanner.nextInt();
								if(adch==1) {
									System.out.println("도서명을 입력하세요 : "); String book = scanner.next();
									for(int adi = 0 ; adi < booklist.length ; adi++) {
										if(booklist[adi][0] == null) {
											booklist[adi][0] = book;
											System.out.println("도서 등록 완료");
											break;
										}
									}
								}
								else if(adch==2) {
									System.out.println("-----도서목록 출력-----");
									System.out.println("도서명\t대여여부");
									for(int adi = 0 ; adi < booklist.length ; adi++) {
											if(booklist[adi][0] != null)
											System.out.printf("%s\n",booklist[adi][0]);
																			
									}
								}
//								else if(adch==3) {
//									System.out.println("도서명을 입력하세요 : "); String book2 = scanner.next();
//									for(int adi = 0 ; adi < booklist.length ; adi++) {
//										if(booklist[adi][0].equals(book2)) {
//											booklist[adi][0] = null;
//											System.out.println("도서 삭제 완료");
//										}else {
//											System.out.println("존재하지 않는 도서 입니다.");
//											break;
//										}
//
//									}
//								}
								else if(adch==4) {
									System.out.println("로그아웃 합니다.");
									break;
								}
								else {
									System.out.println("알림]] 잘못된 행동입니다.");
									
								}
							}
						}
					
					
					
					
					
					
					
					
					
					
					}
				}
				if(logincheck == false) {
					System.err.println("알림]] 회원정보가 없거나 다릅니다.");
				}				
			}else {
				System.out.println("알림]] 잘못된 행동입니다.");
			}
		} // while end
	
	} // m e
	
} // c e