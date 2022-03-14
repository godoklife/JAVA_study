package Day09_bank;

import java.util.Random;

public class BankController {
	// 이 클래스는 은행 관련 컨트롤러
		// 계산만 하고 입력, 줄력 기능 X
	
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
		// 계좌생성이 성공하면 계좌번호 , 실패하면 null
	}	
		
	// 2. 입금
	public boolean 입금(String 계좌번호, int 입금액) {
		// 1. 동일한 계좌가 있으면 입금 실행
		int i=0;	// 인덱스 카운트
		for(Bank tmp : Day09_6_은행계좌프로그램.accountList) {
			if(tmp.getAnumber().equals(계좌번호) && tmp!=null) {	// 만약 입력한 계좌번호가 존재한다면
				Day09_6_은행계좌프로그램.accountList[i].setAmoney(tmp.getAmoney()+입금액);
												// 필드를 private처리 했으므로 set, get 사용해야함.
				return true;
			}
			i++;
		}
		// 2. 동일한게 없으면 실패 
		
		
		
		return false;
	}	// 입금 END
	
		// 3. 출금
	public int 출금(String 계좌번호, String 비밀번호, int 출금액) {
		
		// 1. 계좌번호와 비밀번호를 받아서
		// 2. 일치 여부 확인
		// 3. 잔고 확인 후 출금처리
		int i=0;
		for(Bank tmp : Day09_6_은행계좌프로그램.accountList) {
			if(tmp!=null && tmp.getAnumber().equals(계좌번호) && tmp.getPassword().equals(비밀번호))	{
				if(tmp.getAmoney() < 출금액) {
					return 1;	// 1: 잔액이 부족합니다. 의미 부여.
				}else {
					Day09_6_은행계좌프로그램.accountList[i].setAmoney(tmp.getAmoney()-출금액);
					return 2;	// 2: 출금 성공. 의미 부여.
				}
			}
			i++;
		}
		
		return 3;	// 3: 동일한 정보가 없음. 의미 부여
	}	// 출금 END
	
		// 4. 이체
	public int 이체(String 계좌번호, String 비밀번호, int 이체금액, String 이체계좌) {
		// 1. 동일한 계좌번호, 비밀번호 검색
		// 2. 받는 계좌 찾기
		// 3. 잔고가 이체금액만큼 있는지 확인
		// 4. 이체계좌에 이체금액 더하고, 계좌번호에 이체금액 빼기
		// * 리턴값 경우의 수 1. 성공 2. 실패(본인계좌 미스, 비번, 상대방계좌, 잔고) 
		
		int i=0;
		for(Bank tmp : Day09_6_은행계좌프로그램.accountList) {
			if(tmp!=null && tmp.getAnumber().equals(계좌번호) && tmp.getPassword().equals(비밀번호)) {
				int j=0;
				if(tmp.getAmoney()<이체금액) {
					return 2;	// 잔액 부족
				}else{	// 내 계좌 맞고, 비번 맞고, 잔액 충분하니 상대방 계좌 검색.
					for(Bank tmp2 : Day09_6_은행계좌프로그램.accountList) {
						if(tmp2!=null && tmp2.getAnumber().equals(이체계좌)) {
							Day09_6_은행계좌프로그램.accountList[i].setAmoney(tmp.getAmoney()-이체금액);	// 보내는 사람 계좌에서 이체금액만큼 삭제
							Day09_6_은행계좌프로그램.accountList[j].setAmoney(tmp2.getAmoney()+이체금액);	// 받는 사람 계좌에 이체금액 더하기
							return 1;	// 정상 완료.
						}
						j++;	// 받는 사람 인덱스 카운트 업
					}
				}
			}	// if(계좌맞고 비번 맞을경우) END
			else if(tmp!=null && tmp.getAnumber().equals(계좌번호) && !(tmp.getPassword().equals(비밀번호))) {
				return 3;	// 비밀번호가 일치하지 않습니다.
			}	// else if(비번 다를경우) END
			i++;
		}	// for END
		return 4;
	}	// 이체 END
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
		
		return 내계좌;
		}
		// 6. 대출
	public boolean 대출() {return false;}
	
	
}
