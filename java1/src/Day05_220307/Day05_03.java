package Day05_220307;

import java.util.Scanner;

public class Day05_03 {	//c s
	public static void main(String[] args) {	// m s
		
		//�������� 7
		////////////////////////////////////////

		int max = 0;	// �ִ밪 �����ϴ� ����
		int[] array = {1, 5, 3, 8, 2};	// �迭 ���� + �ʱⰪ
		// P. 182 ��������7 ���� �ۼ�����
		////////////////////////////////////////
	
		for(int i=0; i<array.length; i++) {
			if(max<array[i])
				max = array[i];
		}
		////////////////////////////////////////
		////////////////////////////////////////


		System.out.println(+max);
		
		
		// �������� 8
		////////////////////////////////////////
		int[][] arr2 = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88},
		};
		int sum = 0;
		double avg=0.0;
		
		// P.182 ��������8 ���� �ۼ�����
		////////////////////////////////////////
		int count=0;
		
		for(int i=0;i<arr2.length; i++) {
			for(int j=0;j<arr2[i].length;j++) {
				sum+=arr2[i][j];
				count++;
			}
			count+=arr2.length;
		}
		avg=sum/(double)count;
		////////////////////////////////////////
		System.out.println("sum : "+sum);
		System.out.println("avg : "+avg);
		////////////////////////////////////////
		////////////////////////////////////////

		
		// ���� 9��
		boolean run = true;	// while�� ����ġ ����
		int studentNum = 0;	// �л��� ����
		int[] scores = null;	// ���� �迭�� ���� �ص�.(���� �����̳� �ʱ�ȭ�� ����.)
		Scanner scanner = new Scanner(System.in);	// ��ĳ��
		
		while(run) {
			System.out.println("--------------------------------");
			System.out.println("1. �л��� | 2. �����Է� | 3. ��������Ʈ | 4. �м� | 5. ����");
			System.out.println("--------------------------------");
			System.out.println("����>");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo==1) {
				System.out.print("�л���> ");
				studentNum=scanner.nextInt();
				scores = new int[studentNum];	// �� ���ο��� �Է¹��� �� ��ŭ �迭 ���� ����, 
			}
			else if(selectNo==2) {
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d]>",i);
					scores[i]+=scanner.nextInt();
				}
			}
			else if(selectNo==3) {
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d] : %d\n", i, scores[i]);
				}
			}
			else if(selectNo==4) {
				int maxscore=0;	// �ְ����� �����ϴ� ����
				float avgscore=0.0f;	// ��� �����ϴ� ����
				for(int i=0; i<scores.length; i++) {
					if(maxscore<scores[i])
						maxscore=scores[i];
					avgscore+= scores[i];	// ��� �����ϴ� ������ �ӽ÷� �� �հ� ����
				}
				avgscore=avgscore/scores.length;	// ��� �����ϴ� ������ ���� �� �հ� ����Ǿ������Ƿ� �� ������ �������� ����
				System.out.println("�ְ�����: "+maxscore);
				System.out.printf("�������: %.1f\n",avgscore);
			}
			else if(selectNo==5) {
				run=false;
					// while�� ���ǿ� true�ְ�, break; �ִ°Ͱ� ����.
			}
			
		}	//while end
		System.err.println("���α׷� ����.");
	}	// m e
}	// c e
