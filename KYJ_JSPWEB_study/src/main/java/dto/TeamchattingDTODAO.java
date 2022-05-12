package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.chatting.teamchatting;

public class TeamchattingDTODAO {
	private String nickname;
	private String content;
	private String datetime;
	private String ip;
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static TeamchattingDTODAO instance = new TeamchattingDTODAO();
	
	public TeamchattingDTODAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb?serverTimezone=UTC", "root", "1234");
		} catch (Exception e) {System.out.println("teamchatting_dao_exception : "+e);}
	}
///////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public TeamchattingDTODAO(String nickname, String content, String datetime, String ip) {
		super();
		this.nickname = nickname;
		this.content = content;
		this.datetime = datetime;
		this.ip = ip;
	}
	
	public TeamchattingDTODAO(String nickname, String content, String datetime) {
		super();
		this.nickname = nickname;
		this.content = content;
		this.datetime = datetime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

///////////////////////////////////////////////////////////////////////////////////////////	
	
	
	public boolean savechat(String nickname, String content, String ip) {
		
		String sql;
		if(ip==null||ip.equals("")) {
			 sql = "insert into teamchatting(nickname, content) values "
			 		+ "('"+nickname+"','"+content+"')";
		}else {
			sql = "insert into teamchatting(nickname, content, ipaddress) values "
					+ "('"+nickname+"','"+content+"','"+ip+"')";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("Teamchatting.java_savechat_exception : "+e);}
		return false;
	}
	
	// 인수로 startrow, listsize 가져오기 : sql에 저장된 채팅 짤라서 가져오는거
	public ArrayList<TeamchattingDTODAO> loadchat() {
		String sql;
		ArrayList<TeamchattingDTODAO> result = new ArrayList<>();
//		sql = "select * from savechat limit "+startrow+", "+listsize;
		sql = "select * from teamchatting";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				TeamchattingDTODAO tmp = new TeamchattingDTODAO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				result.add(tmp);
				tmp.toString();
			}return result;
		} catch (Exception e) {System.out.println("Teamchatting.java_loadchat_exception : "+e);}
		return null;
	}
	
	public int countchatlist() {	// 개수 변화가 있는지 체크할때 쓰는 용도
		
		String sql = "select count(*) from teamchatting";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {System.out.println("Teamchatting.java_countchatlist_exception : "+e);}
		return 0;
	}

}
