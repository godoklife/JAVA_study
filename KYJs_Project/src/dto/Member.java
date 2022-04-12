package dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Member {	// ����Ÿ �𵨷� ���
	
	// �ʵ�
	private int mnum;			// ȸ����ȣ
	private String mid;			// ���̵�
	private String mpassword;	// ���
	private String memail;		// �̸���
	private String maddress;	// �ּ�
	private int mpoint;			// ����Ʈ
	private String msince;		// ������
	private String lastlogindate;
	
	// ������
	public Member() {}

	public Member(int mnum, String mid, String mpassword, String memail, String maddress, int mpoint, String msince, String lastlogindate ) {
		this.mnum = mnum;
		this.mid = mid;
		this.mpassword = mpassword;
		this.memail = memail;
		this.maddress = maddress;
		this.mpoint = mpoint;
		this.msince = msince;
		this.lastlogindate = lastlogindate;
	}
	
	// �޼���
	
	public static void sendmail(String �޴»���̸���, String ���) {
		// 1. ������ ����� ����
		String �����»���̸��� = "zunesd2@naver.com";
		String �����»���̸��Ϻ�й�ȣ = "rladydwns1";
		
		// 2. ȣ��Ʈ ����
		Properties properties = new Properties();	// �÷��� �����ӿ�ũ
		properties.put("mail.smtp.host", "smtp.naver.com");	// ȣ��Ʈ �ּ�
		properties.put("mail.smtp.port", 587);	// ȣ��Ʈ ��Ʈ��ȣ
		properties.put("mail.smtp.auth", "true");	// �𳻴� ��� �̸��� ����
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		// 3. ���� ó�� [ session : javax.java.mail ��Ű�� ] 
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(�����»���̸���, �����»���̸��Ϻ�й�ȣ);
		}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(�����»���̸���));	// ������ ��� �̸���
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(�޴»���̸���));
			// ����
			message.setSubject("ȸ������ �н����� ã��");
			message.setText("ȸ������ ��й�ȣ : "+���);
			// ����
			Transport.send(message);
		} catch (Exception e) {System.out.println("�̸��� �߼� ���� �߻�"+e);}
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

	public String getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	
	
}
