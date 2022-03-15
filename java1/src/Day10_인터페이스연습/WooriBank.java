package Day10_인터페이스연습;

public class WooriBank implements BankInterface{
	
	// 1. 필드
	private String userName, phoneNumber, accountPassword, accountNumber;

	// 2. 생성자
	public WooriBank() {
	}
	public WooriBank(String userName, String phoneNumber, String accountPassword) {
	super();
	this.userName = userName;
	this.phoneNumber = phoneNumber;
	this.accountPassword = accountPassword;
	}
	
	
	
	
	// 3. 메서드
	
	
	
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
	public boolean 계좌생성() {
		
		return false;
	}
	@Override
	public void 입금() {
	
	}
	@Override
	public void 출금() {
		
	}
	@Override
	public void 이체() {
		
	}
	@Override
	public void 계좌목록조회() {
		
	}
	@Override
	public void 게좌잔고조회() {
		
	}
}
