package Day11_220316_BoardApp;

import java.util.Scanner;

public class Day11_04_BoardApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {	// ����Ǵ� �߻� ���� : ����ڰ� ���� �̿��� �� �Է�.
			Controller.boardlist();	// static���� ���������Ƿ� ��ü���� ȣ�� ����!!!!
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
				
			}
			else {
				
			}
			} catch (Exception e) {
				System.out.println("���) ���⿡ �ִ°͸� �����ÿ�.");
				scanner = new Scanner(System.in);	
					// ���� ��ĳ�ʸ� �ٽ� �޸� �Ҵ� �������ν� �޸𸮸� �����.
			}
			
		}	// while END
	}	// main END
}	// class END
