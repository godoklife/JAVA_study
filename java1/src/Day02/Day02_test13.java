package Day02;

import java.util.Scanner;

public class Day02_test13 {
	public static void main(String[] args) {
		System.out.println("�߰����, �⸻���, �����򰡸� �Է¹޾� �ݿ����� �� ����ϱ�");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�߰� ���� : ");
		int �߰����� = scanner.nextInt();
		
		System.out.println("�⸻ ���� : ");
		int �⸻���� = scanner.nextInt();

		System.out.println("������ ���� : ");
		int ������ = scanner.nextInt();
		
		float �������� = (float)((�߰�����*.3) + (�⸻����*.3) + (������*.4));
		
		System.out.println("�ݿ� ���� : �߰���� 30%, �⸻��� 30%, ������ 40%");
		System.out.printf("���� ���� : %.2f", ��������);
		
		scanner.close();
	}
}
