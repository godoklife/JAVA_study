package day01;

import java.util.Scanner;

public class Day01_test2 {	// c s

	public static void main(String[] args) {	// m s
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("���� �Է��� �޽��ϴ�");
		System.out.print("�ۼ��� : ");
		String name = scan.next();
		
		System.out.println("������ �Է����ּ���");
		String data = scan.next();
		
		System.out.print("��¥ : ");
		String date = scan.next();
		
		scan.close();
		
		System.out.println("* -----------����-----------");
		System.out.println("* |����|�ۼ���| ����\t\t|��¥\t|");
		System.out.println("* | 1 | " + name + "|" + data + "\t|"+ date + "|");
		System.out.println("* --------------------------");
		
	}	// m e
	
}	// c e
