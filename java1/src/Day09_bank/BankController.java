package Day09_bank;

import java.util.Random;

public class BankController {
	// 이 클래스는 은행 관련 컨르롤러
	// M : 모델 	[ 데이터 ]
	// V : 뷰 	[ 입출력 ] 
	// C : 모델과 뷰 연결 역할
	
	// 컨트롤러의 주 역할 : 뷰에서 요청하는 서비스[기능] 제공
		// 1. 계좌 생성 [C]
	public String 계좌생성(String password, String name, int bankno) {
			// Day09_6_은행계좌프로그램 의 String 계좌번호 = controll.계좌생성(password, name, bankno);
			// 에서 전달받은 password, name, bankno를 가지고 메서드 실행됨.
		// 1. 입력받은 값을 가져온다. [ 인수 ]
			// 계좌번호 자동 생성
		String 계좌번호;
		while(true) {
			Random random = new Random();	// 임의의 수 생성하는 클래스
			// 4자리 생성(0~9999)
			int 난수 = random.nextInt(10000);		// 1만개의 수, 0~9999 사이의 수 랜덤으로 한개 픽
			계좌번호 = String.format("%04d", 난수);
										// 문자형식 변경
											// %d : 정수
											// %4d : 4개의 정수를 출력(빈자리는 공백처리)
											// %04d: 4개의 정수를 출력(빈자리는 0으로 처리)
			// 계좌번호 중복체크
			boolean 계좌번호중복체크 = false;
			for(Bank tmp2 : Day09_6_은행계좌프로그램.accountList) {
				if(tmp2!=null && tmp2.getAnumber().equals(계좌번호)) {
					계좌번호중복체크 = true;
				}else {
					계좌번호중복체크 = false;
				}
			}	
			if (계좌번호중복체크== false) {
				break;
			}
		}
		
		// 2. 객체화 [ 다수의 변수를 하나의 객체로 만들기 = 하나의 파일로 압축한다 ]
		Bank tmp=null;	// 깡통 객체 선언
		if(bankno == 1) {	// 만약 은행번호가 1이면
			tmp = new KookminBank(계좌번호, password, name);	// tmp를 국민은행 클래스의 객체로 생성.
		}else if(bankno == 2) {	// 은행번호가 2이면
			tmp = new ShinhanBank(계좌번호, password, name);	// tmp를 ShinhanBank 클래스의 객체로 생성
		}else if(bankno == 3) {	// 은행번호가 3이면
			tmp = new HanaBank(계좌번호, password, name);		// tmp를 HanaBank 클래스의 객체로 생성.
		}
		
		// 3. 배열에 저장 
		int i=0;	// 인덱스 저장용 임시 변수
		for(Bank tmp2 : Day09_6_은행계좌프로그램.accountList) {
			if(tmp2 ==null) {
				Day09_6_은행계좌프로그램.accountList[i]=tmp;
				return 계좌번호;	// 계좌 생성 성공하였으므로 
			}
		i++;	// 인덱스 카운트
		}	// 배열에 저장하는 for문 END
		
		return null;	// 계좌 생성 실피하면 null 반환.
	}	// 계좌생성이 성공하면 계좌번호 , 실패하면 null
		
	// 2. 입금
	public boolean 입금() {return false;}		// 일단 기능 구성이 안됐으므로 
		// 3. 출금
	public boolean 출금() {return false;}
		// 4. 이체
	public boolean 이체() {return false;}
		// 5. 내 계좌목록
	public Bank[] 내계좌목록(String name) {		// 동일한 계좌주의 계좌를 찾아서 배열에 담아 리턴하기.
			// 리턴값 : Bank 형식의 배열
		
		Bank[] 내계좌 = new Bank[100];	// 1. 배열 생성
		for(Bank tmp : Day09_6_은행계좌프로그램.accountList) {	// 어카운트리스트를 템프에 임시로 옮김
			int i=0;	// 인덱스 카운트
			if(tmp!= null && tmp.getName().equals(name)) {	// tmp에 담긴게 null이 아니면서 name과 일치하면
				for(Bank tmp2 : 내계좌) {
					if(tmp2 == null) {
						내계좌[i] = tmp;
						break;
					}
					i++;
				}
			}
		}
		
		return null;
		}
		// 6. 대출
	public boolean 대출() {return false;}
	
	
	
	
	
}
