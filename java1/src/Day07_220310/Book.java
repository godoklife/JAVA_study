/*
 * Day07_05_bookApp
 * 
 * 도서 관리 클래스
 * 
 */

package Day07_220310;

public class Book {

	// 1. 필드
	String ISBN;		// ISBN
	String bname;		// 책 이름
	String bwriter;		// 작가
	boolean brental;	// 도서 대여 여부
	String mid;			// 대여인 ID
	
	// 2. 생성자
		// 1. 빈 생성자[기본생성자] : 매서드 호출용, ctrl + space_bar(단축키)
	public Book() {	}
		// 2. 풀 생성자 [ 모든 필드를 입력받는 생성자 ] : 도서등록
	public Book(String iSBN, String bname, String bwriter, boolean brental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.bwriter = bwriter;
		this.brental = brental;
		this.mid = mid;
	}
	
	// 3. 메서드
		// 1. 도서검색
	void 도서검색() {
		System.out.println("--------도서검색 페이지--------");
		System.out.print("검색하실 책 이름을 입력하세요 : ");
		String bookname = Day07_05_bookApp.scanner.next();
		
		
	}
		// 2. 도서목록
	void 도서목록() {
		System.out.println("--------도서목록 페이지--------");
		System.out.print("ISBN\t도서명\t작가\t대여가능여부\n");
		for(Book temp : Day07_05_bookApp.books) {
			if(temp != null) {
				if(temp.brental)	// 대여 가능한 책 (T) 출력
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t대여가능");
				else				// 불가능 책(F) 출력
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t대여불가");
			}
		}
	}	// 도서목록 END
		// 3. 도서대여
	void 도서대여(String loginid) {	// book.도서대여(loginID); 에서 받은 사용자 아이디 입력받음.
		System.out.println("--------도서대여 페이지--------");
		System.out.print("ISBN\t도서명\t작가\t대여가능여부\n");
		for(Book temp : Day07_05_bookApp.books) {
			if(temp != null) {
				if(temp.brental)	// 대여 가능한 책 (T) 출력
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t대여가능");
				else				// 불가능 책(F) 출력
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t대여불가");
			}
		}
		System.out.println("--------------------------");
		System.out.print("대여하실 책 ISBN을 입력하세요 : ");
		String isbn = Day07_05_bookApp.scanner.next();
		
		for(Book temp : Day07_05_bookApp.books) {
			if(temp!=null && temp.ISBN.equals(isbn) && temp.brental) {
				System.out.println("선택하신 "+temp.bname+"을 대여했습니다.");
				temp.brental=false;
				temp.mid = loginid;
				return;
			}
			else if(temp!=null && temp.ISBN.equals(isbn) && !(temp.brental)) {
				System.out.println("선택하신 "+temp.bname+" 대여중입니다.");
				return;
			}
		}
		
	}	// 도서대여 END
	
	///////////////////////////////////////////////////
		// 4. 도서반납
	void 도서반납(String loginid) {
		System.out.println("--------도서반납 테스트페이지--------");
		System.out.print("ISBN\t도서명\t작가\t대여가능여부\n");
		for(Book temp : Day07_05_bookApp.books) {
			if(temp != null && temp.mid.equals(loginid)) {
					// 도서가 존재하면서 대여ID와 현재 로그인된 ID가 같다면
				if(temp.brental)	// 대여 가능한 책 (T) 출력
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t대여가능");
				else				// 불가능 책(F) 출력
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t대여불가");
			}
		}
	}
	///////////////////////////////////////////////////
	// 만드는중
	
		// 5. 도서등록
	void 도서등록() {
		System.out.println("--------도서등록 페이지--------");
		System.out.println("ISBN : ");
		String ISBN = Day07_05_bookApp.scanner.next();
		System.out.println("도서명 : ");
		String bname = Day07_05_bookApp.scanner.next();
		System.out.println("작가 : ");
		String bwriter = Day07_05_bookApp.scanner.next();
		
			// * 중복체크
		for(Book temp : Day07_05_bookApp.books) {
			if(temp!=null && temp.ISBN.equals(ISBN)) {
				System.out.println("알림) 이미 등록된 책 입니다.");
				return;	// 책 등록 종료
			}
		}
		
		// 2. 객체화 시켜서	 [ 도서 대여 = T/F
		Book book = new Book(ISBN, bname, bwriter, true, null);	
			// void 도서등록 이하 입력받은 값들을 public Book 풀 생성자에 넣음.
			// true, null은 아직 정해지지 않아서 임의지정해준거.
		// 3. 배열에 대립시키기
		int i=0;	// 인덱스값 카운트
		for(Book temp : Day07_05_bookApp.books) {
			if(temp==null) {
				Day07_05_bookApp.books[i]=book;
				return;	// 등록 성공하면 종료!
			}
			i++;
		}
		
	}
		// 6. 도서삭제
	void 도서삭제() {
		System.out.println("--------도서삭제 테스트페이지--------");
	}
	
	
	
	
}
