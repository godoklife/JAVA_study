package Day04_220304;

import java.util.Scanner;

public class Day04_02 {	// c s
	public static void main(String[] args) {	// m s
		
		// 공통변수 [ 모든 괄호 내에서 사용하는 변수들 ]
		Scanner scanner = new Scanner(System.in);	// 1. 입력 객체
		int 콜라재고 = 10; int 환타재고 = 10; int 사이다재고 = 10;	// 2. 음료수 재고
		int 콜라구매수=0; int 환타구매수 = 0; int 사이다구매수 = 0;	// 3. 장바구니
		
		// 프로그램 시작 [ 무한루프, 종료조건 X ]
		while(true) {
			System.out.println("------------매뉴------------");
			System.out.println("1. 콜라[300원] | 2. 환타 [200원] | 3. 사이다 [100원] | 4. 결제");
			System.out.println("선택> "); int 선택 = scanner.nextInt();
			
			if(선택==1) {	// 콜라 구매 s
				if(콜라재고==0) {	// 콜라 재고가 없으면 구매 불가
					System.out.println("알림) 재고가 없습니다. 재고준비중");
				}
				else {	// 콜라 재고가 있으면 구매 가능
					System.out.println("[ 콜라를 담았습니다. ]");
					콜라구매수++;
					콜라재고--;
				}
			}	// 콜라 구매 end
			else if(선택==2) {	// 환타 구매
				if(환타재고==0) {	// 환타 재고가 없으면 구매 불가
					System.out.println("알림) 재고가 없습니다. 재고준비중");
				}
				else {	// 환타 재고가 있으면 구매 가능
					System.out.println("[ 환타를 담았습니다. ]");
					환타구매수++;
					환타재고--;
				}
			}	//환타 구매 end
			else if(선택==3) {	// 사이다 구매
				if(사이다재고==0) {	// 사이다 재고가 없으면 구매 불가
					System.out.println("알림) 재고가 없습니다. 재고준비중");
				}
				else {	// 사이다 재고가 있으면 구매 가능
					System.out.println("[ 사이다를 담았습니다. ]");
					사이다구매수++;
					사이다재고--;
				}
			}	// 사이다 구매 end
			else if(선택==4) {	// 결제
				System.out.println("-----------장바구니----------");
				System.out.println("제품명\t수량\t금액");
				
				if(콜라구매수!=0)
					System.out.println("콜라\t"+콜라구매수+"\t"+콜라구매수*300);
				if(환타구매수!=0)
					System.out.println("환타\t"+환타구매수+"\t"+환타구매수*200);
				if(사이다구매수!=0)
					System.out.println("사이다\t"+사이다구매수+"\t"+사이다구매수*100);
				
				System.out.println("체품 총 결제액 : "+((콜라구매수*300)+(환타구매수*200)+(사이다구매수*100)));
				System.out.println("---------------------------");
				System.out.println("1. 결제 | 2. 취소"); int 선택2 = scanner.nextInt();
				
				if(선택2==1) {			// 1. 결제
					
				}
				else if(선택2==2) {	// 2. 취소
					System.out.println("알림) 구매 목록 지우기");
					콜라재고 += 콜라구매수;	// 콜라 재고 원상복구
					환타재고 += 환타구매수;	// 환타 재고 원상복구
					사이다재고 += 사이다구매수;	// 사이다 재고 원상복구
					
					콜라구매수 = 0;		// 장바구니 초기화
					환타구매수 = 0;		// 장바구니 초기화
					사이다구매수 = 0;	// 장바구니 초기화

				}
				else {				// 3. 그 외
					
				}
				
			}	// 결제 end
			else {
				System.err.println("알림) 알 수 없는 행동입니다."); // 시스템. 에러 .프린트 는 콘솔에서 빨간색으로 출력. 다른 차이첨은 없음
				
			}
		}	// w e
	}	// m e
}	// c e
