package dto;

public class Roomlive {
	private int livenum;
	private int roomnumber;
	private String mid;
	
	public Roomlive() {
		// TODO Auto-generated constructor stub
	}
	
	public Roomlive(int livenum, int roomnumber, String mid) {
		this.livenum = livenum;
		this.roomnumber = roomnumber;
		this.mid = mid;
	}

	public int getLivenum() {
		return livenum;
	}

	public void setLivenum(int livenum) {
		this.livenum = livenum;
	}

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
}
