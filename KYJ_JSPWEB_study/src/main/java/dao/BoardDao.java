package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dto.Board;

public class BoardDao extends Dao{
	
	public static BoardDao instance = new BoardDao();
	
	public BoardDao() {
		super();
	}
	
	// 1. 글쓰기 메서드
	public boolean write(Board board) {
		String sql = "insert into board(btitle, bcontent, mno, bfile) values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setInt(3, board.getMno());
			ps.setString(4, board.getBfile());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_boardwrite_exception : "+e);}
		return false;
	}
	// 2. 글삭제 메서드
	public boolean delete(int bno) { 
		String sql = "delete from board where bno="+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_delete_exception : "+e);}
		return false;
	}
	// 3. 글수정 메서드
	public boolean update(Board board) {
		String sql = "update board set btitle=?, bcontent=?, bfile=? where bno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getBcontent());
			ps.setString(3, board.getBfile());
			ps.setInt(4, board.getBno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_update_exception : "+e);}
		return false;
	}
	
	// 4. 모든 게시물 출력 메서드	[ 추후 추가 기능 ->> 검색 : 조건 ]
		public ArrayList<Board> getboardlist() {
			ArrayList<Board> boardlist = new ArrayList<>();
			String sql = "select * from board order by bno desc";
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sdfToday = sdf.format(today);
			
			System.out.println(sdfToday);
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					String tmpday1 = rs.getString(6).split(" ")[0];
					String tmpday2 = rs.getString(6).split(" ")[1];
					if(tmpday1 != null && tmpday1.equals(sdfToday)) {
						Board tmp = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), tmpday2, rs.getString(7), null);
						boardlist.add(tmp);
					}else if(tmpday1 != null && !(tmpday1.equals(tmpday2))){
						Board tmp = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), tmpday1, rs.getString(7), null);
						boardlist.add(tmp);
					}
				}
				return boardlist;
			} catch (Exception e) {System.out.println("BoardDao_getboardlist_exception : "+e);}
			return null;
		}
	// 5. 개별 게시물 출력 메서드
	public Board getboard() {
		return null;
	}
	// 6. 게시물 조회수 증가 메서드
	public boolean increaseview(int bno) {
		return false;
	}

	// 7. 덧글 작성 메서드
	public boolean replywrite() {
		return false;
	}
	// 8. 덧글 출력 메서드	[ 인수 : 없음 ]
	public boolean replylist() {
		return false;
	}
	// 9. 덧글 수정 메서드	[ 인수 : 수정할 덧글 번호 ]
	public boolean replyupdate() {
		return false;
	}
	// 10. 덧글 삭제 메서드	[ 인수 : 삭제할 덧글 번호 ] 
	public boolean replydelete() {
		return false;
	}
	
	
	
	
	
	
	// 모든 게시글 출력 메서드에 mid를 이너조인으로 곁들인
	public ArrayList<Board> getboardlist2(){
		ArrayList<Board> boardlist = new ArrayList<>();
		String sql = "select board.*, member.mid from board inner join member on board.mno where board.mno=member.mno order by bno desc";
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdfToday = sdf.format(today);
		
		System.out.println(sdfToday);
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String tmpday1 = rs.getString(6).split(" ")[0];
				String tmpday2 = rs.getString(6).split(" ")[1];
				if(tmpday1 != null && tmpday1.equals(sdfToday)) {
					Board tmp = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), tmpday2, rs.getString(7), rs.getString(8));
					boardlist.add(tmp);
				}else if(tmpday1 != null && !(tmpday1.equals(tmpday2))){
					Board tmp = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), tmpday1, rs.getString(7), rs.getString(8));
					boardlist.add(tmp);
				}
			}
			return boardlist;
		} catch (Exception e) {System.out.println("BoardDao_getboardlist_exception : "+e);}
		return null;
	}
	
	
	
	
	
	
	
}
