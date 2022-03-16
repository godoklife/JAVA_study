package Day11_220316_BoardApp;

import java.util.ArrayList;

public class Board {
	// 1. 필드
	private String title;
	private String content;
	private String password;
	private String writer;
	private int viewcount;
	private String date;
	private ArrayList<Reply> replylist = new ArrayList<>();
	
	// 2. 생성자
		// 1. 깡통 생성자
	public Board() {
	}
		// 2. 게시물 등록시 사용되는 생성자 = 사용자가 입력할 데이터 : 제목, 글쓴이, 비번, 내용
	public Board(String title, String content, String password, String writer) {
		this.title = title;
		this.content = content;
		this.password = password;
		this.writer = writer;
	}
		// 3. 풀 생성자	= 어디다 쓸지 모르지만 일단 만들어두는것
	public Board(String title, String content, String password, String writer, int viewcount, String date,
			ArrayList<Reply> replylist) {
		this.title = title;
		this.content = content;
		this.password = password;
		this.writer = writer;
		this.viewcount = viewcount;
		this.date = date;
		this.replylist = replylist;
	}
	
	// 3. 메서드	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
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
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<Reply> getReplylist() {
		return replylist;
	}
	public void setReplylist(ArrayList<Reply> replylist) {
		this.replylist = replylist;
	}
	
	
}
