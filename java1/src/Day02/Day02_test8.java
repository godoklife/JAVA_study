package Day02;
import java.util.Scanner;

public class Day02_test8 {
	public static void main(String[] args) {
		System.out.println("�� �Ǽ��� �Է¹޾� �� �Ǽ��� ���� ���� ���� �� %���� ����ϱ�");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�Ǽ��� �Է��Ͻÿ� : ");
		float float1 = scanner.nextFloat();
		
		System.out.println("���� �Ǽ��� �Է��Ͻÿ� : ");
		float float2 = scanner.nextFloat();
		
		double ���� = (float1 / float2) * 100;
		
		System.out.printf("�ϼ�1�� �Ǽ�2 ����� : %.2f %%\n", ����);	// �Ҽ� ��°�ڸ����� ǥ��
		
		System.out.println("ó�� �Է��� �Ǽ��� �ι�° ���� " + ((float1/float2)*100f) + "% �Դϴ�.");
		
		scanner.close();
		
	}
}
