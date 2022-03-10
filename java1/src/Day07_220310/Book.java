/*
 * Day07_05_bookApp
 * 
 * ���� ���� Ŭ����
 * 
 */

package Day07_220310;

public class Book {

	// 1. �ʵ�
	String ISBN;		// ISBN
	String bname;		// å �̸�
	String bwriter;		// �۰�
	boolean brental;	// ���� �뿩 ����
	String mid;			// �뿩�� ID
	
	// 2. ������
		// 1. �� ������[�⺻������] : �ż��� ȣ���, ctrl + space_bar(����Ű)
	public Book() {	}
		// 2. Ǯ ������ [ ��� �ʵ带 �Է¹޴� ������ ] : �������
	public Book(String iSBN, String bname, String bwriter, boolean brental, String mid) {
		ISBN = iSBN;
		this.bname = bname;
		this.bwriter = bwriter;
		this.brental = brental;
		this.mid = mid;
	}
	
	// 3. �޼���
		// 1. �����˻�
	void �����˻�() {
		System.out.println("--------�����˻� ������--------");
		System.out.print("�˻��Ͻ� å �̸��� �Է��ϼ��� : ");
		String bookname = Day07_05_bookApp.scanner.next();
		
		
	}
		// 2. �������
	void �������() {
		System.out.println("--------������� �׽�Ʈ������--------");
		
	}
		// 3. �����뿩
	void �����뿩() {
		System.out.println("--------�����뿩 �׽�Ʈ������--------");
	}
		// 4. �����ݳ�
	void �����ݳ�() {
		System.out.println("--------�����ݳ� �׽�Ʈ������--------");
	}
	
		// 5. �������
	void �������() {
		System.out.println("--------������� ������--------");
		System.out.println("ISBN : ");
		String ISBN = Day07_05_bookApp.scanner.next();
		System.out.println("������ : ");
		String bname = Day07_05_bookApp.scanner.next();
		System.out.println("�۰� : ");
		String bwriter = Day07_05_bookApp.scanner.next();
		
			// * �ߺ�üũ
		for(Book temp : Day07_05_bookApp.books) {
			if(temp!=null && temp.ISBN.equals(ISBN)) {
				System.out.println("�˸�) �̹� ��ϵ� å �Դϴ�.");
				return;	// å ��� ����
			}
		}
		
		// 2. ��üȭ ���Ѽ�	 [ ���� �뿩 = T/F
		Book book = new Book(ISBN, bname, bwriter, true, null);
		// 3. �迭�� �븳��Ű��
		int i=0;	// �ε����� ī��Ʈ
		for(Book temp : Day07_05_bookApp.books) {
			if(temp==null) {
				Day07_05_bookApp.books[i]=book;
			}
			i++;
		}
		
		
	}
		// 6. ��������
	void ��������() {
		System.out.println("--------�������� �׽�Ʈ������--------");
	}
	
	
	
	
}
