package day01;

import java.util.Scanner;

public class Day01_3 { // c s
	public static void main(String[] args) { // m s
		
		// �Է�
			// Ű���� -> ��ǻ��[ 0, 1 ]
			// Scanner : �Է� Ŭ���� [ �Է¿� ���õ� ��� ���� ]
				// * Ű����κ��� �Է¹��� �����͸� �����ϴ� ��ü
		
		Scanner �Է°�ü = new Scanner(System.in);
		// 1. Scanner : �Է� Ŭ���� 
			// 2. �Է°�ü : ��ü �̸�
				// 3. new : �޸� �Ҵ�
					// 4. Scanner() : ������
						// 5. System.in : �Է� 
						// * System.out : ���
		System.out.println("�̸��� �Է��ϼ��� : ");
		String �̸� = �Է°�ü.next();
		// 1. String : ���ڿ� Ŭ����
			// 2. �̸� : ��ü �̸�
				// 3. �Է°�ü.next() : �Է°�ü �� ����� ������ ��������
		
		System.out.println("�Է��Ͻ� �̸��� : " +�̸�);
			// "���ڿ�" + ��ü��[������]
				// + : 1. ���ϱ⿬���� 2. ���Ῥ����(���� �ٸ� ���¸� ����)
		�Է°�ü.close();
		
	} // m e
	
} // c e
