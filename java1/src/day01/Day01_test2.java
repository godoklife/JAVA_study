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
		
		
		/*	�����ϰ� �׽�Ʈ �Ҷ� �ּ� Ǯ�� ���
		String name = "��ȣ��";
		String data = "�ȳ��ϼ���";
		String date = "09:21";
		*/
		
		
		System.out.println("* -----------����-----------");
		System.out.printf("%-6s%-5s%-10s%-8s\n", "* |����|","�ۼ���|","����", "|��¥  |");
		System.out.printf("%-6s|%-3s|%-10s|%-5s|\n", "* |1", name, data, date);
		System.out.println("* --------------------------");
		
		
		System.out.printf("\n\n");
		System.out.println("* -----------����-----------");
		System.out.println("* |����|�ۼ���| ����\t\t|��¥   |");
		System.out.println("* | 1 | " + name + "|" + data + "\t|"+ date + " |");
		System.out.println("* --------------------------");
		
		
	}	// m e
	
}	// c e
