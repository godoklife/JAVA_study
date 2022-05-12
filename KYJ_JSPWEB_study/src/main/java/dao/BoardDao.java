package dao;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dto.Board;
import dto.Reply;

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
	public boolean modify(Board board) {
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
	
	// 4. 모든 게시물 출력 메서드		->> 하단의 11번 메서드 사용중.

	
	// 5. 개별 게시물 출력 메서드_이너조인으로 아이디 따오기
		public Board getboard2(int bno) {
			String sql = "select board.*, member.mid from board inner join member on board.mno where board.mno=member.mno and board.bno="+bno;
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8));
					return board;
				}else return null;
			} catch (Exception e) {System.out.println("BoardDao_getboard_exception : "+e);}
			return null;
		}
	
	
	
	// 6. 게시물 조회수 증가 메서드
	public boolean increaseview(int bno) {
		String sql = "update board set bview=bview+1 where bno="+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_increaseview_exception : "+e);}
		return false;
	}

	// 7. 덧글 작성 메서드
	public boolean replywrite(Reply reply) {
		String sql = "insert into reply(rcontent, rindex, bno, mno) values(?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setInt(2, reply.getRindex());
			ps.setInt(3, reply.getBno());
			ps.setInt(4, reply.getMno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_replywrite_exception : "+e);}
		return false;
	}
	// 8. 덧글 출력 메서드	[ 인수 : 현재 게시물 번호 ]
	public ArrayList<Reply> replylist(int bno) {
		String sql =  "select * from reply where bno="+bno+" and rindex=0";
			// rindex=0 : 대댓글 말고 걍 덧글만 출력하겠단 뜻
		ArrayList<Reply> result = new ArrayList<Reply>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), null);
				result.add(reply);
			}return result;
		} catch (Exception e) {System.out.println("BoardDao_replylist_exception : "+e);}
		return null;
	}
	
	// 8-2 대댓글 출력 메서드
	public ArrayList<Reply> rereplylist(int bno, int rno) {
		String sql =  "select * from reply where bno="+bno+" and rindex="+rno;
		ArrayList<Reply> result = new ArrayList<Reply>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), null);
				result.add(reply);
			}return result;
		} catch (Exception e) {System.out.println("BoardDao_replylist_exception : "+e);}
		return null;
	}
	
	// 9. 덧글 수정 메서드	[ 인수 : 수정할 덧글 번호 ]
	public boolean replymodify(String rcontent, int rno) {
		String sql = "update reply set rcontent='"+rcontent+"' where rno="+rno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_replymodify_exception : "+e);}
		return false;
	}
	// 10. 덧글 삭제 메서드	[ 인수 : 삭제할 덧글 번호 ] 
	public boolean replydelete(int rno) {
		String sql = "delete from reply where rno="+rno+" or rindex="+rno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_replydelete_exception : "+e);}
		return false;
	}
	
	// 11-1 게시물 총 개수 출력 메서드
	public int gettotalrow(String key, String keyword) {
		String sql;
		if((key==null||key.equals("")) && (keyword==null||keyword.equals(""))) {	// 검색이 없을 경우
			sql = "select count(*) from board";
		}else {	// 검색이 있을 경우
			sql = "select count(*) from board where "+key+" like '%"+keyword+"%'";
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return  rs.getInt(1);
			}else return 0;
		} catch (Exception e) {System.out.println("BoardDao_gettotalrow_exception : "+e);}
		return 0;
	}
	
	// 11. 모든 게시글 출력 메서드에 mid를 이너조인으로 곁들인
	public ArrayList<Board> getboardlist2(int mno, int startrow, int listsize, String key, String keyword){
		ArrayList<Board> boardlist = new ArrayList<>();
		String sql;
		boolean flag=false;	// mywrite.jsp의 내 게시물만 꺼내오는 쿼리문을 셋팅했을 경우 true 전환
		if(mno==-1) {
			if(keyword==null || keyword.equals("")) {	// 모든 게시물 꺼내오는 경우
				sql = "select board.*, member.mid from board inner join member on board.mno "
						+ "where board.mno=member.mno order by bno desc limit "+startrow+"," +listsize;
			}else{			// 검색한 조건에 따라 게시물을 꺼내오는 경우
				sql = "select board.*, member.mid from board inner join member on board.mno "
						+ "where board.mno=member.mno and board."+key+" like '%"+keyword+"%'"
								+ "order by bno desc limit "+startrow+"," +listsize;
			}
		}else if(mno>0){	// mywrite.jsp의 내 게시물만 꺼내오는 쿼리문
			sql = "select * from board where mno="+mno+" order by bdate desc";
			flag=true;
		}else {
			return null;
		}
			// bno가 작은순으로 정렬, board.mno = member.mno 기준으로 검색, member테이블에서 board.mno의 FK를 이너조인, board.*과 member.mid를 반환
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdfToday = sdf.format(today);
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String tmpday1 = rs.getString(6).split(" ")[0];
				String tmpday2 = rs.getString(6).split(" ")[1];
				if(flag) {
					Board mywrite=new Board(rs.getInt(1), rs.getString(2), rs.getInt(5), rs.getString(6));
					boardlist.add(mywrite);
				}
				else if(tmpday1 != null && tmpday1.equals(sdfToday)) {
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
	

	
	// 14. 게시물 내 첨부파일 (SQL 내 파일명만 null로 변경) 삭제 메서드
	public boolean deletefile(int bno) {
		String sql = "update board set bfile=null where bno="+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_deletefile_exception : "+e);}
				
		return false;
	}
	
	
	
	
	
}
