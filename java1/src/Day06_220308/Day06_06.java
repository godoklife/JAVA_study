package Day06_220308;

import java.util.Scanner;

public class Day06_06 {	// c s
	public static void main(String[] args) {	// m s
		// �Խ���
		
		Scanner scanner = new Scanner(System.in);
		Board[] boardlist = new Board[100];
			// Board ��ü�� 100�� ������ �� �ִ� 1���� �迭
		
		while(true) {	// ���α׷� ���� ���ѷ���, [ �������� : ���� ]
			
			System.out.println("----------Ŀ�´�Ƽ----------");
			System.out.println("��ȣ\t\t�ۼ���\t\t����");
				// �迭 �� ��� ��ü(�Խù�) ����ϴ� �ݺ���
			int index = 0;	// �迭 �ε��� ī��Ʈ ����
			for(Board board : boardlist ) {
				if(board != null) {
					System.out.printf("%d\t\t%s\t\t%s\n", index, board.writer, board.title);
				}
				index++;	// �ε��� ����
			}
			
			
			
			System.out.println("1. �۾��� | 2. �ۺ���");
			int ch = scanner.nextInt();
			if(ch == 1) {
				System.out.println("-----------------�۾��� ������-----------------");
				
				// 1. 4���� ������ �Է¹޴´�.
				System.out.println("title : ");
				String title = scanner.next();
				System.out.println("content : ");
				String content = scanner.next();
				System.out.println("writer : ");
				String writer = scanner.next();
				System.out.println("password : ");
				String password = scanner.next();
				
				// 2. 4���� �ʵ带 ���� ������ ���
				Board board = new Board(title, content, writer, password);
				
				// 3. �迭 �� ������� ã�Ƽ� ��ü ����
				int i=0;	// �ε��� ��ȣ ī��Ʈ��
				for(Board temp : boardlist) {
					if( temp == null ) {	// temp ��ü�� �ʵ尡 ��� null�϶�
						boardlist[i] = board;	// �ش� �ε����� ���ο� ��ü ����
						break;	// ���� ������ �ݺ��� ����
					}
					i++;	// �ݺ� 1ȸ�� �ε��� 1 ����
				}
				
			}	// ch==1 if end
			
			else if(ch == 2) {
				System.out.println("==============�ۺ���==============");
				System.out.println("1. ��Ϻ��� | 2. ���� | 3. ����");
				int menu = scanner.nextInt();	// �ۺ��� �� �Ŵ� ���� ���� ����
				
				if (menu==1) {	
					System.out.print("�Խù� ��ȣ(�ε���) ���� : ");
					int bno = scanner.nextInt();
					
					// �ݺ��� �ʿ� X, �ٷ� �� ���ο��� �ε����� �Է¹޾ұ� ������.
					System.out.printf("�ۼ��� : %s ���� : %s \n", boardlist[bno].writer, boardlist[bno].title);
					System.out.println("����");
					System.out.printf("%s\n", boardlist[bno].content);
					System.out.println("==============================");
					System.out.print("1. ��Ϻ���(�ڷΰ���) | 2. �ۻ��� | 3. �ۼ���");
					System.out.print("����>");
					
					int ch2 = scanner.nextInt();
					
					if(ch2==1) {
						System.out.println("�ڷΰ���.");
					}	// ch2==1 end
					
					else if(ch2==2) {
						// �ε��� ��ȣ�� ������ �Է¹޾ұ� ������ �ݺ��� ���� �ʿ� ����.
						System.out.println("�ۻ���");
						System.out.print("��й�ȣ�� �Է����ּ��� : ");
						String pw = scanner.next();
						if(boardlist[bno].password.equals(pw)) {
							boardlist[bno]=null;
							
							/////////////////////////////////////////////
							// ���� �Ŀ� ������ �ε��� �ڷ� ��ĭ�� ������ �̵�
							// �ֳ�? ���� �ش� �ڵ尡 ���� ��� �迭 �� ���̻��� ���� �߻�
						for(int i = bno ; i<boardlist.length; i++) {
							// * �˻��� �Խù��� �ε������� ������ �ε������� 1�� ����
							boardlist[bno] = boardlist[bno+1];
							
							if(i == boardlist.length-1)
								boardlist[boardlist.length-1]=null;
						}
							/////////////////////////////////////////////
							
							System.out.println("�����Ǿ����ϴ�.");
						}
						else
							System.out.println("��й�ȣ�� Ȯ�����ּ���");
					}	// ch2==2 end
					
					else if(ch2==3) {
						
					}	// ch2==3 end
					else 
						System.out.println("�߸������̽��ϴ�.");
					
					
					
					
					
					
				}	// menu==1 if end
				
				else if(menu==2) {
					
				}	// menu==2 if end
				
				else if(menu == 3) {
					
				}	// menu==3 if end
				else
					System.out.println("�߸� �����̽��ϴ�.\n �ڷΰ���");
				
				
			}	// ch==2 if end
			else
				System.out.println("�߸� �����̽��ϴ�.");
			
		}	// ���α׷� while end
	}	// m e
}	// c e
