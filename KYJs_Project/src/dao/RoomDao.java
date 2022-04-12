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

	private Connection con;			// DB연동에 사용되는 클래스
	private PreparedStatement ps;	// 얀결된 DB 내 SQL을 조작할 때 사용함.
	private ResultSet rs;			// 결과물 조작할 때 사용하는 인터페이스
	
	public static RoomDao roomDao = new RoomDao();	// DB연동할 때 사용하려고 자기자신을 정적화 선언
	
	public RoomDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://cirrus.cpfogy2aejex.ap-northeast-2.rds.amazonaws.com:3306/javafx?serverTime=UTC", "root", "rladydwns1");
		} catch (Exception e) {System.out.println("RoomDao DB연동 예외 발생 : "+ e);}
	}
	
	// 1. 방 저장 메서드
	public boolean roomadd( Room room) {
		try {
			String sql = "insert into room(roomname,roomip) values(?,?)";
				// 테이블에 레코드를 추가 하는 문법. SQL마다 문법은 조금씩 다르다.
			ps = con.prepareStatement(sql);
			ps.setString(1, room.getRoomname());
			ps.setString(2, room.getRoomip());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("RoomDao roomadd Exception : "+e);}
		return false;
	}
	
	// 2. 방 번호 호출 메서드 [ 방 번호 = 포트번호 동일함 ]
	public int getroomnum() {	// 가장 최근에 등록된 방의 번호 가져오기.
									// 포트번호가 순차적으로 오르게 설계했으므로 가장 큰 값이 가장 최근값임
										// max(roomnumber) : roomnumber 컬럼의 최대값 출력
		try {
			String sql = "select max(roomnumber) from room";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next());
				return rs.getInt(1);	// 가장 큰(=최근에 등록된) 방 번호를 반환.
		} catch (Exception e) {System.out.println("RoomDao getroomnum Exception : "+e);}
		return 0;
	}
	
	// 3. 모든 방 호출 메서드 [ tableview에 넣을거라 ObservableList 써야 함. ]
	public ObservableList<Room> roomlist () {
		ObservableList<Room> roomlist = FXCollections.observableArrayList();
		
		try {
			String sql = "select * from room order by roomnumber desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// rs = Resultset 인터페이스 객체 : select의 결과 가져오기.
				// resultset의 초기값은 null
				// rs.next() : select 결과의 레코드 1개씩 끝날때까지 가져오기
			while(rs.next()) {
				Room room = new Room(rs.getInt(1), rs.getString(2), rs.getString(3), 0);
				roomlist.add(room);
			}
			return roomlist;
			
		} catch (Exception e) {System.out.println("roomlist method exception : "+e);}
		return null;
	}
	
	// 4. 채팅방 접속 명단 추가
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
	
	// 5. 채팅방에 접속된 모든 명단 호출
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
	
	// 6. 접속 명단에서 삭제
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
	
	// 7. 채팅방 삭제 [ 조건 : 해당 채팅방에 접속 명단이 0 이라면! ] 
	public boolean roomdelete(int roomnumber) {
		try {
			String sql = "select * from roomlive where roomnumber = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomnumber);
			rs = ps.executeQuery();
			if(rs.next()) {	// 결과가 하나라도 있으면 종료
				return false;
			}else {	// 결과가 없으면 삭제쿼리문 날리기
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