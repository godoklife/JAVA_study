package Day10;

public class Book {
	// 1. �ʽ�
	private String bookname, writer;
	
	// 2. ������
	public Book() {	// 
	}

	public Book(String bookname, String writer) {	// Ǯ ������
		super();
		this.bookname = bookname;
		this.writer = writer;
	}
	
	// 3. �޼���
	
	
	
	
	
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
