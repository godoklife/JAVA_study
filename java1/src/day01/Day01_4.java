package day01;

import java.util.Scanner;

public class Day01_4 {	// c s
	
	public static void main(String[] args) {	// m s
		
		// ����1 : �Ѹ��� �̸�, 1����, 2����, 3���� �⼮ ���θ� �Է� �޾� ���
					// �Է� -> ���� -> ���
		// 1. �Է� ��ü ����
		Scanner scan = new Scanner(System.in);
		
		// 2. �Է� ���� ������ �ȳ�
		System.out.println("�̸� : ");
		
		// 3. �Է� ���� ������ �������� -> �ٸ����� ����
		String �̸� = scan.next();
		
		System.out.println("1���� : ");	
		String ����1 = scan.next();		// �������� ù ���ڴ� ���ڰ� �� �� ����.
		
		System.out.println("2���� : ");	
		String ����2 = scan.next();
		
		System.out.println("3���� : ");	
		String ����3 = scan.next();
		
		// 4. ���
		System.out.println("\t[[�⼮��]]");
		System.out.println("------------------------------");
		System.out.println("�̸�\t1����\t2����\t3����");
		System.out.println(�̸� + "\t" + ����1 + "\t" + ����2 + "\t" + ����3);	// ������ ����� �̸��� ����ó�� X
		System.out.println("------------------------------");
		
		scan.close();
		
		
		
	}	// m e
}	// c e
