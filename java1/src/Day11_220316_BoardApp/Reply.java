package Day11_220316_BoardApp;

public class Reply {
	// 1. 필드
	private String content;
	private String password;
	private String writer;
	private String date;
	
	// 2. 생성자
		// 1. 깡통생성자
	public Reply() {
	}
		// 2. 풀 생성자
	public Reply(String content, String password, String writer, String date) {
		this.content = content;
		this.password = password;
		this.writer = writer;
		this.date = date;
	}
		// 3. 덧글 달때 쓸 생성자 : 내용, 비번, 덧글쓴이
	public Reply(String content, String password, String writer) {
		this.content = content;
		this.password = password;
		this.writer = writer;
	}
	
	// 3. 메서드
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	
}
