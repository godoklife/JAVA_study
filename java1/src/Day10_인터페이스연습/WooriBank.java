package Day10_�������̽�����;

public class WooriBank implements BankInterface{
	
	// 1. �ʵ�
	private String userName, phoneNumber, accountPassword, accountNumber;

	// 2. ������
	public WooriBank() {
	}
	public WooriBank(String userName, String phoneNumber, String accountPassword) {
	super();
	this.userName = userName;
	this.phoneNumber = phoneNumber;
	this.accountPassword = accountPassword;
	}
	
	
	
	
	// 3. �޼���
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	@Override
	public boolean ���»���() {
		
		return false;
	}
	@Override
	public void �Ա�() {
	
	}
	@Override
	public void ���() {
		
	}
	@Override
	public void ��ü() {
		
	}
	@Override
	public void ���¸����ȸ() {
		
	}
	@Override
	public void �����ܰ���ȸ() {
		
	}
}
