package Day05;

import java.util.Scanner;

public class Day05_4�����뿩���� { // c s

	public static void main(String[] args) { // m s
	
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		String[][] userlist = new String[100][2]; // 1�� ���̵� 2�� ��й�ȣ
		userlist[0][0] = "admin" ; userlist[0][1] = "1";
		String[][] booklist = new String[100][2]; // 0 �̸� �뿩���� 1 �̸� �뿩��
		
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
									break;
								}
								else {
									System.out.println("�˸�]] �߸��� �ൿ�Դϴ�.");
									
								}
							}
						}
					
					
					
					
					
					
					
					
					
					
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