package crawling.dto;

public class Coupangcart {
	
	private int cartno;	// pk
	private String title;
	private String url;
	private String discountrate;
	private int gno;	// not fk
	
	public String toString() {
		return "Coupangcart [cartno=" + cartno + ", title=" + title + ", url=" + url + ", discountrate=" + discountrate
				+ ", gno=" + gno + "]";
	}
	
	public Coupangcart() {}
	
	public Coupangcart(int cartno, String title, String url, String discountrate, int gno) {
		super();
		this.cartno = cartno;
		this.title = title;
		this.url = url;
		this.discountrate = discountrate;
		this.gno = gno;
	}

	public int getCartno() {
		return cartno;
	}

	public void setCartno(int cartno) {
		this.cartno = cartno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDiscountrate() {
		return discountrate;
	}

	public void setDiscountrate(String discountrate) {
		this.discountrate = discountrate;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}
	
}
