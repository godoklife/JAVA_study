/*
 * MVC �� �߿��� ���� ������ M, Model�̶�� �Ѵ�.
 * 
 */



package Day08_220311;

public class Ŭ�������迹�� {

	// ȸ��Ŭ������ �����Ѵٰ� �սô�.
	
	
	// 1. �ʵ� [ private ���±��� ]
	private String id;
	private String password;
	private String name;
	private String point;
	
	// 2. ������
		// ������� : ����(ctrl + space_bar), Ǯ ������(
		// 1. �ʵ� 0�� [ �� ������ ]
		// 2. �ʵ� 3�� [ Ư�� ������, ȸ�����Խ� ��� ���� ]
		// 3. �ʵ� 4�� [ Ǯ ������, ��� ȸ������ ȣ��� ��� ���� ] 
	
	public Ŭ�������迹��() {
		// TODO Auto-generated constructor stub
	}
	
	public Ŭ�������迹��(String id, String password, String name, String point) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.point = point;
	}

	// 3. �޼���
		// private �ʵ� ���� get or set �޼���
		// ��Ŭ�� - Source - Generate getter and setter
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	
	
	
	
}
