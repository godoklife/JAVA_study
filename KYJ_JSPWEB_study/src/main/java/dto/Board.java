package dto;

public class Board {
	private int bno;	// pk
	private String btitle;
	private String bcontent;
	private int mno;
	private int bview;
	private String bdate;
	private String bfile;
	private String mid;	// 게시판 표시용, DB에는 저장 X
	
	public Board() {}
	
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", mno=" + mno + ", bview="
				+ bview + ", bdate=" + bdate + ", bfile=" + bfile + ", mid=" + mid + "]";
	}

	public Board(int bno, String btitle, String bcontent, int mno, int bview, String bdate, String bfile, String mid) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
		this.bview = bview;
		this.bdate = bdate;
		this.bfile = bfile;
		this.mid = mid;
	}
	
	public Board(int bno, String btitle, int bview, String bdate) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bview = bview;
		this.bdate = bdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

}