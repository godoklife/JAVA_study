package Day04_220304;

import java.util.Random;
import java.util.Scanner;

public class Day04_03 {	// c s
	
	
	public static void main(String[] args) {	// m s
		int user;	// ����ڰ� ������ ���� ����
		int cpu;	// ��ǻ�� ������ ������ ����
		int games=0; 	// ���� ���� Ƚ�� ����
		int userwin=0;	// ����� �¸� Ƚ�� ����
		int cpuwin=0;	// ��ǻ�� �¸� Ƚ�� ����
		Scanner scanner = new Scanner(System.in);
		
		//���α׷� ���� [ ���ѷ��� ���� ���� : 3�� �Է½� ����(break) ] 
		while(true) {
			games++;
			System.out.println("------------���� ���� �� ����------------");
			System.out.println("����(0) | ����(1) | ��(2) | ����(3)");
			System.out.println("�����ϼ���>");
			user=scanner.nextInt();	// ����ڰ� �Է��� ���� ����
			System.out.println("�÷��̾ �� �� : " + user);
			
			Random random = new Random();	// ���� ��ü ����
				// random.nextInt() : int�� ǥ���� �� �ִ� ������ ���� �߻�
				// random.nextInt(��) : 0 ~ �� �̸� ���� �߻�
				// random.nextInt(5) : 5���� ����(0~4)
			cpu = random.nextInt(3);	// ������ ����(int)������ ��������
			
			// ���� �Ǵ�
			if(user==3) {
				System.out.printf("������ �����մϴ�.\n�� ���� Ƚ�� : %d, �ΰ��� �̱� Ƚ�� : %d, ��谡 �̱� Ƚ�� : %d\n", (games-1), userwin, cpuwin);
					// ���α׷� ���ڸ��� ���� Ƚ������ �ø��� �����ϱ⶧���� �� ����Ƚ�� ����Ҷ� 1ȸ �����ϰ� ���.
				if(userwin>cpuwin)
					System.out.println("�ΰ��� �¸��Դϴ�.");
				else if(userwin<cpuwin)
					System.out.println("����� �¸���.");
				else
					System.out.println("���º�");
				break;
			}
			else if(user>=4) {
				System.err.println("�߸������̽��ϴ�.");
				games--;
			}
			else if((user==0&&cpu==2)||(user==1&&cpu==0)||(user==2&&cpu==1)) {	// ����ڰ� �̱�� ����� ��
				System.out.println("�ΰ��� �̰���ϴ�");
				userwin++;
			} 
			else if (user==cpu) {	// ���� ����� ��
				System.out.println("�����ϴ�");
			}
			else {	// ��ǻ�Ͱ� �̱�� ����� ��
				System.out.println("��谡 �̰���ϴ�.");
				cpuwin++;
			}
			
		}	// w e
	}	// m e
}	//c e
