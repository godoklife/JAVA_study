package Day03_220303;

import java.util.Scanner;

public class Day03_test08 {
	public static void main(String[] args) {
		System.out.print("����8 �α���������\n[ �Է� ] : ���̵�� ��й�ȣ�� �Է¹ޱ�\n[ ���� ] : ȸ�����̵� admin �̰�\n��й�ȣ�� 1234 �� ��쿡��\n�α��� ���� �ƴϸ� �α��� ���� ���\n");
		System.out.println("--------------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���̵� �Է��ϼ��� : ");
		String ID = scanner.next();
			// char �ڷ����� ���� 1���� �����Ѵ�.
			// ���ڿ� ���� �Ұ���!!!
			// ���� String Ŭ���� ����Ͽ��� �Ѵ�.
		
		System.out.println("��й�ȣ�� �Է��ϼ��� : ");
		int PW = scanner.nextInt();
		
		boolean login = false;
		
//		if(ID.equals("admin") && (PW == 1234)) {
//			// String�� ==���� ���Կ����� ���Ұ�!
//			// ��� ���� ��Ʈ��1.equals(���� ��Ʈ��2)
//			System.out.println("�α��� ����");
//			login = true;
//		}
		
		if(ID.equals("admin") ) {
			if(PW == 1234) {
				login = true;
				System.out.println("�α��� ����");
			}
			else System.out.println("��й�ȣ�� Ȯ���ϼ���");
		}
		else System.out.println("���̵� Ȯ���ϼ���");
			
		if(login==false) System.out.println("�α��� ����!!");

		scanner.close();
	}
}
