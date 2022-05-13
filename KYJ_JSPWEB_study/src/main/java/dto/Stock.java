package dto;

public class Stock {
	
	private int sno;	// pk
	private String scolor;
	private String ssize;
	private int samount;
	private String sfirstsubmitdate;
	private String slastmoddate;
	private int pno;	// fk
	
	@Override
	public String toString() {
		return "Stock [sno=" + sno + ", scolor=" + scolor + ", ssize=" + ssize + ", samount=" + samount
				+ ", sfirstsubmitdate=" + sfirstsubmitdate + ", slastmoddate=" + slastmoddate + ", pno=" + pno + "]";
	}

	public Stock() {
	}

	public Stock(int sno, String scolor, String ssize, int samount, String sfirstsubmitdate, String slastmoddate,
			int pno) {
		super();
		this.sno = sno;
		this.scolor = scolor;
		this.ssize = ssize;
		this.samount = samount;
		this.sfirstsubmitdate = sfirstsubmitdate;
		this.slastmoddate = slastmoddate;
		this.pno = pno;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getScolor() {
		return scolor;
	}

	public void setScolor(String scolor) {
		this.scolor = scolor;
	}

	public String getSsize() {
		return ssize;
	}

	public void setSsize(String ssize) {
		this.ssize = ssize;
	}

	public int getSamount() {
		return samount;
	}

	public void setSamount(int samount) {
		this.samount = samount;
	}

	public String getSfirstsubmitdate() {
		return sfirstsubmitdate;
	}

	public void setSfirstsubmitdate(String sfirstsubmitdate) {
		this.sfirstsubmitdate = sfirstsubmitdate;
	}

	public String getSlastmoddate() {
		return slastmoddate;
	}

	public void setSlastmoddate(String slastmoddate) {
		this.slastmoddate = slastmoddate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}
	
}
