package Day08_bank_test;

public class Member {

	// 1. �ʵ�
		String name, phoneNumber, id, pw, ano;
		
		// 2. ������
		public Member(String name, String phoneNumber, String id, String pw) {	// �ʱ� ȸ�����Խ� ����� ������
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.id = id;
			this.pw = pw;
		}

		// 3. �޼���
		
		boolean join() {
			System.out.println("=============ȸ������ �޴��Դϴ�.=============");
			while(true) {
				System.out.print("ID : ");
				String newID = Menu.scanner.next();
				for(Member tmp : Menu.member) {
					if(tmp.id.equals(newID) && tmp.id != null) {
						System.out.println("�ߺ��� ���̵� �Դϴ�. �ٸ� ���̵� �Է��ϼ���.");
						return false;
					}	// ���̵� �ߺ��˻� for if�� END
				}	// ���̵� �ߺ��˻� for END
				System.out.print("PW : ");	
				String newPW = Menu.scanner.next();
				System.out.print("�̸� : ");
				String newName = Menu.scanner.next();
				System.out.print("����ó : ");
				String newphoneNumber = Menu.scanner.next();
				
				Member newmember = new Member(newName, newphoneNumber, newID, newPW);	// �Է¹��� ����Ÿ���� ����ֱ� ���� ��üȭ��Ŵ
				int i=0;	// �ε��� ī��Ʈ�� ����
				for(Member tmp : Menu.member) {
					if(tmp!=null) {
						Menu.member[i] = newmember;
					}
					i++;
				}	// �迭�� ����� for�� END
			}	// join while END
		}	// join END
	
}

