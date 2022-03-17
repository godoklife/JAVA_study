package ���迬��2;

import java.util.Scanner;

public class Report {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student[] students = new Student[100];
		
		while(true) {
			try {
				System.out.println("---------------------------------------------------------------");
				System.out.println("\t\t��\t��\tǥ");
				System.out.println("---------------------------------------------------------------");
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
				// �л��� ���� �� ĭ
				System.out.println("---------------------------------------------------------------");
				System.out.println("1. ���� �Է� | 2. ���� ����");
				System.out.print("���� >");
				int ch = scanner.nextInt();
				
				if(ch==1) {
					boolean isPointIsCorrect = true;
					System.out.println("���� �Է� �޴�");
					System.out.print("�л� ��ȣ : ");
					int num = scanner.nextInt();
					System.out.print("�л� �̸� : ");
					String name = scanner.next();
					System.out.print("���� ���� : ");
					int kor = scanner.nextInt();
					System.out.print("���� ���� : ");
					int eng = scanner.nextInt();
					System.out.print("���� ���� : ");
					int math = scanner.nextInt();
					
					
					if(kor<1 || kor>100 || eng<1 || eng>100 || math<1 || math>100) {
						System.out.println("�Է��Ͻ� ������ �ùٸ��� �ʽ��ϴ�.");
						isPointIsCorrect = false;
					}
					if(isPointIsCorrect==true) {
						int sum = kor+eng+math;
						float avg = (kor+eng+math)/3.0f;
						Student newStudent = new Student(num, name, kor, eng, math, sum, avg);
						int studentsIndexCount=0;
						for(Student tmp : students) {
							if(tmp==null) {
								students[studentsIndexCount] = newStudent;
								System.out.println("����Ϸ�");
								break;
							}
							studentsIndexCount++;
						}
					}
					
				}	// �л��߰��Ŵ� END
				else if(ch==2) {
					System.out.println("����2");
				}	// �л������Ŵ� END
				else {
					System.out.println("��ȣ�� Ȯ���ϼ���");
				}
				
			} catch(Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("���� �߻�! �ʱ� �Ŵ��� ���ư��ϴ�.");
				System.out.println(e);
			}
		}	// while END
	}	// main END
}	// class END
