package Day05_220307;

import java.lang.reflect.Member;
import java.util.Scanner;

public class Day05_book_rent_management_program {	// c s
	public static void main(String[] args) {	// m s
		
		Scanner scanner = new Scanner(System.in);
		String[][] userlist = new String[100][2];
		String[][] booklist = new String[10][3];
		
		
		for(int i=0; i<booklist.length; i++) {	// 도서명 초기화(테스트용)
			booklist[i][0] = "책";
			booklist[i][1] = "대여가능";
			booklist[i][2] = "ID";
		}
		
		
		while(true) {
			System.out.println("----------초기 매뉴----------");
			System.out.println("--------------------------");
			System.out.println("1. 회원가입 | 2. 로그인");
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
						System.out.println("로그인까진 됨");
						login=true;
						break;
					}
					else
						System.out.println("아이디나 비밀번호를 확인하세요.");
				}
				
				
				if(login=true) {	// 로그인 스위치가 true인지 판단
					
					while(true) {	// 로그인 이후 무한반복, 종료조건 : 5번 로그아웃
						System.out.println("--------------------------");
						System.out.println("1. 도서검색 | 2. 도서목록 | 3. 도서대여 | 4. 도서반납 | 5. 로그아웃");
						System.out.print("선택> ");
						int input2=scanner.nextInt();
						
						if(input2==1) {	// 1. 도서 검색 진입 if문
							System.out.println("------도서 검색 매뉴입니다.------");
							System.out.print("검색할 도서명을 입력하세요 :");
							String bookname = scanner.next();
							for(int i=0; i<booklist.length; i++) {
								if(booklist[i][0]!=null && booklist[i][0].equals(bookname)) {
									System.out.printf("도서명 : %s | 대여 여부 : %s\n", booklist[i][0], booklist[i][1]);
								}
								else {
									System.err.println("일치하는 책이 없습니다.");
									break;
								}	
							} // 도서명 배열에서 찾는 for end
						}// 1. 도서 검색 if end
						
						else if(input2==2) {	// 2. 모든 책 출력 진입 if문
							System.out.println("------도서 목록을 출력합니다.------");
							for(int i=0; i<booklist.length; i++) {	// 2. 모든 책 출력 for문
								if(booklist[i][0]!=null) 
									System.out.printf("도서명 : %s\n ", booklist[i][0]);
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
						
					}	// 로그인 이후 while end
				}	// 로그인 스위치가 true인지 판단 if end
			}	// 로그인 if end
			else	// 초기매뉴에서 1번, 2번 이외 입력시
				System.err.println("잘못 누르셨습니다.");
		}	// while end
	}	// m e
}	// c e
