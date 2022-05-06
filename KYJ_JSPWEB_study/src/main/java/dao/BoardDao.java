package dao;

import java.util.ArrayList;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
