package day01;

import java.util.Scanner;

public class Day01_test1 {	// c s
	public static void main(String[] args) {	// m s

		Scanner scan = new Scanner(System.in);
		
		System.out.println("ȸ�������� ���� ������ �Է¹޽��ϴ�.");
		System.out.print("���̵� �Է����ּ��� : ");
		String id = scan.next();
		
		System.out.print("��й�ȣ�� �Է����ּ��� : ");
		String pw = scan.next();
		
		System.out.print("������ �Է����ּ��� : ");
		String name = scan.next();
		
		System.out.print("�̸��� �ּҸ� �Է����ּ��� : ");
		String email = scan.next();
		
		System.out.println("\n>>>>>>>>>>ȸ������ �Ϸ�  �Ʒ� ������ Ȯ�����ּ���.<<<<<<<<<<");
		System.out.println("���̵�\t��й�ȣ\t����\t�̸���");
		System.out.println(id + "\t" + pw + "\t" + name + "\t" + email);
		System.out.println("===============================");

		scan.close();
		
	}	// m e

}	// c e
