package Day06_220308;

import java.util.Scanner;

public class Day06_03 {	// c s
	public static void main(String[] args) {	// m s
		
		
		Scanner scanner = new Scanner(System.in);
		Member[] memberlist = new Member[100];	// ��ü�� �迭ȭ
		
		while(true) {	// ���α׷� ���� ���ѷ��� [ �������� X ]
			
			System.out.println("ȸ����[Ŭ���� ����]");
			System.out.println("[1.ȸ������ 2.�α��� 3.���̵�ã�� 4.��й�ȣã��");
			System.out.print("����>");
			int ch = scanner.nextInt();
			
			if(ch == 1) {	// ȸ������ if�� ����
				// 1. id, pw, name, phone �Է¹ޱ� => ���� 4��
				// 2. ��ü ����
				// 3. �Է¹��� ���� 4���� ��ü �� �ʵ忡 �����ϱ�
				// 4. ������ ��ü�� �����ϴ� �迭�� ����
				
				
				
				System.out.println("ȸ������ �Ŵ��Դϴ�.");
				System.out.print("ID : ");
				String id = scanner.next();
				System.out.print("PW : ");
				String password = scanner.next();
				System.out.print("�̸� : ");
				String name = scanner.next();
				System.out.print("��ȭ��ȣ : ");
				String phone = scanner.next();
				
				// 2. ��ü ����
				Member member = new Member();
				
				// 3. ��ü�� �����ϱ�
				member.id = id;
				member.pw = password;
				member.name =name;
				member.phone = phone;
				
				// 4. ������ ��ü�� �����ϴ� �迭�� ����
					// 1. ���� �ε����� ã�� [ ��? ������ �ƴϸ� �����Ⱑ �ǹ���. ]
				int i = 0; // �ε��� ��ġ ����
				for(Member temp : memberlist) {
					// * memberlist �迭 �� member ��ü�� �ϳ��� �����ͼ� temp�� ���� �ݺ�.
					// 2. ���鿡 �ε����� ��ü ��ü ����.
					if(temp == null) {	// ���� �ش� ��ü�� �����̸�
						memberlist[i] = member;	// �ش� �ε����� ������ �Է¹����� ����� ��ü ����
						i++;	// �ε��� �� UP
						System.err.println("ȸ�������� �Ϸ�Ǿ����ϴ�");
						break;	// for�� Ż��
					}
				}
			}	// ȸ������ if end
			
			else if(ch == 2) {	// �α��� if�� ����
				boolean logincheck = false;	// true : �α��� ����, false : �α��� ���� 
				// 1. �Է� �ޱ�
				System.out.println("\t�α��� �Ŵ��Դϴ�.");
				System.out.print("ID : ");
				String loginid = scanner.next();
				System.out.print("PW : ");
				String loginpassword = scanner.next();
				
				// 2. ���� �迭 [ ȸ������Ʈ ] �� �Է¹��� ���� ��
				for(Member temp : memberlist) {
					// temp��� Member ��ü�� ����� 
					if(temp != null && temp.id.equals(loginid) 
							&& temp.pw.equals(loginpassword)) {
						System.err.println("�˸�) �α��� ����");
						logincheck = true;	// �α��� ���� �ߴٴ� ��� �����
					}
				}
				
				// 3. �α��� ���� ���� Ȯ��(�α��� ������ ������� ����)
				if(logincheck==false) {
					System.out.println("���̵� ��й�ȣ�� Ȯ���ϼ���.");
				}
				
			}	// �α��� if end
			
			else if(ch == 3) {
				
			}
			
			else if (ch == 4){
				
			}
			
			else
				System.out.println("�߸� ���������ϴ�.");
		}	// while end
	}	// m e
}	// c e
