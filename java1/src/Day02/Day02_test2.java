package Day02;

import java.util.Scanner;

public class Day02_test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�ݾ��� �Է��ϼ��� : ");
		int money = scanner.nextInt();
		
		//���� �Ѱ�
		System.out.println("�ʸ����� : " + money/100000 + "��");
		System.out.println("������ : " + (money%100000)/10000 + "��");
		System.out.println("õ���� : " + (money%10000)/1000 + "��");
		System.out.println("���¥�� : " + (money%1000)/100 + "��");
		
		//����� ����
		System.out.println("�ʸ����� : " + money/100000 + "��");
		money -= (money/100000)*100000;	// 10���� ������ ������ �� money�� ����
		System.out.println("������ : " + money/10000 + "��");
		money -= (money/10000)*10000;
		System.out.println("õ���� : " + money/1000 + "��");
		money -= (money/1000)*1000;
		System.out.println("���¥�� : " + money/100 + "��");
		
		
		
		scanner.close();
		
	}
	
}
