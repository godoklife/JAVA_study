package Day19_220328;

import java.util.HashSet;
import java.util.Scanner;

public class Day19_02 {
	
	// set : �ߺ��� ���� �Ұ�
		// ��ü �� "��� �ʵ�"�� �����ϸ� �ߺ� �Ұ���.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(true) {
			System.out.println("1~45 ���ڸ� �����ϼ���.(�ߺ�X)");
			int num=scanner.nextInt();
			
			if(num<1 || num> 45) {	// �Է��� ���� 1~45 ���̸�
				System.out.println("���� ������ ������ϴ�. �ٽ� �Է��Ͻÿ�.");
			}
			else {
				set.add(num);
				System.out.println("Ȯ�� : "+set);
			}
			if(set.size() == 6)
				break;
		}
	}
}
