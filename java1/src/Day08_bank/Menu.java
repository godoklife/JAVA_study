package Day08_bank;

import java.util.Scanner;

public class Menu {
	static Scanner scanner = new Scanner(System.in);
	static Member[] members  = new Member[1000];
	
	public static void main(String[] args) {	
		
		Menu application = new Menu();
		application.menu();
		
	}	// main END
	
	void menu() {
		
		while(true) {
			Member member = new Member();
			System.out.println("=================����� ��ŷ ���α׷�=================");
			System.out.println("1. ȸ������ | 2. �α��� | 3. ���̵� ã�� | 4. ��й�ȣ ã��");
			System.out.print("���� >");
			String ch = scanner.next();
			
			if(ch!=null && ch.equals("1")) {
				member.signup();
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				
			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				
			}	// else if ch==4 END
			
			else
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			
		}	// menu while END
	}	// menu END
	
	void membermenu() {
		while(true) {
			System.out.println("=================�Ϲ� ����� �Ŵ�=================");
			System.out.println("1. ���»��� | 2. �Ա� | 3. ��� | 4. ��ü | 5. ���� | 6. ���� ��� ��ȸ");
			System.out.print("���� >");
			String ch = scanner.next();
			
			if(ch!=null && ch.equals("1")) {
				
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				
			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				
			}	// else if ch==4 END
			
			else if (ch!=null && ch.equals("5")) {
				
			}	// else if ch==5 END
			
			else if (ch!=null && ch.equals("6")) {
	
			}	// else if ch==6 END
			
			else
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			
		}	// membermenu while END
	}	// membermenu END	
	
	void adminmenu() {	// ���� �Ŵ� �̿ϼ�. �Ȱǵ���;;
		while(true) {
			System.out.println("=================������ �Ŵ�=================");
			System.out.println("1. ȸ������ | 2. �α��� | 3. ���̵� ã�� | 4. ��й�ȣ ã��");
			System.out.print("���� >");
			String ch = scanner.next();
			
			if(ch!=null && ch.equals("1")) {
				
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				
			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				
			}	// else if ch==4 END
			
			else
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			
		}	// adminmenu while END
	}	// adminmenu END
	
}
