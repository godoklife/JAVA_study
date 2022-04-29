package controller.dto;

public class Member {
	private int mnum;
	private String mid;
	private String mpassword;
	private String mname;
	
	public Member() {
	}

	public Member(int mnum, String mid, String mpassword, String mname) {
		this.mnum = mnum;
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	
	
	
}
