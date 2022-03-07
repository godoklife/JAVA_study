package Day05_220307;

public class Day05_01 {	// c s
	public static void main(String[] args) {	// m s
		
		// 변수 : 하나의 데이터를 저장.
		// 배열 : 동일한 자료형의 데이터를 특정 기준(인덱스)으로 나열한것.
			// 요즘엔 DB를 거의 100% 사용하기 때문에 배열의 활용도가 떨어지나 알기는 알아야함. 기초상식
		// 1차원 배열 : 가로
			// 형태 : 자료형[] 배열명 = new 자료형[길이]
			// ex. int[] arr = new arr[3];
			// int int int
			// * int형 변수 3개를 저장할 수 있는 배열
		
		// 2차원 배열 : 가로, 세로
			// 형태 : 자로형[][] 배열명 = new 자료형[행][열]
			// ex. int[][] arr2 = new int[2][3];
			//	int int int
			// 	int int int
			// * int형 변수 6개를 저장할 수 있는 배열
		
		// 3차원 배열 : 가로, 세로, 깊이
			// 형태 : 자료형[][][] 배열명 = new 자료형[가로][세로][깊이]
			// 텍스트로는 표현 못함(3차원을 텍스트로 어캐표현??)
			// * int형 변수 
		
		
		
		
		
		
		
		// 예제1) 
		int[] arr = new int[3];	// int : 4바이트, 4바이트*3칸 = 12바이트의 배열 생성.
		arr[0] = 80;
			// * 0번 인덱스에 80 데이터를 대입.
		arr[1] = 90;
		arr[2] = 100;
		
		int[][] arr2 = new int[4][5];	// [행][열], 4바이트*2행*3열 = 24바이트의 배열 생성.
		arr2[0][0] = 80;
		arr2[0][1] = 90;
		arr2[0][2] = 100;
		arr2[1][0] = 40;
		arr2[1][1] = 50;
		arr2[1][2] = 60;
		arr2[3][4] = 2;
		
		System.out.println("1차원 배열 인덱스 없이 이름만 호출 : "+arr);
		System.out.println("2차원 배열 인덱스 없이 이름만 호출: "+arr2);
		
		System.out.println("1차원 배열 길이 : "+arr.length);	// arr의 길이 호출
		System.out.println("2차원 배열 행 길이 : "+arr2.length);	// arr2의 행 길이 호출
		System.out.println("2차원 배열 열 길이 : "+arr2[2].length);	// arr2의 열 길이 호출
		
		
		// 예제2) 반복문을 이용해 0~49까지 첫번째 행에 저장
			// 50~99까지 두번째 행에 저장하는 2차원 배열 선언
		
		int[][] arr3 = new int[2][50];	// 4byte*2행*50열 = 400바이트의 배열 선언
		
		// 배열의 저장 반복문
		for(int i=0; i<100; i++) {	
			// * i는 0부터 100미만까지 1씩 증가하며 실행 -> 총 100회 실행
			if(i<50)	// i가 50개 미만이면 0번 행에 저장
				arr3[0][i] = i;
			else	// i가 50개 이상이면 1번 행에 저장
				arr3[1][i-50] = i;
		}
		
		// 배열의 출력 반목문
		for(int i=0; i<2; i++) {
			for(int j=0; j<arr3[0].length; j++) {
				System.out.printf("%3d", arr3[i][j]);
				if(j==49)
					System.out.println("");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}	// m e
}	// c e
