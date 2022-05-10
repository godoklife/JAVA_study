package dto;

import dao.MemberDao;

public class Reply{
	private int rno;	// pk
	private String rcontent;
	private String rdate;
	private int rindex;
	private int bno;	// fk
	private int mno;	// fK
	private String mid;
	
	public Reply() {}
	
	public Reply(int rno, String rcontent, String rdate, int rindex, int bno, int mno, String mid) {
		this.rno = rno;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rindex = rindex;
		this.bno = bno;
		this.mno = mno;
		this.mid = MemberDao.instance.getmid(mno);
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getRindex() {
		return rindex;
	}

	public void setRindex(int rindex) {
		this.rindex = rindex;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	
	
}