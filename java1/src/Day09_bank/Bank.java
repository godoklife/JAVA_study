package Day09_bank;

public class Bank {
	
	// 1. �ʵ�
	private String anumber;		// ���¹�ȣ [ �ߺ� X ]
	private String password;	// ��й�ȣ
	private String name;		// ������
	private int amoney;	// ���ݾ�
	
	// 2. ������
		// 1. �� ������
	public Bank() {	// �޼��� ȣ��� ������
	}
		// 2. Ǯ ������
	public Bank(String anumber, String password, String name) {
		this.anumber = anumber;
		this.password = password;
		this.name = name;
	}
		// 3. �뵵�� ���� �����
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
	
	// 3. �޼���
	// 7. get, set �޼��� [ �ʵ尡 private�� ��� ]
	
	
		// 1. ���� ���� �޼���
		// 2. �Ա� �޼���
		// 3. ���
		// 4. ��ü
		// 5. �����¸��
		// 6. ����
		// 7. get, set �޼��� [ �ʵ尡 private�� ��� ]
}
