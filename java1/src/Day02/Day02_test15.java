package Day02;

import java.util.Scanner;

public class Day02_test15 {
	public static void main(String[] args) {
		System.out.println("���̸� �Է¹޾� 10�� �̻��̸� �л�, 20�� �̻��̸� ����, 40�� �̻��̸� �߳����� ����Ͻÿ�");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���̸� �Է��Ͻÿ� : ");
		int age = scanner.nextInt();
		
		String �з� = age >= 40 ? "�߳�" : age >= 20 ? "����" : age >= 10 ? "�л�" : "�з�����";
		
		System.out.println(�з�);
		
		scanner.close();
	}
}
