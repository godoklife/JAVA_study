package dto;

public class Room {
	private int roomnumber;
	private String roomname;
	private String roomip;
	private int mcount;	// ���� �� �ο���, DB���� ���� �ʿ䰡 �����Ƿ� DB���� ���� �ʵ�.
	
	public Room() {}

	public Room(int roomnumber, String roomname, String roomip, int mcount) {
		this.roomnumber = roomnumber;
		this.roomname = roomname;
		this.roomip = roomip;
		this.mcount = mcount;
	}

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getRoomip() {
		return roomip;
	}

	public void setRoomip(String roomip) {
		this.roomip = roomip;
	}

	public int getMcount() {
		return mcount;
	}

	public void setMcount(int mcount) {
		this.mcount = mcount;
	}
	
	
	
}
