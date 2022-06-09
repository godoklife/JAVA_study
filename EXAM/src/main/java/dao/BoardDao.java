package dao;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Board;

public class BoardDao extends Dao {
	
	public static BoardDao instance = new BoardDao();
	
	public BoardDao() {
		super();
	}
	
	// 1. 글 쓰기 메서드
	public boolean create(Board board) {
		String sql = "insert into board(boardtitle, boardcontent, boardwriter,"
				+ " boardwriterpassword) values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBoardtitle());
			ps.setString(2, board.getBoardcontent());
			ps.setString(3, board.getBoardwriter());
			ps.setString(4, board.getBoardwriterpassword());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_create_Exception : "+e);}
		return false;
	}
	// 2. 글 삭제 메서드
	public boolean delete(int boardnumber) {
		String sql = "delete from board where boardnumber=?";
			try {
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {System.out.println(e);}	
		return false;
	}
	// 3. 글 수정 메서드
	public boolean update(Board board) {
		String sql = "update board set boardtitle=?, boardcontent=? where bno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBoardtitle());
			ps.setString(2, board.getBoardcontent());
			ps.setInt(3, board.getBoardnumber());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 4. 모든 글 호출 메서드
	public JSONArray getList(String data) {
		// 나중에 검색기능 추가하면 인수 사용할것
		JSONArray array = new JSONArray();
			String sql = "select * from board";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("boardnumber", rs.getInt(1));
				object.put("boardtitle", rs.getString(2));
				object.put("boardcontent", rs.getString(3));
				object.put("boardwriter", rs.getString(4));
				object.put("boarddatetime", rs.getString(5));
				object.put("boardwriterpassword", rs.getString(6));
				array.put(object);
			}
			return array;
		} catch (Exception e) {System.out.println("BoardDao_allArticle_Exception : "+e);}
		return null;
	}
	
	// 5. 글 보기 메서드
	public JSONObject getBoard(int boardnumber) {
		
		String sql = "select * from board where boardnumber = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardnumber);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("boardnumber", rs.getInt(1));
				object.put("boardtitle", rs.getString(2));
				object.put("boardcontent", rs.getString(3));
				object.put("boardwriter", rs.getString(4));
				object.put("boarddatetime", rs.getString(5));
				object.put("boardwriterpassword", rs.getString(6));
				object.toString();
				return object;
			}
		} catch (Exception e) {System.out.println("BoardDao_getBoard_Exception : "+e);}
		return null;
	}
	
	// reserved
			
}
