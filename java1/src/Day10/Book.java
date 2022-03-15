package Day10;

public class Book {
	// 1. 필스
	private String bookname, writer;
	
	// 2. 생성자
	public Book() {	// 
	}

	public Book(String bookname, String writer) {	// 풀 생성자
		super();
		this.bookname = bookname;
		this.writer = writer;
	}
	
	// 3. 메서드
	
	
	
	
	
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
