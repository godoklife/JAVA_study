package Day08_bank_test;

import java.util.Scanner;

public class Menu {

static Scanner scanner = new Scanner(System.in);
static Member[] member = new Member[1000];


	public static void main(String[] args) {	
	
		Menu bankingapp = new Menu();
		bankingapp.mainMenu();
		
	}	// main END
	
	void mainMenu() {
		while(true) {
			System.out.println("=============����� ��ŷ ���α׷�=============");
			System.out.println("1. ȸ������ | 2. �α��� | 3. ���̵�ã�� | 4. ��й�ȣ ã��");
			System.out.print("�Է� >");
			String ch=scanner.next();
			if(ch.equals("1")) {
// �� ����???				boolean joinResult = member.join();
			}
			else if(ch.equals("2")) {
				
			}
			else if(ch.equals("3")) {
				
			}
			else if(ch.equals("4")) {
				
			}
			else
				System.out.println("�˸�) �߸� �Է��ϼ̽��ϴ�.");
		}	// mainMenu while END
	}	// mainMenu END
	
}	// class END