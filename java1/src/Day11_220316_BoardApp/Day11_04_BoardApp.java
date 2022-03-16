package Day11_220316_BoardApp;

import java.util.Scanner;


public class Day11_04_BoardApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Controller.load();
		
		while(true) {
			try {	// ����Ǵ� �߻� ���� : ����ڰ� ���� �̿��� �� �Է�.
			System.out.printf("%2s\t%10s\t%10s\t%10s\t%2s\t \n","��ȣ","����","�ۼ���","�ۼ���","��ȸ��");
			int i=1;
			for( Board board : Controller.boardlist ) {
				System.out.printf("%2s\t%10s\t%10s\t%10s\t%2s\t \n", i , board.getTitle() ,
						board.getWriter() , board.getDate() , board.getViewcount() );
				i++;
			}
			System.out.print("1.���� 2.���� ���� >");
			int ch = scanner.nextInt();
			if(ch==1) {
				scanner.nextLine();	// �ؽ�Ʈ���� ������������ ��ĳ�� �޸� �������. ������ ���ذ�.
				System.out.println("========= �Խù� ��� =========");
				System.out.print("���� : ");
				String ���� = scanner.nextLine();		// ���� ���� �Է� ����.
				System.out.print("���� : ");
				String ���� = scanner.nextLine();
				System.out.print("�ۼ��� : ");
				String �ۼ��� = scanner.next();
				System.out.print("��й�ȣ : ");
				String ��й�ȣ = scanner.next();
				
				Controller.write(����, ����, �ۼ���, ��й�ȣ);
				
			}
			else if(ch==2) {
				// �ش� �Խù� ��ȣ[�ε���]�� �Է¹޾� �Խù����� ��� ���
				System.out.print("�Խù� ��ȣ �Է� : "); int index = scanner.nextInt();
				Board temp =  Controller.boardlist.get(index);
				System.out.println("***** �Խù� ���� *****");
				System.out.println(" ���� : "+ temp.getTitle());
				System.out.println(" ��ȸ�� : "+ temp.getViewcount());
				System.out.println(" �ۼ��� : "+temp.getDate());
				System.out.println(" ���� : "+ temp.getContent());
				
				System.out.println(" 1. �ڷΰ��� | 2. ���� | 3. ���� | 4. ���۾��� ");
				System.out.print("���� >"); int ch2=scanner.nextInt();
				
				if(ch2==1) {
					System.out.println("�ڷΰ���");
				}
				else if(ch2==2) {
					System.out.println("***** ���� *****");
					while(true) {
						System.out.println("������ ��� ����\n1. ���� | 2. ���� | 3. ��й�ȣ | 4. ���");
						System.out.print("���� >"); int ch3 = scanner.nextInt();
						if (ch3==1) {
							System.out.print("������ �Է��ϼ��� : ");
							scanner.nextLine();
							String newtitle = scanner.nextLine();
//							Controller.boardlist.getTitle;
							
						}else if(ch3==2) {
							
						}else if(ch3==3) {
							
						}else {
							System.out.println("�߸� �����̽��ϴ�.");
						}
					}
				}	// �Խù� ���� else if END
				else if(ch2==3) {
					System.out.println("��й�ȣ �Է��ϼ���");
					String password = scanner.next();
					boolean result = Controller.delete(index, password);	// ��Ʈ�ѷ��� delete�޼���� �Խñ� �ε�����ȣ�� �н����� ����
					
					if (result == true) {
						System.out.println("���� ����");
					}else {
						System.out.println("��й�ȣ�� Ȯ���ϼ���.");
					}
					
					
				}	// �Խù� ���� else if�� END
				else if(ch2==4) {
					
				}
				else {
					
				}
				
				
			}
			else {
				System.out.println("���) �߸� �Է��ϼ̽��ϴ�");
			}
			} catch (Exception e) {
				System.out.println("���) ���⿡ �ִ°͸� �����ÿ�.");
				scanner = new Scanner(System.in);	
					// ���� ��ĳ�ʸ� �ٽ� �޸� �Ҵ� �������ν� �޸𸮸� �����.
			}
			
		}	// while END
	}	// main END
}	// class END
