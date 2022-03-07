package Day05_220307;

public class Day05_03 {	//c s
	public static void main(String[] args) {	// m s
		
		
		int max = 0;	// 최대값 저장하는 변수
		int[] array = {1, 5, 3, 8, 2};	// 배열 선언 + 초기값
		
		for(int i=0; i<array.length; i++) {
			if(max<array[i])
				max = array[i];
		}
		
		System.out.println(+max);
		
		int[][] arr2 = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88},
		};
		
		int sum = 0;
		double avg=0.0;
		
		// P.182 연습문제8
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
		
		
	}	// m e
}	// c e
