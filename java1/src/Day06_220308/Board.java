package Day06_220308;

public class Board {
	// * ���� Ŭ���� ����
	
	// 1. �ʵ�
	String title;
	String content;
	String writer;
	String password;
	
	// 2. ������ [ Ŭ���� �̸��� ������ �����ڸ� ]
		// ��Ŭ�������� ������ �ڵ������ϴ¹�
		// ������ ��Ŭ�� -> source -> ���ʷ���Ʈ ����Ʈ���� using fields
	
		// 1. �� ������
	Board(){}
		// 2. 1�� �ʵ带 �޴� ������
	Board(String title){
		this.title = title;
		// this.�ʵ�� => ���κ���(1. �ʵ� �� �ִ� ����)
		// * �ܺηκ��� ���� ������ ���ο� ����
	}
		// 3. 2�� �ʵ带 �޴� ������
	Board(String title, String content){
		this.title = title;
		this.content = content;
	}
		// 4. 3�� �ʵ带 �޴� ������
	Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
		// 5. 4�� �ʵ带 �޴� ������
	Board(String title, String content, String writer, String password) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
	}
	
	// 3. �޼���
	
}
