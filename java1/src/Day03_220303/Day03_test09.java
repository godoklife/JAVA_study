package Day03_220303;
import java.util.Scanner;

public class Day03_test09 {
	public static void main(String[] args) {
		System.out.println("[ ����9 ] ����, ����, ���� �Է¹ޱ�");
		
		int kor, eng, math;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���� ���� �Է� : ");
		kor = scanner.nextInt();
		
		System.out.println("���� ���� �Է� : ");
		eng = scanner.nextInt();
		
		System.out.println("���� ���� �Է� : ");
		math = scanner.nextInt();
		
		if((kor+eng+math)/3>=90) {
			if(kor==100) System.out.println("���� ���");
			if(eng==100) System.out.println("���� ���");
			if(math==100) System.out.println("���� ���");
			System.out.println("��� 90�� �̻�");
		}
		else if((kor+eng+math)/3>=80) {
			if(kor>=90) System.out.println("���� ���");
			if(eng>=90) System.out.println("���� ���");
			if(math>=90) System.out.println("���� ���");
			System.out.println("��� 80�� �̻�");
		}
		else System.out.println("�����");
		
	scanner.close();
	}
}
