package Day09_bank;

import java.util.Scanner;

public class Day09_6_����������α׷� {
	
	public static Bank[] accountList = new Bank[100];

		// ��� Ŭ�������� ����ϱ� ���� main�ۿ��� static���� ����.
	
	public static void main(String[] args) {
		
		// ����������α׷� [ ��� ]
			// ���� [ super ]
			// �������� [ sub ], �������� [ sub ], �ϳ����� [ sub ]
			// �� ��� : 1. ���»��� 2. �Ա� 3. ��� 4. ��ü 5. �����¸�� 6. ����
	Scanner scanner = new Scanner(System.in);
	
	while(true) {	// �������� : ����
		System.out.println("===============���� �ý���===============");
		System.out.println("1. ���»��� | 2. �Ա� | 3. ��� | 4. ��ü | 5. ���¸�� | 6. ����");
		System.out.print("���� >");
		int ���� = scanner.nextInt();
		
		BankController controll = new BankController();	// ��
		
		
		if (����==1) {
			System.out.println("***���»��� ������***");	
			System.out.println("��й�ȣ : ");	
			String password = scanner.next();
			System.out.println("������ : ");	
			String name = scanner.next();
			System.out.println("���༱�� | 1. ���� | 2. ���� | 3. �ϳ�");
			int bankno = scanner.nextInt();
			
			String ���¹�ȣ = controll.���»���(password, name, bankno);
				// ������ �Է¹��� password, name, bankno�� controll class�� ���»��� �޼���� ����.
			if(���¹�ȣ!=null) {
				System.out.println("*** ���� ���� ***");
				System.out.println("������ ���¹�ȣ�� : "+���¹�ȣ+" �Դϴ�.");
			}else {
				System.out.println("���� ���� ����.");
			}
			
			
			
		}else if(����==2) {
			System.out.println("***�Ա� ������***");	
		
		}else if(����==3) {
			System.out.println("***��� ������***");	
				
		}else if(����==4) {
			System.out.println("***��ü ������***");	
			
		}else if(����==5) {
			
			System.out.println("***���� ��� ������***");	// �̸��� �Է��ϸ� �ش��ϴ� ���¹�ȣ�� ���
			System.out.print("�̸� �Է� : ");
			String name = scanner.next();
			Bank[] �����¸�� = controll.�����¸��(name);
			
			System.out.println("***** �˻��� ������ ���� ���� ��� *****");
			int i=1;
			for (Bank tmp : �����¸��) {
				if(tmp!=null) {
					System.out.println(i+"��° ���¹�ȣ : "+ tmp.getAnumber());
				}
				i++;
			}
				
			
			
		}else if(����==6) {
			System.out.println("***���� ������***");	
			
		}else {
			System.out.println("�߸� �����ϼ̽��ϴ�");
		}
		
		}	// while END
	}	// main END
}	// class END
