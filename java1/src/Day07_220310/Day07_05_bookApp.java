/*
 * 
 */



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
				member.signup();	// ȸ������ �޼��� ȣ��
			}
			
			else if(ch==2) {
				member.login();// �α��� �޼��� ȣ��
					// 1. �Ϲ� ȸ�� �޴� �޼��� ȣ��
					// 2. ������ �޴� �޼��� ȣ��
			}
			
			else if(ch==3) {
				// ���̵� ã�� �޼��� ȣ��
			}
			
			else if(ch==4) {
				// ��� ã�� �޼��� ȣ��
			}
			
			else {
				// ���� �� ���ص� ���� ����??
				System.out.println("�˸�____�߸� �Է��Ͽ����ϴ�.");
			}	// ���ܰ� END
		}
	}	//	void menu END
	// 2. �Ϲ� ȸ�� �Ŵ� �޼���
	void membermenu() {
		
	}
	// 3. ������ �޴� �޼���
	void adminmenu() {
		
	}
}	// class END
