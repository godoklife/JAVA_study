package dto;

public class Product {
	
	private int pnum;			// pk
	private String pname;		// 판매 제목
	private String pimage;		// 이미지 url
	private String pcontent;	// 내용
	private String pcategory;	// 카테고리
	private int pprice;			// 가격
	private int pactivation;	// 1 : 판매중, 2 : 예약중, 3 : 판매완료
	private String pdate;		// 작성 날짜
	private int mnum;			// 작성자 fk
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pnum, String pname, String pimage, String pcontent, String pcategory, int pprice,
			int pactivation, String pdate, int mnum) {
		super();
		this.pnum = pnum;
		this.pname = pname;
		this.pimage = pimage;
		this.pcontent = pcontent;
		this.pcategory = pcategory;
		this.pprice = pprice;
		this.pactivation = pactivation;
		this.pdate = pdate;
		this.mnum = mnum;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public String getPcategory() {
		return pcategory;
	}

	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getPactivation() {
		return pactivation;
	}

	public void setPactivation(int pactivation) {
		this.pactivation = pactivation;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	
	
	
}
