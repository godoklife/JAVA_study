package Day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Day10_05_��������_����Ʈ���� {
	public static void main(String[] args) {
		
		// 1. ����Ʈ [��ü] ����
		ArrayList<Book> booklist = new ArrayList<>();
	//	����Ʈ Ŭ����<��������> ����Ʈ�� = �޸��Ҵ� ������<>();
		// <Ŭ����> : �ش� Ŭ������ ���� ��ü�� ����Ʈ�� ����
		// ���̴� ���� [ �⺻ : 10 ]
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. ��� | 2. ��� | 3. ���� | 4. ����");
			int ch= scanner.nextInt();
			if(ch==1) {
				// 1. �Է¹ޱ�
				System.out.print("������ : ");
				String bookname = scanner.next();
				System.out.print("���ڸ� : ");
				String writer = scanner.next();
				
				// 2. ��üȭ [ �������� ������ -> 1�� ��ü ]
				Book book = new Book(bookname, writer);
				booklist.add(book);	// �迭�� �޸� �˾Ƽ� �� �ڸ�(������ �ڸ�) ã�Ƽ� book ��ü�� ������.
				
				
				
			}else if(ch==2){
				// 1. ����Ʈ�� null ���� �� �ʿ� ���� �׳� ����ϸ� ��. ������� null�� ä���ִ°� �ƴϱ� ����.
				for(Book tmp : booklist) {
					System.out.println(tmp.getBookname()+"\t"+tmp.getWriter());
				}
				
			}else if(ch==3){
				// ����Ʈ�� �߰��� �ִ� �ε����� ���� ���� ��� �ڵ����� �����Ͱ� ���ܼ� �����.	
				// 1 2 3 4 5 -> 1 2 4 5 
				System.out.print("������ ������ : ");
				String deleteBookName = scanner.next();
				
				for(Book tmp : booklist) {
					if(tmp.getBookname().equals(deleteBookName)) {
						booklist.remove(tmp);
						break;
					}
				}
				
			}else if(ch==4){
				System.out.print("���� �� ������ : ");
				String modBook = scanner.next();
				
				for(Book tmp : booklist) {
					if(tmp.getBookname().equals(modBook)) {
						System.out.print("���� �� ���ڸ� :");
						String modWriter = scanner.next();
						tmp.setWriter(modWriter);
					}
				}
				
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			
		}	// while END
	}	// main END
}	// class END
