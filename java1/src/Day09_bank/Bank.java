package Day09_bank;

public class Bank {
	
	// 1. 필드
	private String anumber;		// 계좌번호 [ 중복 X ]
	private String password;	// 비밀번호
	private String name;		// 계좌주
	private int amoney;	// 예금액
	
	// 2. 생성자
		// 1. 빈 생성자
	public Bank() {	// 메서드 호출용 생성자
	}
		// 2. 풀 생성자
	public Bank(String anumber, String password, String name) {
		this.anumber = anumber;
		this.password = password;
		this.name = name;
	}
		// 3. 용도에 따라 만들것
	public String getAnumber() {
		return anumber;
	}
	public void setAnumber(String anumber) {
		this.anumber = anumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmoney() {
		return amoney;
	}
	public void setAmoney(int amoney) {
		this.amoney = amoney;
	}
	
	// 3. 메서드
	// 7. get, set 메서드 [ 필드가 private인 경우 ]
	
	
		// 1. 계좌 생성 메서드
		// 2. 입금 메서드
		// 3. 출금
		// 4. 이체
		// 5. 내계좌목록
		// 6. 대출
		// 7. get, set 메서드 [ 필드가 private인 경우 ]
}
