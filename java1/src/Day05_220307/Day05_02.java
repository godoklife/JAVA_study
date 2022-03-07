package Day05_220307;

import java.util.Scanner;

public class Day05_02 {	// c s
	public static void main(String[] args) {	// m s
		Scanner scanner = new Scanner(System.in);	// 입력 객체
		// 회뭔 100명[ id, pw, name ]을 저장하는 배열
		String[][] memberlist = new String[100][3];	// 한 회원당 한 줄, 1열 id, 2열에 pw, 3열에 name
		// 방문록 100개[ title, contents, writer ] 를 저장하는 배열
		String[][] boardlist = new String[100][3];	// 한 개시물당 한 줄
		
		while(true) {	// w s		// 무한루프 [ 종료조건 없음!! ]
			System.out.println("------------------회원제 방명록------------------");
			System.out.println("---------------------------------------------");
			System.out.print("1. 회원가입 | 2. 로그인 | 선택> ");
			int choice = scanner.nextInt();	// choice = 사용자 선택 저장하는 변수
			
			
			if (choice==1) {
				boolean check=true;	// 아이디 중복체크후 중복시 가입 중단 스위치
				System.out.println("-----------------회원가입 페이지------------------");
				System.out.println("새로 만드실 ID를 입력해주세요");
				String newid=scanner.next();
				for(int i = 0; i<memberlist.length; i++) {	// 아이디 중복체크후 중복시 가입 중단 코드
					if (memberlist[i][0]!=null && memberlist[i][0].equals(newid)) {
						System.err.println("알림) 아이디가 이미 존재합니다. 다른 아이디를 선택해주세요.");
						check = false;	// 회원가입 중단 스위치 변경
						break;
					}
				}
				if(check==true) {
					System.out.println("새로 만드실 비밀번호를 입력해주세요");
					String newpw=scanner.next();
					System.out.println("사용자 성명을 입력해주세요.");
					String newname=scanner.next();
					// String 3개 변수를 입력 받아 memberlist 2차원 배열에 저장.
						// 1. 빈 공간[ 정수 = 0, 객체(문자열) = null ] 을 찾아서 저장.
						// 2. 아이디 중복체크
					
					// 데이터 저장부
					for(int i = 0; i<memberlist.length; i++) {
						 if (memberlist[i][0]==null) {
							// i번째 행의 ID가 없으면(String의 초기값은 null) 아래 데이타를 집어넣어라.	// 빈공간 찾기!!
							memberlist[0][0] = newid;
							memberlist[0][1] = newpw;
							memberlist[0][2] = newname;
							System.err.println("알림) 회원가입이 완료되었습니다.");
							break;	// 한번 저장 완료했으면 for문 탈출.	
						}
					}
				}
			}	// if end
			
			else if(choice==2) {	// 로그인부
					// 입력받은 아이디와 비번이 배열 내 데이터와 동일하면 로그인 OK 처리
				System.out.println("------------------로그인 페이지------------------");
				System.out.println("ID를 입력해주세요");
				String id = scanner.next();
				System.out.println("비밀번호를 입력해주세요");
				String pw = scanner.next();
				
				boolean logincheck = false;	// 로그인 성공 여부 기본값
				for(int i=0; i<memberlist.length;i++) {
					if(memberlist[i][0]!=null && memberlist[i][0].equals(id) && memberlist[i][1].equals(pw)) {	// null값을 따로 걸러내줘야 한다, ID가 맞는지 찾는 조건
						// null은 객체가 아니기 때문에 .equals가 불가능하다. -> ==는 사용 가능.
						System.err.println("알림) 로그인 성공!");
						
						logincheck = true;	// 로그인 성공 여부 값 저장
						
						while(true) {	// 로그인 했을때 무한루프, 탈출 조건은 2번 로그아웃 눌렀을때
							System.out.println("-------------------");
							System.out.println("--------방명록-------");
							System.out.printf("번호\t작성자\t제목\t내용\n");
								// 모든 방명록 출력
							for(int j=0;j<boardlist.length;j++) {
								if(boardlist[j][0]!=null) {
								System.out.printf("%d\t%s\t%s\t%s\n\n", 
										j, 
										boardlist[j][2],
										boardlist[j][0],
										boardlist[j][1]);
								}
							}
							
							System.out.print("\n1. 방명록 남기기 | 2. 로그아웃 | 선택 >");
							int choice2 = scanner.nextInt();
							
							if(choice2 == 1) {
								System.out.println("--------------글쓰기--------------");
								System.out.println("title : ");
								String title = scanner.next();
								System.out.println("content : ");
								String content = scanner.next();
								// 배열 내 공백을 찾아서 저장.
								for(int j=0; j<boardlist.length; j++) {
									if(boardlist[j][0]==null) {	// 만약 j번째 제목이 비어있으면
										boardlist[j][0]=title;
										boardlist[j][1]=content;
										boardlist[j][2]=id;
										System.err.println("알림) 방명록 저장이 완료되었습니다.");
										break;	// 입력한것들 저장하고 글쓰기 for--문 탈출
									}
								}
							}	// 글쓰기 if문
							else if(choice2 == 2) {
								System.err.println("알림) 로그아웃");
								break;
							}
							
							else
								System.err.println("알림) 알 수 없는 번호입니다. 다시 입력해주세요.");
						}
					}
				}	// 로그인부 for문 end
				if(logincheck==false)
					System.err.println("알림) 로그인 정보가 다릅니다.");
			}	// 로그인부 else if end
			else
				System.err.println("알림) 알 수 없는 번호입니다. 다시 입력해주세요.");
		}	// while 1 END	= 초기 매뉴 end
	}	// m e
}	// c e
