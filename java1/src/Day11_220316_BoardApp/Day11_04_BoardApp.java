package Day11_220316_BoardApp;

import java.util.Scanner;


public class Day11_04_BoardApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Controller.load();
		
		while(true) {
			try {	// 예상되는 발생 예외 : 사용자가 숫자 이외의 값 입력.
			System.out.printf("%2s\t%10s\t%10s\t%10s\t%2s\t \n","번호","제목","작성자","작성일","조회수");
			int i=1;
			for( Board board : Controller.boardlist ) {
				System.out.printf("%2s\t%10s\t%10s\t%10s\t%2s\t \n", i , board.getTitle() ,
						board.getWriter() , board.getDate() , board.getViewcount() );
				i++;
			}
			System.out.print("1.쓰기 2.보기 선택 >");
			int ch = scanner.nextInt();
			if(ch==1) {
				scanner.nextLine();	// 넥스트라인 고질병때문에 스캐너 메모리 비워야함. 비우려고 써준것.
				System.out.println("========= 게시물 등록 =========");
				System.out.print("제목 : ");
				String 제목 = scanner.nextLine();		// 공백 포함 입력 가능.
				System.out.print("내용 : ");
				String 내용 = scanner.nextLine();
				System.out.print("작성자 : ");
				String 작성자 = scanner.next();
				System.out.print("비밀번호 : ");
				String 비밀번호 = scanner.next();
				
				Controller.write(제목, 내용, 작성자, 비밀번호);
				
			}
			else if(ch==2) {
				// 해당 게시물 번호[인덱스]를 입력받아 게시물정보 모두 출력
				System.out.print("게시물 번호 입력 : "); int index = scanner.nextInt();
				Board temp =  Controller.boardlist.get(index);
				System.out.println("***** 게시물 보기 *****");
				System.out.println(" 제목 : "+ temp.getTitle());
				System.out.println(" 조회수 : "+ temp.getViewcount());
				System.out.println(" 작성일 : "+temp.getDate());
				System.out.println(" 내용 : "+ temp.getContent());
				
				System.out.println(" 1. 뒤로가기 | 2. 수정 | 3. 삭제 | 4. 덧글쓰기 ");
				System.out.print("선택 >"); int ch2=scanner.nextInt();
				
				if(ch2==1) {
					System.out.println("뒤로가기");
				}
				else if(ch2==2) {
					System.out.println("***** 수정 *****");
					while(true) {
						System.out.println("수정할 대상 선택\n1. 제목 | 2. 내용 | 3. 비밀번호 | 4. 취소");
						System.out.print("선택 >"); int ch3 = scanner.nextInt();
						if (ch3==1) {
							System.out.print("제목을 입력하세요 : ");
							scanner.nextLine();
							String newtitle = scanner.nextLine();
//							Controller.boardlist.getTitle;
							
						}else if(ch3==2) {
							
						}else if(ch3==3) {
							
						}else {
							System.out.println("잘못 누르셨습니다.");
						}
					}
				}	// 게시물 수정 else if END
				else if(ch2==3) {
					System.out.println("비밀번호 입력하세요");
					String password = scanner.next();
					boolean result = Controller.delete(index, password);	// 컨트롤러의 delete메서드로 게시글 인덱스번호와 패스워드 전달
					
					if (result == true) {
						System.out.println("삭제 성공");
					}else {
						System.out.println("비밀번호를 확인하세요.");
					}
					
					
				}	// 게시물 삭제 else if문 END
				else if(ch2==4) {
					
				}
				else {
					
				}
				
				
			}
			else {
				System.out.println("경고) 잘못 입력하셨습니다");
			}
			} catch (Exception e) {
				System.out.println("경고) 보기에 있는것만 누르시오.");
				scanner = new Scanner(System.in);	
					// 기존 스캐너를 다시 메모리 할당 해줌으로써 메모리를 비워줌.
			}
			
		}	// while END
	}	// main END
}	// class END
