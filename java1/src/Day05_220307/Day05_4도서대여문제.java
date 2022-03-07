package Day05_220307;

import java.util.Scanner;

public class Day05_4도서대여문제 { // c s

	public static void main(String[] args) { // m s
	
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		String[][] userlist = new String[100][2]; // 1열 아이디 2열 비밀번호
		userlist[0][0] = "admin" ; userlist[0][1] = "1";
		String[][] booklist = new String[100][2]; // 0 이면 대여가능 1 이면 대여중
		
		for(int i=0; i<booklist.length; i++) {	// 도서명 초기화(테스트용)
			booklist[i][1] = "대여가능";
		}
		
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
						boolean admincheck = true;
						
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
											System.out.printf("%s\t%s\n",booklist[adi][0],booklist[adi][1]);
																			
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
									admincheck = false;
									break;
								}
								else {
									System.out.println("알림]] 잘못된 행동입니다.");			
								}
								
							} // admin 메뉴 while end
						} // admin if end
						if(admincheck==true) {
							while(true){// 로그인 이후 무한반복, 종료조건 : 5번 로그아웃
								System.out.println("--------------------------");
								System.out.println("1. 도서검색 | 2. 도서목록 | 3. 도서대여 | 4. 도서반납 | 5. 로그아웃");
								System.out.print("선택> ");
								int input2=scanner.nextInt();
								
								if(input2==1) {	// 1. 도서 검색 진입 if문
									boolean bookscan = false;	// 검색한 책이 존재하는지 여부 플래그
									System.out.println("------도서 검색 매뉴입니다.------");
									System.out.print("검색할 도서명을 입력하세요 :");
									String bookname = scanner.next();
									for(int ii=0; ii<booklist.length; ii++) {
										if(booklist[ii][0]!=null && booklist[ii][0].equals(bookname)) {
											System.out.printf("도서명 : %s | 대여 여부 : %s\n", booklist[ii][0], booklist[ii][1]);
											bookscan = true;	// 플래그 켬
										}
									if(bookscan==false)	// 검색한 책이 존재하는지 여부 플래그 확인
										System.err.println("일치하는 책이 없습니다.");
									} // 도서명 배열에서 찾는 for end
								}// 1. 도서 검색 if end
								
								else if(input2==2) {	// 2. 모든 책 출력 진입 if문
									System.out.println("------도서 목록을 출력합니다.------");
									for(int ii=0; ii<booklist.length; ii++) {	// 2. 모든 책 출력 for문
										if(booklist[ii][0]!=null) 
											System.out.printf("도서명 : %s\n ", booklist[ii][0]);
									}	// 2. 모든 책 출력 for end
								}	// 2. 모든 책 출력 진입 if end
								
								else if(input2==3) {	// 3. 도서 대여 진입 if문
									boolean booklent = false;
									System.out.println("------도서 대여 매뉴입니다.------");
									System.out.print("대여할 도서 제목을 입력하세요 : ");
									String bookname = scanner.next();
									for(int ii=0; ii<booklist.length; ii++) {
										if(booklist[ii][0]!=null && booklist[ii][0].equals(bookname) && booklist[ii][1].equals("대여가능")) {	// 책이름이 일치하고 대여가능하고 널값이 아닌것
											System.out.println("대여 가능합니다. 대여하시겠습니까? (y or n)");
											String choice = scanner.next();
											if (choice.equals("y")) {
												System.out.printf("%s 대여 완료.",booklist[ii][0]);
												booklist[ii][1]="대여불가";
												booklent=true;
												break;
											}
											else if (choice.equals("y")){
												System.out.println("대여 취소");
												booklent=true;
												break;
											}
										}
										else if(booklist[ii][0].equals(bookname) && booklist[ii][0].equals("대여불가") && booklist!=null) {	// 책이름이 일치하고 대여불가하고 널값이 아닌것
											System.err.println("이미 대여중인 책 입니다.");
											booklent=true;
											break;
										}
									}
									if (booklent==false)
										System.out.println("일치하는 책이 없습니다.");
									
								}
								else if(input2==4) {
									
								}
								else if(input2==5){
									System.err.println("5. 로그아웃");
									break;
								}
								else {
									System.out.println("잘못 누르셨습니다");
								}
							} // 일반회원 while end
						} // admincheck end
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