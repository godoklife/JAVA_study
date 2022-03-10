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
		System.out.println("--------������� ������--------");
		System.out.print("ISBN\t������\t�۰�\t�뿩���ɿ���\n");
		for(Book temp : Day07_05_bookApp.books) {
			if(temp != null) {
				if(temp.brental)	// �뿩 ������ å (T) ���
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t�뿩����");
				else				// �Ұ��� å(F) ���
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t�뿩�Ұ�");
			}
		}
	}	// ������� END
		// 3. �����뿩
	void �����뿩(String loginid) {	// book.�����뿩(loginID); ���� ���� ����� ���̵� �Է¹���.
		System.out.println("--------�����뿩 ������--------");
		System.out.print("ISBN\t������\t�۰�\t�뿩���ɿ���\n");
		for(Book temp : Day07_05_bookApp.books) {
			if(temp != null) {
				if(temp.brental)	// �뿩 ������ å (T) ���
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t�뿩����");
				else				// �Ұ��� å(F) ���
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t�뿩�Ұ�");
			}
		}
		System.out.println("--------------------------");
		System.out.print("�뿩�Ͻ� å ISBN�� �Է��ϼ��� : ");
		String isbn = Day07_05_bookApp.scanner.next();
		
		for(Book temp : Day07_05_bookApp.books) {
			if(temp!=null && temp.ISBN.equals(isbn) && temp.brental) {
				System.out.println("�����Ͻ� "+temp.bname+"�� �뿩�߽��ϴ�.");
				temp.brental=false;
				temp.mid = loginid;
				return;
			}
			else if(temp!=null && temp.ISBN.equals(isbn) && !(temp.brental)) {
				System.out.println("�����Ͻ� "+temp.bname+" �뿩���Դϴ�.");
				return;
			}
		}
		
	}	// �����뿩 END
	
	///////////////////////////////////////////////////
		// 4. �����ݳ�
	void �����ݳ�(String loginid) {
		System.out.println("--------�����ݳ� �׽�Ʈ������--------");
		System.out.print("ISBN\t������\t�۰�\t�뿩���ɿ���\n");
		for(Book temp : Day07_05_bookApp.books) {
			if(temp != null && temp.mid.equals(loginid)) {
					// ������ �����ϸ鼭 �뿩ID�� ���� �α��ε� ID�� ���ٸ�
				if(temp.brental)	// �뿩 ������ å (T) ���
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t�뿩����");
				else				// �Ұ��� å(F) ���
					System.out.println(temp.ISBN+"\t"+temp.bname+"\t"+temp.bwriter+"\t�뿩�Ұ�");
			}
		}
	}
	///////////////////////////////////////////////////
	// �������
	
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
			// void ������� ���� �Է¹��� ������ public Book Ǯ �����ڿ� ����.
			// true, null�� ���� �������� �ʾƼ� �����������ذ�.
		// 3. �迭�� �븳��Ű��
		int i=0;	// �ε����� ī��Ʈ
		for(Book temp : Day07_05_bookApp.books) {
			if(temp==null) {
				Day07_05_bookApp.books[i]=book;
				return;	// ��� �����ϸ� ����!
			}
			i++;
		}
		
	}
		// 6. ��������
	void ��������() {
		System.out.println("--------�������� �׽�Ʈ������--------");
	}
	
	
	
	
}
