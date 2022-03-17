package ���α׷��־��Ȱ��_�����_����ǥ;

import java.util.Scanner;

public class Report {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		Student[] students = new Student[100];		// �л� ������ ���� Student Ŭ���� �迭 100�� ����
		int[] ranking = new int[students.length];	// ���� ������ ���� int�� �迭�� students ���̸�ŭ ����
		
		
		while(true) {	// ���α׷� ���� �ݺ�, �������� : ����
			try {
				System.out.println("---------------------------------------------------------------");
				System.out.println("\t\t��\t��\tǥ");
				System.out.println("---------------------------------------------------------------");
				System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");

				
				for(int i=0; i<ranking.length;i++) {	// ���� �����ϴ� �迭 �ʱ�ȭ
					ranking[i]=1;
				}
				
				for(int i=0; i<ranking.length; i++) {	// �л��� �� ������ ���ϰ� ������ �����ϴ� �ݺ���
					if(students[i]!=null) {
						for(int j=i; j<ranking.length; j++) {
							if(students[j]!=null && students[i].getSum() < students[j].getSum()) {
								ranking[i]++;
							}
							else if(students[j]!=null && students[i].getSum() > students[j].getSum()) {
								ranking[j]++;
							}
						}
					}
				}
				
				for(int i=0; i<students.length; i++) {	// �л� ���� ��� �ݺ���
					if(students[i]!=null) {
						System.out.printf("%2d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\t\n", students[i].getNum(), students[i].getName(),
								students[i].getKor(), students[i].getEng(), students[i].getMath(), students[i].getSum(), students[i].getAvg(), ranking[i]);	// ������ 0�� ���� ����
					}
				}	// �л� ���� ��� �ݺ��� END
				
				System.out.println("---------------------------------------------------------------");
				System.out.println("�Ŵ� : 1. �л����� ��� 2. �л����� ����");
				System.out.print("���� >");
				int ch1=scanner.nextInt();
				
				if(ch1==1) {
					boolean isPointCorrect = true;		// ������ ������ ������ 1��~100�� �������� �ִ��� Ȯ���ϰ� �ƴ϶�� false ����
					boolean isNumberAvailable = true;	// �ߺ��� �л� ��ȣ �߰��ϸ� false ����
					System.out.println("�л����� ��� �޴�");
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
					
					if(kor<1 || kor>100 || eng<1 || eng>100 | math<1 || math>100) {	// ���� ������ �� �ϳ��� 1��~100�� ������ ����ٸ�
						System.out.println("������ 1���̻�, 100�� �̸����� �Է��ϼ���.");
						isPointCorrect=false;										// ó�� ����
					}
					if(isPointCorrect==true) {										// ������ ������ �����ϸ� 
						int sum = kor+eng+math;	
						float avg = (kor+eng+math)/3.0f;
						Student newStudent = new Student(num, name, kor, eng, math, sum, avg);	// �Է� ���� ������ �װ� �������� ���� ����, ����� ��üȭ
						int studentsIndexCount = 0;
						for(Student tmp : students) {	// �л���ȣ �ߺ� �˻�
							if(tmp!=null && tmp.getNum()==num) {
								System.out.println("�л���ȣ�� �̹� �����մϴ�.");
								isNumberAvailable = false;
								break;
							}
						}	// �л���ȣ �ߺ��˻� �ݺ��� END
						if(isNumberAvailable==true) {
							for(Student tmp : students) {
								if(tmp==null) {
									System.out.println(name+" �л��� ������ ���������� ����Ǿ����ϴ�.");
									students[studentsIndexCount] = newStudent;
									break;
								}
								studentsIndexCount++;
							}	// for(Student tmp : students) ��ü�� studends �迭�� ���� �ݺ��� END
						}	// if(isNumberAvailable==true) END
					}	// if(isPointCorrect==true) END
					
					
				}	// �л� ���� ��� �޴� END
				else if(ch1==2) {
					System.out.println("�л����� ���� �޴�");
					System.out.print("������ �л� ��ȣ�� �Է��ϼ���. >");
					int findNum = scanner.nextInt();
					
					int studentsIndexCount = 0;
					for(Student tmp : students) {	// students �迭���� �ش� ��ȣ�� �л� �˻� �� ����
						if(tmp!=null && tmp.getNum()==findNum) {
							System.out.println(findNum+"�� �л� ���� ���� �Ϸ�.");
							students[studentsIndexCount]=null;
							break;	// �ش� ��ȣ�� �л��� �Ѹ�ۿ� ������ �׸� �˻��ϰ� �ݺ��� Ż��
						}
						studentsIndexCount++;	
					}	// students �迭���� �ش� ��ȣ�� �л� �˻� �� ���� END
					
					for(int i=studentsIndexCount; i<students.length; i++) {	// �� �ݺ������� �����ϸ� �迭�� �̻�����ä�� ���µ� ������ ��ĭ�� �� �����ִ� �ݺ��� ����
						if(i==students.length-1) {	// ���� ������ �ε����� ã���� ������ null�� �ְ� �ݺ��� Ż��
							students[i]=null;
							break;
						}
						students[i] = students[i+1];	// �ڿ� �ִ� ����Ÿ�� ������ ��ĭ�� ����. ���̵� ������ �������.
					}	// �迭���� ��ĭ ���ִ� �ݺ��� END
				}	// �л� ���� ���� �޴� END
				else
					System.out.println("��ȣ�� Ȯ���ϼ���.");
				
			}catch(Exception e) {	// ���� �߻��� ����
				System.out.println("���ܹ߻�! �ʱ�Ŵ��� ���ư��ϴ�.");
				System.out.println(e);
				scanner = new Scanner(System.in);	// ��ĳ�ʿ� �߸��� ���� ����Ÿ �������� ����� ��ĳ�� �޸� �ʱ�ȭ
			}	// catch END
		}	// while END
	}	// main END
}	// class END
