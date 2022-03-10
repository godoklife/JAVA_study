package Day07_220310;

import java.util.Scanner;

public class Day07_05_bookApp {	// class START
	
	// main �ۿ� ������ �����ϴ� ����??? ��� �޼��忡�� ����ϱ� ����.
		// �������� : �߰�ȣ { ���� ���� } ������ ����� ����, ��ȣ ���� ������.
			// ���� �ٸ� { } �߰�ȣ ������ ���� -> ���� ����
		// static : ���α׷� ����ñ��� �޸� �Ҵ�.
			// ���α׷� ���۽� �޸� �Ҵ�, ����� �޸� �ʱ�ȭ.
			// ���α׷� ���������� ��� ���� ���Ǵ� ��� ���.(ex. Scanner)
			// static�� �޸𸮸� �켱�Ҵ� �ϴµ�, static ���� �޸�(�޼���, �ʵ�)�� ���� ����.
	static Scanner scanner = new Scanner(System.in);
	static Member[] members = new Member[100];	// ��� class(member)���� ����ϴ� ȸ�� �迭.
	static Book[] books = new Book[1000];
	
	
	// 0. �ڵ带 �о��ִ� ���� �޼��� [ thread ]
	public static void main(String[] args) {	// main START
		
		
		// �ܺ� ȣ�� ���
		// �� ��ǿ� �޸��صа� �����Ұ�.
		
		Day07_05_bookApp application = new Day07_05_bookApp();
		application.menu();
		
	}	// main END
	
	// 1. �ʱ� �Ŵ� �޼���
	void menu() {
		while(true) {
			System.out.println("--------------���� �뿩 ���α׷�--------------");
			System.out.println("1. ȸ������ | 2. �α��� | 3. ���̵� ã�� | 4. ��й�ȣ ã��");
			System.out.print("����>");
			int ch = scanner.nextInt();
			
			Member member = new Member();	// ch== 1~4 ��� ����ϴϱ� �ۿ��� ������.
			
			
			if(ch==1) {	
				boolean result = member.signup();	// ȸ������ �޼��� ȣ��
				if(result) {	// member.signup()�� ��ȯ���� T, F��.
					System.out.println("ȸ������ ����!");
				}
				else {
					System.err.println("���Կ� �����߽��ϴ�.");
				}
			}	// if(ch==1) END
			
			else if(ch==2) {
				String result = member.login();// �α��� �޼��� ȣ��
				
				if(result==null) {
					System.out.println("ȸ�������� Ȯ���ϼ���.");
					
				}
				else if(result.equals("admin")) {
					System.out.println("�˸�) �ȳ��ϼ���~"+result+"��!");
					adminmenu();
					// 2. ������ �޴� �޼��� ȣ��
				}
				else {
					
					System.out.println("�˸�) �ȳ��ϼ���~"+result+"��!");
					membermenu();
					// 1. �Ϲ� ȸ�� �޴� �޼��� ȣ��
				}
			}	// if(ch==2) END
			
			else if(ch==3) {
				member.findID();
				
				// ���̵� ã�� �޼��� ȣ��
			}	// if(ch==3) END
			
			else if(ch==4) {
				member.findPW();
				// ��� ã�� �޼��� ȣ��
			}	// if(ch==4) END
			
			else {
				// ���� �� ���ص� ���� ����??
				System.out.println("�˸�____�߸� �Է��Ͽ����ϴ�.");
			}	// ���ܰ� END
		}
	}	//	void menu END
	// 2. �Ϲ� ȸ�� �޴� �޼���
	void membermenu() {
		while(true) {
			Book book = new Book();
			System.out.println("-------------ȸ�� �޴�-------------");
			System.out.println("1. �����˻� 2. ������� 3. �����뿩 4. �����ݳ� 5. �α׾ƿ�");
			int ch = scanner.nextInt();
			if(ch==1) {
				book.�����˻�();
			}	// ch==1 END
			else if(ch==2) {
				book.�������();
			}	// ch==2 END
			else if(ch==3) {
				book.�����뿩();
			}	// ch==3 END
			else if(ch==4) {
				book.�����ݳ�();
			}	// ch==4 END
			else if(ch==5) {
				return;
			}	// ch==5 END
			else {
				
			}	// ���� else END
		}	// �Ϲ� ȸ�� �޴� while END
	}	// �Ϲ� ȸ�� �޴� �޼��� END
	// 3. ������ �޴� �޼���
	void adminmenu() {
		while(true) {
			System.out.println("-------------ȸ�� �޴�-------------");
			System.out.println("1. ������� 2. ������� 3. �������� 4. �α׾ƿ�");
			int ch = scanner.nextInt();
			Book book = new Book();
			if(ch==1) {
				book.�������();
			}	// ch==1 END
			else if(ch==2) {
				book.�������();
			}	// ch==2 END
			else if(ch==3) {
				book.��������();
			}	// ch==3 END
			else if(ch==4) {
				return;	// ������ �޴� ����
			}	// ch==4 END			
			else {
				
			}	// ���� END
		}	// ������ �޴� while END
	}	// ������ �޴� �޼��� END
}	// class END
