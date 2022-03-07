package Day05_220307;

import java.util.Scanner;

public class Day05_03 {	//c s
	public static void main(String[] args) {	// m s
		
		//연습문제 7
		////////////////////////////////////////

		int max = 0;	// 최대값 저장하는 변수
		int[] array = {1, 5, 3, 8, 2};	// 배열 선언 + 초기값
		// P. 182 연습문제7 정답 작성구간
		////////////////////////////////////////
	
		for(int i=0; i<array.length; i++) {
			if(max<array[i])
				max = array[i];
		}
		////////////////////////////////////////
		////////////////////////////////////////


		System.out.println(+max);
		
		
		// 연습문제 8
		////////////////////////////////////////
		int[][] arr2 = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88},
		};
		int sum = 0;
		double avg=0.0;
		
		// P.182 연습문제8 정답 작성구간
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

		
		// 예제 9번
		boolean run = true;	// while문 스위치 변수
		int studentNum = 0;	// 학생문 변수
		int[] scores = null;	// 점수 배열을 선언만 해둠.(길이 지정이나 초기화는 안함.)
		Scanner scanner = new Scanner(System.in);	// 스캐너
		
		while(run) {
			System.out.println("--------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("--------------------------------");
			System.out.println("선택>");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo==1) {
				System.out.print("학생수> ");
				studentNum=scanner.nextInt();
				scores = new int[studentNum];	// 윗 라인에서 입력받은 수 만큼 배열 길이 변경, 
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
				int maxscore=0;	// 최고점수 저장하는 변수
				float avgscore=0.0f;	// 평균 저장하는 변수
				for(int i=0; i<scores.length; i++) {
					if(maxscore<scores[i])
						maxscore=scores[i];
					avgscore+= scores[i];	// 평균 저장하는 변수에 임시로 총 합계 저장
				}
				avgscore=avgscore/scores.length;	// 평균 저장하는 변수에 지금 총 합계 저장되어있으므로 총 개수로 나눈값을 저장
				System.out.println("최고점수: "+maxscore);
				System.out.printf("평균점수: %.1f\n",avgscore);
			}
			else if(selectNo==5) {
				run=false;
					// while문 조건에 true넣고, break; 주는것과 같다.
			}
			
		}	//while end
		System.err.println("프로그램 종료.");
	}	// m e
}	// c e
