package Day05_220307;

import java.util.Scanner;

public class Day05_02 {	// c s
	public static void main(String[] args) {	// m s
		Scanner scanner = new Scanner(System.in);	// �Է� ��ü
		// ȸ�� 100��[ id, pw, name ]�� �����ϴ� �迭
		String[][] memberlist = new String[100][3];	// �� ȸ���� �� ��, 1�� id, 2���� pw, 3���� name
		// �湮�� 100��[ title, contents, writer ] �� �����ϴ� �迭
		String[][] boardlist = new String[100][3];	// �� ���ù��� �� ��
		
		while(true) {	// w s		// ���ѷ��� [ �������� ����!! ]
			System.out.println("------------------ȸ���� ����------------------");
			System.out.println("---------------------------------------------");
			System.out.print("1. ȸ������ | 2. �α��� | ����> ");
			int choice = scanner.nextInt();	// choice = ����� ���� �����ϴ� ����
			
			
			if (choice==1) {
				boolean check=true;	// ���̵� �ߺ�üũ�� �ߺ��� ���� �ߴ� ����ġ
				System.out.println("-----------------ȸ������ ������------------------");
				System.out.println("���� ����� ID�� �Է����ּ���");
				String newid=scanner.next();
				for(int i = 0; i<memberlist.length; i++) {	// ���̵� �ߺ�üũ�� �ߺ��� ���� �ߴ� �ڵ�
					if (memberlist[i][0]!=null && memberlist[i][0].equals(newid)) {
						System.err.println("�˸�) ���̵� �̹� �����մϴ�. �ٸ� ���̵� �������ּ���.");
						check = false;	// ȸ������ �ߴ� ����ġ ����
						break;
					}
				}
				if(check==true) {
					System.out.println("���� ����� ��й�ȣ�� �Է����ּ���");
					String newpw=scanner.next();
					System.out.println("����� ������ �Է����ּ���.");
					String newname=scanner.next();
					// String 3�� ������ �Է� �޾� memberlist 2���� �迭�� ����.
						// 1. �� ����[ ���� = 0, ��ü(���ڿ�) = null ] �� ã�Ƽ� ����.
						// 2. ���̵� �ߺ�üũ
					
					// ������ �����
					for(int i = 0; i<memberlist.length; i++) {
						 if (memberlist[i][0]==null) {
							// i��° ���� ID�� ������(String�� �ʱⰪ�� null) �Ʒ� ����Ÿ�� ����־��.	// ����� ã��!!
							memberlist[0][0] = newid;
							memberlist[0][1] = newpw;
							memberlist[0][2] = newname;
							System.err.println("�˸�) ȸ�������� �Ϸ�Ǿ����ϴ�.");
							break;	// �ѹ� ���� �Ϸ������� for�� Ż��.	
						}
					}
				}
			}	// if end
			
			else if(choice==2) {	// �α��κ�
					// �Է¹��� ���̵�� ����� �迭 �� �����Ϳ� �����ϸ� �α��� OK ó��
				System.out.println("------------------�α��� ������------------------");
				System.out.println("ID�� �Է����ּ���");
				String id = scanner.next();
				System.out.println("��й�ȣ�� �Է����ּ���");
				String pw = scanner.next();
				
				boolean logincheck = false;	// �α��� ���� ���� �⺻��
				for(int i=0; i<memberlist.length;i++) {
					if(memberlist[i][0]!=null && memberlist[i][0].equals(id) && memberlist[i][1].equals(pw)) {	// null���� ���� �ɷ������ �Ѵ�, ID�� �´��� ã�� ����
						// null�� ��ü�� �ƴϱ� ������ .equals�� �Ұ����ϴ�. -> ==�� ��� ����.
						System.err.println("�˸�) �α��� ����!");
						
						logincheck = true;	// �α��� ���� ���� �� ����
						
						while(true) {	// �α��� ������ ���ѷ���, Ż�� ������ 2�� �α׾ƿ� ��������
							System.out.println("-------------------");
							System.out.println("--------����-------");
							System.out.printf("��ȣ\t�ۼ���\t����\t����\n");
								// ��� ���� ���
							for(int j=0;j<boardlist.length;j++) {
								if(boardlist[j][0]!=null) {
								System.out.printf("%d\t%s\t%s\t%s\n\n", 
										j, 
										boardlist[j][2],
										boardlist[j][0],
										boardlist[j][1]);
								}
							}
							
							System.out.print("\n1. ���� ����� | 2. �α׾ƿ� | ���� >");
							int choice2 = scanner.nextInt();
							
							if(choice2 == 1) {
								System.out.println("--------------�۾���--------------");
								System.out.println("title : ");
								String title = scanner.next();
								System.out.println("content : ");
								String content = scanner.next();
								// �迭 �� ������ ã�Ƽ� ����.
								for(int j=0; j<boardlist.length; j++) {
									if(boardlist[j][0]==null) {	// ���� j��° ������ ���������
										boardlist[j][0]=title;
										boardlist[j][1]=content;
										boardlist[j][2]=id;
										System.err.println("�˸�) ���� ������ �Ϸ�Ǿ����ϴ�.");
										break;	// �Է��Ѱ͵� �����ϰ� �۾��� for--�� Ż��
									}
								}
							}	// �۾��� if��
							else if(choice2 == 2) {
								System.err.println("�˸�) �α׾ƿ�");
								break;
							}
							
							else
								System.err.println("�˸�) �� �� ���� ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
						}
					}
				}	// �α��κ� for�� end
				if(logincheck==false)
					System.err.println("�˸�) �α��� ������ �ٸ��ϴ�.");
			}	// �α��κ� else if end
			else
				System.err.println("�˸�) �� �� ���� ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
		}	// while 1 END	= �ʱ� �Ŵ� end
	}	// m e
}	// c e
