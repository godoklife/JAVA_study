
// try ~ catch ��. �ϳ��ϳ� if������ ���� ����.

package ���迬��;

import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
		�л�[] �л��迭 = new �л�[100];
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("�л����");
				
				System.out.println("1. �߰� 2. ����");
				int ch = scanner.nextInt();
				
				if (ch==1) {
					System.out.println("ch1����");
				}else if(ch==2){
					System.out.println("ch2����");
				}else
					System.out.println("�߸������̽��ϴ�.");
			} catch(Exception e) {
				System.out.println("�����߻�. �ʱ�޴��� ���ư��ϴ�.");
				scanner = new Scanner(System.in);
			}
		}
		
		
	}
}
