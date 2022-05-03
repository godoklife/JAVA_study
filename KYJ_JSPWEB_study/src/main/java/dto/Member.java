package dto;

public class Member {
	
	
	
	
	@Override	
		// 디버깅용 메서드. MemberDao의 회원가입 메서드에서 println 할때 필드 내 모든 문자열 출력.
		// 원래 toString은 메모리 주소를 반환하나, 객체 내 문자열을 출력하도록 Override함.
		// toString은 수퍼클래스 object로부터 상속받은 메서드.
	public String toString() {
		return "Member [mno=" + mno + ", mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", mphone="
				+ mphone + ", memail=" + memail + ", maddress=" + maddress + ", mpoint=" + mpoint + ", mdate=" + mdate
				+ "]";
	}

	private int mno;			// pk
	private String mid;
	private String mpassword;
	private String mname;
	private String mphone;
	private String memail;
	private String maddress;
	private int mpoint;
	private String mdate;		// 가입 yyyy-MM-dd

	
	public Member() {}
	
	public Member(int mno, String mid, String mpassword, String mname, String mphone, String memail, String maddress,
			int mpoint, String mdate) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
		this.maddress = maddress;
		this.mpoint = mpoint;
		this.mdate = mdate;
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

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMemail() {
		return memail;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	
}