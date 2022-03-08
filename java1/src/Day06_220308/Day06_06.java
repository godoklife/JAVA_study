package Day06_220308;

import java.util.Scanner;

public class Day06_06 {	// c s
	public static void main(String[] args) {	// m s
		// 게시판
		
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
			// Board 객체를 100개 저장할 수 있는 1차원 배열
		
		while(true) {	// 프로그램 실행 무한루프, [ 종료조건 : 없음 ]
			
			System.out.println("----------커뮤니티----------");
			System.out.println("번호\t\t작성자\t\t제목");
				// 배열 내 모든 객체(게시물) 출력하는 반복문
			int index = 0;	// 배열 인덱스 카운트 변수
			for(Board board : boardlist ) {
				if(board != null) {
					System.out.printf("%d\t\t%s\t\t%s\n", index, board.writer, board.title);
				}
				index++;	// 인덱스 증가
			}
			
			
			
			System.out.println("1. 글쓰기 | 2. 글보기");
			int ch = scanner.nextInt();
			if(ch == 1) {
				System.out.println("-----------------글쓰기 페이지-----------------");
				
				// 1. 4개의 변수를 입력받는다.
				System.out.println("title : ");
				String title = scanner.next();
				System.out.println("content : ");
				String content = scanner.next();
				System.out.println("writer : ");
				String writer = scanner.next();
				System.out.println("password : ");
				String password = scanner.next();
				
				// 2. 4개의 필드를 갖는 생성자 사용
				Board board = new Board(title, content, writer, password);
				
				// 3. 배열 내 빈공간을 찾아서 객체 대입
				int i=0;	// 인덱스 번호 카운트용
				for(Board temp : boardlist) {
					if( temp == null ) {	// temp 객체의 필드가 모두 null일때
						boardlist[i] = board;	// 해당 인덱스에 새로운 객체 저장
						break;	// 저장 했으면 반복문 종료
					}
					i++;	// 반복 1회당 인덱스 1 증가
				}
				
			}	// ch==1 if end
			
			else if(ch == 2) {
				System.out.println("==============글보기==============");
				System.out.println("1. 목록보기 | 2. 삭제 | 3. 수정");
				int menu = scanner.nextInt();	// 글보기 내 매뉴 선택 저장 변수
				
				if (menu==1) {	
					System.out.print("게시물 번호(인덱스) 선택 : ");
					int bno = scanner.nextInt();
					
					// 반복문 필요 X, 바로 윗 라인에서 인덱스를 입력받았기 떄문에.
					System.out.printf("작성자 : %s 제목 : %s \n", boardlist[bno].writer, boardlist[bno].title);
					System.out.println("내용");
					System.out.printf("%s\n", boardlist[bno].content);
					System.out.println("==============================");
					System.out.print("1. 목록보기(뒤로가기) | 2. 글삭제 | 3. 글수정");
					System.out.print("선택>");
					
					int ch2 = scanner.nextInt();
					
					if(ch2==1) {
						System.out.println("뒤로가기.");
					}	// ch2==1 end
					
					else if(ch2==2) {
						// 인덱스 번호를 위에서 입력받았기 때문에 반복문 돌릴 필요 없음.
						System.out.println("글삭제");
						System.out.print("비밀번호를 입력해주세요 : ");
						String pw = scanner.next();
						if(boardlist[bno].password.equals(pw)) {
							boardlist[bno]=null;
							
							/////////////////////////////////////////////
							// 삭제 후에 삭제된 인덱스 뒤로 한칸씩 앞으로 이동
							// 왜냐? 만약 해당 코드가 없을 경우 배열 내 사이사이 공백 발생
						for(int i = bno ; i<boardlist.length; i++) {
							// * 검색된 게시물의 인덱스부터 마지막 인덱스까지 1씩 증가
							boardlist[bno] = boardlist[bno+1];
							
							if(i == boardlist.length-1)
								boardlist[boardlist.length-1]=null;
						}
							/////////////////////////////////////////////
							
							System.out.println("삭제되었습니다.");
						}
						else
							System.out.println("비밀번호를 확인해주세요");
					}	// ch2==2 end
					
					else if(ch2==3) {
						
					}	// ch2==3 end
					else 
						System.out.println("잘못누르셨습니다.");
					
					
					
					
					
					
				}	// menu==1 if end
				
				else if(menu==2) {
					
				}	// menu==2 if end
				
				else if(menu == 3) {
					
				}	// menu==3 if end
				else
					System.out.println("잘못 누르셨습니다.\n 뒤로가기");
				
				
			}	// ch==2 if end
			else
				System.out.println("잘못 누르셨습니다.");
			
		}	// 프로그램 while end
	}	// m e
}	// c e
