package Day08_bank_test;

import java.util.Scanner;

public class Menu {
Scanner scanner = new Scanner(s)		
	public static void main(String[] args) {	
		
		
	}	// main END
	
	void menu() {
	
		while(true) {
			System.out.println("=================����� ��ŷ ���α׷�=================");
			System.out.println("1. ȸ������ | 2. �α��� | 3. ���̵� ã�� | 4. ��й�ȣ ã��");
			System.out.print("���� >");
			String ch = scanner.next();
			Member member = new Member();
			if(ch!=null && ch.equals("1")) {
			boolean result = member.signup();
				if (result) {
					System.out.println("�˸�) ȸ������ ����.");
				}
				else {
					System.out.println("�˸�) ȸ������ ����");
				}
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				String result = member.login();
				if (result == null ) {
					System.out.println("�˸�) ������ ȸ�������� �����ϴ�.");
				}
				else if(result.equals("admin")){
					// 2. ������ �޴� �޼ҵ� ȣ��
					System.out.println("�˸�) �ȳ��ϼ���~ " + result + "��");
					adminmenu();
				}
				else {
					// 3. �Ϲ�ȸ�� �޴� �޼ҵ� ȣ��
					System.out.println("�˸�) �ȳ��ϼ���~ " + result + "��");
					membermenu(result);
				}
					

			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				member.findid();
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				member.findpw();
			}	// else if ch==4 END	
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			
		}	// menu while END
	}	// menu END
	
	void membermenu(String loginid) {
		while(true) {
			System.out.println("=================�Ϲ� ����� �Ŵ�=================");
			System.out.println("1. ���»��� | 2. �Ա� | 3. ��� | 4. ��ü | 5. ���� | 6. ���� ��� ��ȸ");
			System.out.print("���� >");
			String ch = scanner.next();
			Account account = new Account();
			if(ch!=null && ch.equals("1")) {
				account.create(loginid);
			} 	// if ch==1 END
			
			else if(ch!=null && ch.equals("2")) {
				account.in();
			}	// else if ch==2 END
			
			else if(ch!=null && ch.equals("3")) {
				account.out();
			}	// else if ch==3 END
			
			else if (ch!=null && ch.equals("4")) {
				account.send();
			}	// else if ch==4 END
			
			else if (ch!=null && ch.equals("5")) {
				
			}	// else if ch==5 END
			
			else if (ch!=null && ch.equals("6")) {
				account.list();
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