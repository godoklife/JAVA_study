package Day02;

import java.util.Scanner;

public class Day02_3 {	// c s

	public static void main(String[] args) {	// m s
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�޿� ����� �����մϴ�.");
		System.out.print("�⺻�� : ");
		int income = scan.nextInt();
		
		System.out.print("���� : ");
		int sudang = scan.nextInt();
		
		scan.close();
		
		int realincome = (income + sudang - (int)(income * 0.1));
		
		
		System.out.println("�� ���ɾ� : �⺻�� + ���� - ����(�⺻���� 10%)");
		System.out.println("�� ���ɾ��� " + realincome + "�Դϴ�.");
		
		
		
	}	// m e
	
}	// c s
