package dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Member {	// 데이타 모델로 사용
	
	// 필드
	private int mnum;			// 회원번호
	private String mid;			// 아이디
	private String mpassword;	// 비번
	private String memail;		// 이메일
	private String maddress;	// 주소
	private int mpoint;			// 포인트
	private String msince;		// 가입일
	
	
	// 생성자
	public Member() {}

	public Member(int mnum, String mid, String mpassword, String memail, String maddress, int mpoint, String msince) {
		this.mnum = mnum;
		this.mid = mid;
		this.mpassword = mpassword;
		this.memail = memail;
		this.maddress = maddress;
		this.mpoint = mpoint;
		this.msince = msince;
	}
	
	// 메서드
	
	public static void sendmail(String 받는사람이메일, String 비번) {
		// 1. 보내는 사람의 정보
		String 보내는사람이메일 = "보낼이메일@naver.com";
		String 보내는사람이메일비밀번호 = "보낼이멜비번";
		
		// 2. 호스트 설정
		Properties properties = new Properties();	// 컬렉션 프레임워크
		properties.put("mail.smtp.host", "smtp.naver.com");	// 호스트 주소
		properties.put("mail.smtp.port", 587);	// 호스트 포트번호
		properties.put("mail.smtp.auth", "true");	// 모내는 사람 이메일 인증
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		// 3. 인증 처리 [ session : javax.java.mail 패키지 ] 
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(보내는사람이메일, 보내는사람이메일비밀번호);
		}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(보내는사람이메일));	// 보내는 사람 이메일
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(받는사람이메일));
			// 내용
			message.setSubject("회원님의 패스워드 찾기");
			message.setText("회원님의 비밀번호 : "+비번);
			// 전송
			Transport.send(message);
		} catch (Exception e) {System.out.println("이메일 발송 예외 발생"+e);}
	}
	
	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public String getMsince() {
		return msince;
	}

	public void setMsince(String msince) {
		this.msince = msince;
	}
	
}
