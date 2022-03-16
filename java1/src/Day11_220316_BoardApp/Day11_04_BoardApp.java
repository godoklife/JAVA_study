package Day11_220316_BoardApp;

import java.util.Scanner;


public class Day11_04_BoardApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Controller.load();
		
		while(true) {
			try {	// 예상되는 발생 예외 : 사용자가 숫자 이외의 값 입력.
			System.out.printf("%s\t%s\t%s\t%s\t%s\t \n","번호","제목","작성자","작성일","조회수");
			int i=1;
			for( Board board : Controller.boardlist ) {
				System.out.printf("%2s\t%10s\t%10s\t%10s\t%2s\t \n", i , board.getTitle() ,
						board.getWriter() , board.getDate() , board.getViewcount() );
				i++;
			}
			System.out.print("1.쓰기 2.보기 선택 >");
			System.out.println(Controller.boardlist);
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
				// g
			}
			else {
				
			}
			} catch (Exception e) {
				System.out.println("경고) 보기에 있는것만 누르시오.");
				scanner = new Scanner(System.in);	
					// 기존 스캐너를 다시 메모리 할당 해줌으로써 메모리를 비워줌.
			}
			
		}	// while END
	}	// main END
}	// class END
