package Day05_220307;

import java.util.Scanner;

public class Day05_book_rent_management_program {	// c s
	public static void main(String[] args) {	// m s
		
		Scanner scanner = new Scanner(System.in);
		String[][] userlist = new String[100][2];
		String[][] booklist = new String[10][3];
		
		
		for(int i=0; i<booklist.length; i++) {	// ������ �ʱ�ȭ(�׽�Ʈ��)
			booklist[i][0] = "å";
			booklist[i][1] = "�뿩����";
			booklist[i][2] = "ID";
		}
		
		
		while(true) {
			System.out.println("----------�ʱ� �Ŵ�----------");
			System.out.println("--------------------------");
			System.out.println("1. ȸ������ | 2. �α���");
			int input=scanner.nextInt();
			
			if(input==1) {	// ȸ������ �Ŵ� ����
				while(true) {	// ȸ������ �ݺ�
					
					boolean idcheck=true;	// ���̵� �ߺ� ���� ��� ����ġ
					System.out.print("���ο� ���̵� �Է��ϼ��� : ");
					String newid = scanner.next();	// ��������׼� ���̵� �Է¹ް� �����ϴ� ����
					
					for(int i=0; i<userlist.length; i++) { // ���̵� �ߺ�üũ
						if(userlist[i][0]!=null && newid.equals(userlist[i][0])) {	// ���̵� �ߺ�üũ if�� ����
							System.err.println("�˸�) �ߺ��� ���̵��Դϴ�.");
							idcheck=false;
							break;
						}	// ���̵� �ߺ�üũ if end
					}	// ���̵� �ߺ�üũ for end
					
					if(idcheck==true) {	// ���̵� �ߺ� ����� ��츸 ���̵�, ��й�ȣ ���� ����
						System.out.print("��й�ȣ�� �Է��ϼ��� :");
						String newpw = scanner.next();
						
						for(int i=0; i<userlist.length; i++) {	// userlist �迭���� �� ���� ã�� for��
							if(userlist[i][0]==null) {	// �� ���� ã���� �����ϴ� if��
								userlist[i][0]=newid;
								userlist[i][1]=newpw;
								System.err.println("�˸�) ȸ�������� �Ϸ�Ǿ����ϴ�.");
								break;
							}	// �� ���� ã���� �����ϴ� if end
						}	// userlist �迭���� �� ���� ã�� for end
						break;	// ȸ������ ���������� ������ while Ż��
					}	// ���̵�, ��й�ȣ ���� if end
				}	// ȸ������ while end
			}	// ȸ������ ���� if end
			
			
			


			else if(input==2) {	// �α��� �Ŵ� ���� if��
				boolean login = false;	//�α��� ���� ��� ����ġ
				System.out.print("���̵� : ");
				String id = scanner.next();
				System.out.print("��й�ȣ : ");
				String pw = scanner.next();
				
				
				for(int i=0; i<userlist.length; i++) {
					if(userlist[i][0].equals(id) && userlist[i][1].equals(pw) && userlist[i][0]!=null) {
						System.out.println("�α��α��� ��");
						login=true;
						break;
					}
//					else
//						System.out.println("���̵� ��й�ȣ�� Ȯ���ϼ���.");
//					break;
				}
				if(id.equals("admin")) {
					while(true) {
						System.out.println("---------������ ���� �޴�---------");
						System.out.println("1.������� 2.������� 3.�������� 4.�α׾ƿ�"); 
						int adch = scanner.nextInt();
						if(adch==1) {
							System.out.println("�������� �Է��ϼ��� : "); String book = scanner.next();
							for(int adi = 0 ; adi < booklist.length ; adi++) {
								if(booklist[adi][0] == null) {
									booklist[adi][0] = book;
									System.out.println("���� ��� �Ϸ�");
									break;
								}
							}
						}
						else if(adch==2) {
							System.out.println("-----������� ���-----");
							System.out.println("������\t�뿩����");
							for(int adi = 0 ; adi < booklist.length ; adi++) {
									if(booklist[adi][0] != null)
									System.out.printf("%s\n",booklist[adi][0]);
																	
							}
						}

						else if(adch==4) {
							System.out.println("�α׾ƿ� �մϴ�.");
							break;
						}
						else {
							System.out.println("�˸�]] �߸��� �ൿ�Դϴ�.");
							
						}
					}
				}
				
				else if(login=true) {	// �α��� ����ġ�� true���� �Ǵ�
					
					while(true) {	// �α��� ���� ���ѹݺ�, �������� : 5�� �α׾ƿ�
						System.out.println("--------------------------");
						System.out.println("1. �����˻� | 2. ������� | 3. �����뿩 | 4. �����ݳ� | 5. �α׾ƿ�");
						System.out.print("����> ");
						int input2=scanner.nextInt();
						
						if(input2==1) {	// 1. ���� �˻� ���� if��
							System.out.println("------���� �˻� �Ŵ��Դϴ�.------");
							System.out.print("�˻��� �������� �Է��ϼ��� :");
							String bookname = scanner.next();
							for(int i=0; i<booklist.length; i++) {
								if(booklist[i][0]!=null && booklist[i][0].equals(bookname)) {
									System.out.printf("������ : %s | �뿩 ���� : %s\n", booklist[i][0], booklist[i][1]);
								}
								else {
									System.err.println("��ġ�ϴ� å�� �����ϴ�.");
									break;
								}	
							} // ������ �迭���� ã�� for end
						}// 1. ���� �˻� if end
						
						else if(input2==2) {	// 2. ��� å ��� ���� if��
							System.out.println("------���� ����� ����մϴ�.------");
							for(int i=0; i<booklist.length; i++) {	// 2. ��� å ��� for��
								if(booklist[i][0]!=null) 
									System.out.printf("������ : %s\n ", booklist[i][0]);
							}	// 2. ��� å ��� for end
						}	// 2. ��� å ��� ���� if end
						
						else if(input2==3) {	// 3. ���� �뿩 ���� if��
							System.out.println("------���� �뿩 �Ŵ��Դϴ�.------");
							System.out.print("�뿩�� ���� ������ �Է��ϼ��� : ");
							String bookname = scanner.next();
							for(int i=0; i<booklist.length; i++) {
								if(booklist[i][0].equals(bookname) && booklist[i][1].equals("�뿩����") && booklist[i][0]!=null) {	// å�̸��� ��ġ�ϰ� �뿩�����ϰ� �ΰ��� �ƴѰ�
									System.out.println("�뿩 �����մϴ�. �뿩�Ͻðڽ��ϱ�? (Y or N)");
									String choice = scanner.next();
									if (choice.equals("Y")) {
										System.out.printf("%s �뿩 �Ϸ�.",booklist[i][0]);
										booklist[i][1]="�뿩�Ұ�";
										break;
									}
									else if (choice.equals("N")){
										System.out.println("�뿩 ���");
										break;
									}
								}
								else if(booklist[i][0].equals(bookname) && booklist[i][0].equals("�뿩�Ұ�") && booklist!=null) {
									System.err.println("�̹� �뿩���� å �Դϴ�.");
									break;
								}
								
								System.out.println("��ġ�ϴ� å�� �����ϴ�.");
								break;
							}
							
						}	// 3. ���� �뿩 ���� if end
						else if(input2==4) {
							
						}
						else if(input2==5){
							System.err.println("5. �α׾ƿ�");
							break;
						}
						else {
							System.out.println("�߸� �����̽��ϴ�");
						}
						
					}	// �α��� ���� while end
				}	// �α��� ����ġ�� true���� �Ǵ� if end
			}	// �α��� if end
			else	// �ʱ�Ŵ����� 1��, 2�� �̿� �Է½�
				System.err.println("�߸� �����̽��ϴ�.");
		}	// while end
	}	// m e
}	// c e
