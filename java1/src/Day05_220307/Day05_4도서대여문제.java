package Day05_220307;

import java.util.Scanner;

public class Day05_4�����뿩���� { // c s

	public static void main(String[] args) { // m s
	
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		String[][] userlist = new String[100][2]; // 1�� ���̵� 2�� ��й�ȣ
		userlist[0][0] = "admin" ; userlist[0][1] = "1";
		String[][] booklist = new String[100][2]; // 0 �̸� �뿩���� 1 �̸� �뿩��
		
		for(int i=0; i<booklist.length; i++) {	// ������ �ʱ�ȭ(�׽�Ʈ��)
			booklist[i][1] = "�뿩����";
		}
		
		while(run) {
			System.out.println("----------�����뿩 ���α׷�------------");
			System.out.println("1.ȸ������ 2.�α���");
			System.out.print("����>"); int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("--------ȸ������ ������--------");
				System.out.print(" ID : "); String id = scanner.next();
				System.out.print(" PASSWORD : "); String pw = scanner.next();
				
				boolean idcheck = true ;
				
				for(int i = 0 ; i < userlist.length ; i++) {
					if(userlist[i][0] != null && userlist[i][0].equals(id)) {
						System.err.println("�˸�]] ������ ���̵� �����մϴ�.");
						idcheck = false;	
					}
				}
				
				if(idcheck == true) {
					for(int i = 0 ; i < userlist.length ; i++) {
						if(userlist[i][0] == null) {
							userlist[i][0] = id ; userlist[i][1] = pw ;
							System.err.println("�˸�]] ȸ�������� �Ǿ����ϴ�.");
							break;
						}
					}
				}
			}else if(ch==2) {
				System.out.println("--------�α��� ������--------");
				System.out.print("ID : "); String id = scanner.next();
				System.out.print("PASSWORD : "); String pw = scanner.next();
				
				boolean logincheck = false;
				for(int i = 0 ; i < userlist.length ; i++) {
					if(userlist[i][0] != null && userlist[i][0].equals(id) && userlist[i][1].equals(pw)) {
						System.err.println("�˸�]] �α��� ����");
						logincheck = true;
						boolean admincheck = true;
						
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
											System.out.printf("%s\t%s\n",booklist[adi][0],booklist[adi][1]);
																			
									}
								}
//								else if(adch==3) {
//									System.out.println("�������� �Է��ϼ��� : "); String book2 = scanner.next();
//									for(int adi = 0 ; adi < booklist.length ; adi++) {
//										if(booklist[adi][0].equals(book2)) {
//											booklist[adi][0] = null;
//											System.out.println("���� ���� �Ϸ�");
//										}else {
//											System.out.println("�������� �ʴ� ���� �Դϴ�.");
//											break;
//										}
//
//									}
//								}
								else if(adch==4) {
									System.out.println("�α׾ƿ� �մϴ�.");
									admincheck = false;
									break;
								}
								else {
									System.out.println("�˸�]] �߸��� �ൿ�Դϴ�.");			
								}
								
							} // admin �޴� while end
						} // admin if end
						if(admincheck==true) {
							while(true){// �α��� ���� ���ѹݺ�, �������� : 5�� �α׾ƿ�
								System.out.println("--------------------------");
								System.out.println("1. �����˻� | 2. ������� | 3. �����뿩 | 4. �����ݳ� | 5. �α׾ƿ�");
								System.out.print("����> ");
								int input2=scanner.nextInt();
								
								if(input2==1) {	// 1. ���� �˻� ���� if��
									boolean bookscan = false;	// �˻��� å�� �����ϴ��� ���� �÷���
									System.out.println("------���� �˻� �Ŵ��Դϴ�.------");
									System.out.print("�˻��� �������� �Է��ϼ��� :");
									String bookname = scanner.next();
									for(int ii=0; ii<booklist.length; ii++) {
										if(booklist[ii][0]!=null && booklist[ii][0].equals(bookname)) {
											System.out.printf("������ : %s | �뿩 ���� : %s\n", booklist[ii][0], booklist[ii][1]);
											bookscan = true;	// �÷��� ��
										}
									if(bookscan==false)	// �˻��� å�� �����ϴ��� ���� �÷��� Ȯ��
										System.err.println("��ġ�ϴ� å�� �����ϴ�.");
									} // ������ �迭���� ã�� for end
								}// 1. ���� �˻� if end
								
								else if(input2==2) {	// 2. ��� å ��� ���� if��
									System.out.println("------���� ����� ����մϴ�.------");
									for(int ii=0; ii<booklist.length; ii++) {	// 2. ��� å ��� for��
										if(booklist[ii][0]!=null) 
											System.out.printf("������ : %s\n ", booklist[ii][0]);
									}	// 2. ��� å ��� for end
								}	// 2. ��� å ��� ���� if end
								
								else if(input2==3) {	// 3. ���� �뿩 ���� if��
									boolean booklent = false;
									System.out.println("------���� �뿩 �Ŵ��Դϴ�.------");
									System.out.print("�뿩�� ���� ������ �Է��ϼ��� : ");
									String bookname = scanner.next();
									for(int ii=0; ii<booklist.length; ii++) {
										if(booklist[ii][0]!=null && booklist[ii][0].equals(bookname) && booklist[ii][1].equals("�뿩����")) {	// å�̸��� ��ġ�ϰ� �뿩�����ϰ� �ΰ��� �ƴѰ�
											System.out.println("�뿩 �����մϴ�. �뿩�Ͻðڽ��ϱ�? (y or n)");
											String choice = scanner.next();
											if (choice.equals("y")) {
												System.out.printf("%s �뿩 �Ϸ�.",booklist[ii][0]);
												booklist[ii][1]="�뿩�Ұ�";
												booklent=true;
												break;
											}
											else if (choice.equals("y")){
												System.out.println("�뿩 ���");
												booklent=true;
												break;
											}
										}
										else if(booklist[ii][0].equals(bookname) && booklist[ii][0].equals("�뿩�Ұ�") && booklist!=null) {	// å�̸��� ��ġ�ϰ� �뿩�Ұ��ϰ� �ΰ��� �ƴѰ�
											System.err.println("�̹� �뿩���� å �Դϴ�.");
											booklent=true;
											break;
										}
									}
									if (booklent==false)
										System.out.println("��ġ�ϴ� å�� �����ϴ�.");
									
								}
								else if(input2==4) {
									
								}
								else if(input2==5){
									System.err.println("5. �α׾ƿ�");
									break;
								}
								else {
									System.out.println("�߸� �����̽��ϴ�");
								}
							} // �Ϲ�ȸ�� while end
						} // admincheck end
					}
				}
				if(logincheck == false) {
					System.err.println("�˸�]] ȸ�������� ���ų� �ٸ��ϴ�.");
				}				
			}else {
				System.out.println("�˸�]] �߸��� �ൿ�Դϴ�.");
			}
		} // while end
	
	} // m e
	
} // c e