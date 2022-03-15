package Day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Day10_05_도서관리_리스트버전 {
	public static void main(String[] args) {
		
		// 1. 리스트 [객체] 생성
		ArrayList<Book> booklist = new ArrayList<>();
	//	리스트 클래스<데이터형> 리스트명 = 메모리할당 생성자<>();
		// <클래스> : 해당 클래스의 여러 객체를 리스트에 저장
		// 길이는 가변 [ 기본 : 10 ]
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. 등록 | 2. 목록 | 3. 삭제 | 4. 수정");
			int ch= scanner.nextInt();
			if(ch==1) {
				// 1. 입력받기
				System.out.print("도서명 : ");
				String bookname = scanner.next();
				System.out.print("저자명 : ");
				String writer = scanner.next();
				
				// 2. 객체화 [ 여러개의 변수를 -> 1개 객체 ]
				Book book = new Book(bookname, writer);
				booklist.add(book);	// 배열과 달리 알아서 빈 자리(마지막 자리) 찾아서 book 객체를 저장함.
				
				
				
			}else if(ch==2){
				// 1. 리스트는 null 제거 할 필요 없이 그냥 출력하면 됨. 빈공간에 null을 채워넣는게 아니기 때문.
				for(Book tmp : booklist) {
					System.out.println(tmp.getBookname()+"\t"+tmp.getWriter());
				}
				
			}else if(ch==3){
				// 리스트는 중간에 있는 인덱스의 값을 지울 경우 자동으로 데이터가 땡겨서 저장됨.	
				// 1 2 3 4 5 -> 1 2 4 5 
				System.out.print("삭제할 도서명 : ");
				String deleteBookName = scanner.next();
				
				for(Book tmp : booklist) {
					if(tmp.getBookname().equals(deleteBookName)) {
						booklist.remove(tmp);
						break;
					}
				}
				
			}else if(ch==4){
				System.out.print("수정 할 도서명 : ");
				String modBook = scanner.next();
				
				for(Book tmp : booklist) {
					if(tmp.getBookname().equals(modBook)) {
						System.out.print("수정 할 저자명 :");
						String modWriter = scanner.next();
						tmp.setWriter(modWriter);
					}
				}
				
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}	// while END
	}	// main END
}	// class END
