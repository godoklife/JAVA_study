package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Product;
import dto.Room;
import dto.Roomlive;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomDao {

	private Connection con;			// DB������ ���Ǵ� Ŭ����
	private PreparedStatement ps;	// ���� DB �� SQL�� ������ �� �����.
	private ResultSet rs;			// ����� ������ �� ����ϴ� �������̽�
	
	public static RoomDao roomDao = new RoomDao();	// DB������ �� ����Ϸ��� �ڱ��ڽ��� ����ȭ ����
	
	public RoomDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://cirrus.cpfogy2aejex.ap-northeast-2.rds.amazonaws.com:3306/javafx?serverTime=UTC", "root", "rladydwns1");
		} catch (Exception e) {System.out.println("RoomDao DB���� ���� �߻� : "+ e);}
	}
	
	// 1. �� ���� �޼���
	public boolean roomadd( Room room) {
		try {
			String sql = "insert into room(roomname,roomip) values(?,?)";
				// ���̺� ���ڵ带 �߰� �ϴ� ����. SQL���� ������ ���ݾ� �ٸ���.
			ps = con.prepareStatement(sql);
			ps.setString(1, room.getRoomname());
			ps.setString(2, room.getRoomip());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("RoomDao roomadd Exception : "+e);}
		return false;
	}
	
	// 2. �� ��ȣ ȣ�� �޼��� [ �� ��ȣ = ��Ʈ��ȣ ������ ]
	public int getroomnum() {	// ���� �ֱٿ� ��ϵ� ���� ��ȣ ��������.
									// ��Ʈ��ȣ�� ���������� ������ ���������Ƿ� ���� ū ���� ���� �ֱٰ���
										// max(roomnumber) : roomnumber �÷��� �ִ밪 ���
		try {
			String sql = "select max(roomnumber) from room";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next());
				return rs.getInt(1);	// ���� ū(=�ֱٿ� ��ϵ�) �� ��ȣ�� ��ȯ.
		} catch (Exception e) {System.out.println("RoomDao getroomnum Exception : "+e);}
		return 0;
	}
	
	// 3. ��� �� ȣ�� �޼��� [ tableview�� �����Ŷ� ObservableList ��� ��. ]
	public ObservableList<Room> roomlist () {
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		
		try {
			String sql = "select * from room order by roomnumber desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// rs = Resultset �������̽� ��ü : select�� ��� ��������.
				// resultset�� �ʱⰪ�� null
				// rs.next() : select ����� ���ڵ� 1���� ���������� ��������
			while(rs.next()) {
				Room room = new Room(rs.getInt(1), rs.getString(2), rs.getString(3), 0);
				roomlist.add(room);
			}
			return roomlist;
			
		} catch (Exception e) {System.out.println("roomlist method exception : "+e);}
		return null;
	}
	
	// 4. ä�ù� ���� ��� �߰�
	public boolean addroomlive(Roomlive roomlive) {
		try {
			String sql = "insert into roomlive(roomnumber,mid) values(?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomlive.getRoomnumber());
			ps.setString(2, roomlive.getMid());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("addroomlive exception : "+e);}
		return false;
	}
	
	// 5. ä�ù濡 ���ӵ� ��� ��� ȣ��
	public ArrayList<Roomlive> getroomlivelist(int roomnumber){
		ArrayList<Roomlive>getroomlivelist = new ArrayList<>();
		try {
			String sql = "select * from roomlive where roomnumber=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, roomnumber);
			rs = ps.executeQuery();
			while(rs.next()) {
				Roomlive roomlive = new Roomlive(rs.getInt(1), rs.getInt(2), rs.getString(3));
				getroomlivelist.add(roomlive);
			}
			return getroomlivelist;
			
		} catch (Exception e) {System.out.println("getroomlivelist exception : "+e);}
		return null;
	}
	
	// 6. ���� ��ܿ��� ����
	public boolean roomlivedelete(String mid) {
		try {
			String sql = "delete from roomlive where mid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("deleteroomlive exception : "+e);}
		return false;
	}
	
	// 7. ä�ù� ���� [ ���� : �ش� ä�ù濡 ���� ����� 0 �̶��! ] 
	public boolean roomdelete(int roomnumber) {
		try {
			String sql = "select * from roomlive where roomnumber = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomnumber);
			rs = ps.executeQuery();
			if(rs.next()) {	// ����� �ϳ��� ������ ����
				return false;
			}else {	// ����� ������ ���������� ������
				sql = "delete from room where roomnumber = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, roomnumber);
				ps.executeUpdate();
				return true;
			}
		} catch (Exception e) {System.out.println("roomdelete exception : "+e);}
		return false;
	}
	
}