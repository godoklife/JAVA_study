package Day10_Ű����ũ;

import java.util.Scanner;

public class Day10_07_Ű����ũ {

	// ��� : ����
	// Ŭ���� : �Ե�����, ����ŷ
	// �������̽� : Ű����ũ(UI)
	// ����ó�� : ��ǰ ���
	
	public static void main(String[] args) {
		/*
		 * ���α׷� ���� �ϸ� �ƹ��͵� �ȶ�.
		 * 1 ������ [ ���� �����ڸŴ� ] ��ǰ��ϸŴ� ��
		 */
		Ű����ũ �Ե����� = new �Ե�����();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			�Ե�����.��ǰ���();
			int ch = scanner.nextInt();
			if(ch==1) {
				�Ե�����.��ǰ�߰�();
			}
		}	// while END
	}	// main END
}	// class END
