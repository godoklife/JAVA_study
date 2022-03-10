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
		System.out.println("--------도서목록 테스트페이지--------");
		
	}
		// 3. 도서대여
	void 도서대여() {
		System.out.println("--------도서대여 테스트페이지--------");
	}
		// 4. 도서반납
	void 도서반납() {
		System.out.println("--------도서반납 테스트페이지--------");
	}
	
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
		// 3. 배열에 대립시키기
		int i=0;	// 인덱스값 카운트
		for(Book temp : Day07_05_bookApp.books) {
			if(temp==null) {
				Day07_05_bookApp.books[i]=book;
			}
			i++;
		}
		
		
	}
		// 6. 도서삭제
	void 도서삭제() {
		System.out.println("--------도서삭제 테스트페이지--------");
	}
	
	
	
	
}
