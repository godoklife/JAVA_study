package ���迬��;

import java.util.Scanner;

public class ���迬��1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Student[] student = new Student[100];
		while(true) {
			try {
				
				//�����ű�ºκ�
				
				
				
				
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("\t\t��\t��\tǥ\t\t\t");
				System.out.println("-------------------------------------------------------------------------");
				System.out.println(" ��ȣ\t�̸�\t����\t����\t����\t����\t���\t����");
				System.out.println("-------------------------------------------------------------------------");
				for(Student tmp : student) {
					if(tmp!=null) {
						System.out.printf("%d\t%3s\t%d\t%d\t%d\t%d\t%.1f\n",tmp.getNum(),tmp.getName(),
								tmp.getKor(),tmp.getEng(),tmp.getMath(), tmp.getSum(), tmp.getAvg());
					}
				}
				
				System.out.print("1. ���� �߰� | 2. ���� ���� \n ���� >");
				int ch = scanner.nextInt();
				if(ch==1) {
					boolean isPointIsRight=true;
					System.out.println("========== �л� ���� �߰� �Ŵ� ==========");
					System.out.print("��ȣ �Է� : ");
					int num=scanner.nextInt();
					System.out.print("�̸� �Է� : ");
					String name=scanner.next();
					System.out.print("�������� �Է� : ");
					int kor=scanner.nextInt();
					System.out.print("�������� �Է� : ");
					int eng=scanner.nextInt();
					System.out.print("�������� �Է� : ");
					int math=scanner.nextInt();
					int sum= kor+eng+math;
					double avg = (kor+eng+math)/3.0;
					if(kor<1 || kor>100 || eng<1 || eng>100 || math<1 || math>100) {
						System.out.println("������ �߸� �ԷµǾ����ϴ�. �ٽ� �Է��ϼ���.");
						isPointIsRight=false;
					}
					if(isPointIsRight == true) {
						Student newStudent = new Student(name, num, kor, eng, math, sum, avg, 0);
						int i=0;
						for(Student tmp2 : student) {
							if(tmp2==null) {
								student[i]=newStudent;
								break;
							}
							i++;
						}
					}
				}
				else if(ch==2) {
					System.out.println("========== �л� ���� �߰� �Ŵ� ==========");
					
				}
				else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
				}
				catch(Exception e) {
				System.out.println("���ܹ߻�. �ʱ� �Ŵ��� ���ư��ϴ�.");
				System.out.println(e);
				scanner = new Scanner(System.in);
				}
		}	// while END
		
		
	}	// main END
}	// class END