package Day05_220307;

import java.util.Scanner;

public class Day05_4도서대여문제통합 {
	public static void main(String[] args) {	// m s
		
		Scanner scanner = new Scanner(System.in);
		String[][] userlist = new String[100][2];
		userlist[0][0] = "admin" ; userlist[0][1] = "1"; 
		String[][] booklist = new String[100][2];		
		
		for(int i=0; i<booklist.length; i++) {	// 도서명 초기화(테스트용)
			booklist[i][1] = "대여가능";
		}		
		
		while(true) {
			System.out.println("----------초기 매뉴----------");
			System.out.println("--------------------------");
			System.out.println("1. 회원가입 | 2. 로그인");
			System.out.print("선택 : ");
			int input=scanner.nextInt();
			
			if(input==1) {	// 회원가입 매뉴 진입
				while(true) {	// 회원가입 반복
					
					boolean idcheck=true;	// 아이디 중복 여부 기록 스위치
					System.out.print("새로운 아이디를 입력하세요 : ");
					String newid = scanner.next();	// 사용자한테서 아이디 입력받고 저장하는 변수
					
					for(int i=0; i<userlist.length; i++) { // 아이디 중복체크
						if(userlist[i][0]!=null && newid.equals(userlist[i][0])) {	// 아이디 중복체크 if문 시작
							System.err.println("알림) 중복된 아이디입니다.");
							idcheck=false;
							break;
						}	// 아이디 중복체크 if end
					}	// 아이디 중복체크 for end
					
					if(idcheck==true) {	// 아이디 중복 통과한 경우만 아이디, 비밀번호 저장 시작
						System.out.print("비밀번호를 입력하세요 :");
						String newpw = scanner.next();
						
						for(int i=0; i<userlist.length; i++) {	// userlist 배열에서 빈 공간 찾는 for문
							if(userlist[i][0]==null) {	// 빈 공간 찾으면 저장하는 if문
								userlist[i][0]=newid;
								userlist[i][1]=newpw;
								System.err.println("알림) 회원가입이 완료되었습니다.");
								break;
							}	// 빈 공간 찾으면 저장하는 if end
						}	// userlist 배열에서 빈 공간 찾는 for end
						break;	// 회원가입 정상적으로 끝나면 while 탈출
					}	// 아이디, 비밀번호 저장 if end
				}	// 회원가입 while end
			}	// 회원가입 진입 if end

			else if(input==2) {	// 로그인 매뉴 진입 if문
				boolean login = false;	//로그인 상태 기록 스위치
				System.out.print("아이디 : ");
				String id = scanner.next();
				System.out.print("비밀번호 : ");
				String pw = scanner.next();
								
				for(int i=0; i<userlist.length; i++) {
					if(userlist[i][0].equals(id) && userlist[i][1].equals(pw) && userlist[i][0]!=null) {
						System.out.println("로그인 성공");
						login=true;
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
							admincheck = false;
						} // admin if 종료
						if(admincheck==true) {						
							while(true){// 로그인 이후 무한반복, 종료조건 : 5번 로그아웃
								System.out.println("--------------------------");
								System.out.println("1. 도서검색 | 2. 도서목록 | 3. 도서대여 | 4. 도서반납 | 5. 로그아웃");
								System.out.print("선택> ");
								int input2=scanner.nextInt();
								
								if(input2==1) {	// 1. 도서 검색 진입 if문
									System.out.println("------도서 검색 매뉴입니다.------");
									System.out.print("검색할 도서명을 입력하세요 :");
									String bookname = scanner.next();
									for(int ii=0; ii<booklist.length; ii++) {
										if(booklist[ii][0]!=null && booklist[ii][0].equals(bookname)) {
											System.out.printf("도서명 : %s | 대여 여부 : %s\n", booklist[ii][0], booklist[ii][1]);
										}
										else {
											System.err.println("일치하는 책이 없습니다.");
											break;
										}	
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
									System.out.println("------도서 대여 매뉴입니다.------");
									System.out.print("대여할 도서 제목을 입력하세요 : ");
									//String bookname = 
									
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
						}	// 일반회원 어드민 체크 end	

					} // 로그인성공 end

				}if(login == false) {
					System.out.println("아이디나 비밀번호를 확인하세요.");

				}
			}	
			else {	// 초기매뉴에서 1번, 2번 이외 입력시
				System.err.println("잘못 누르셨습니다.");
			}
		}	// 초기메뉴 end
		
	}	// m e
	
}	// c e