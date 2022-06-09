package dto;
public class Board {
	private int boardnumber;
	private String boardtitle;
	private String boardcontent;
	private String boardwriter;
	private String boarddatetime;
	private String boardwriterpassword;
	@Override
	public String toString() {
		return "Board [boardnumber=" + boardnumber + ", boardtitle=" + boardtitle + ", boardcontent=" + boardcontent
				+ ", boardwriter=" + boardwriter + ", boarddatetime=" + boarddatetime + ", boardwriterpassword="
				+ boardwriterpassword + "]";
	}
	public Board() {}
	public Board(int boardnumber, String boardtitle, String boardcontent, String boardwriter, String boarddatetime,
			String boardwriterpassword) {
		super();
		this.boardnumber = boardnumber;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.boardwriter = boardwriter;
		this.boarddatetime = boarddatetime;
		this.boardwriterpassword = boardwriterpassword;
	}
	public int getBoardnumber() {
		return boardnumber;
	}
	public void setBoardnumber(int boardnumber) {
		this.boardnumber = boardnumber;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getBoardcontent() {
		return boardcontent;
	}
	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}
	public String getBoardwriter() {
		return boardwriter;
	}
	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}
	public String getBoarddatetime() {
		return boarddatetime;
	}
	public void setBoarddatetime(String boarddatetime) {
		this.boarddatetime = boarddatetime;
	}
	public String getBoardwriterpassword() {
		return boardwriterpassword;
	}
	public void setBoardwriterpassword(String boardwriterpassword) {
		this.boardwriterpassword = boardwriterpassword;
	}
}
