package 프로그래밍언어활용_김용준_주차장;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Control con = new Control();
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter nowdateFormatter = DateTimeFormatter.ofPattern("yyyy - MM - dd HH:mm");
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		DecimalFormat decimalFormat = new DecimalFormat("#,##0원");
		
		
		// 테스트용 필드
		LocalDate testDate1 = LocalDate.of(2022, 03, 28);
		LocalTime testTime1 = LocalTime.of(11, 22);
		Parking parkingtest1 = new Parking("11구1111", testTime1, null, testDate1, 0);
		con.parkingList.add(parkingtest1);
		LocalDate testDate2 = LocalDate.of(2022, 03, 28);
		LocalTime testTime2 = LocalTime.of(11, 25);
		Parking parkingtest2 = new Parking("22구2222", testTime2, null, testDate2, 0);
		con.parkingList.add(parkingtest2);
		LocalDate testDate3 = LocalDate.of(2022, 03, 28);
		LocalTime testTime3 = LocalTime.of(11, 26);
		Parking parkingtest3 = new Parking("33구3333", testTime3, null, testDate3, 0);
		con.parkingList.add(parkingtest3);
		LocalDate testDate4 = LocalDate.of(2022, 03, 28);
		LocalTime testTime4 = LocalTime.of(11, 56);
		Parking parkingtest4 = new Parking("44구4444", testTime4, null, testDate4, 0);
		con.parkingList.add(parkingtest4);
		LocalDate testDate5 = LocalDate.of(2022, 03, 28);
		LocalTime testTime5 = LocalTime.of(12, 31);
		Parking parkingtest5 = new Parking("33구7415", testTime5, null, testDate5, 0);
		con.parkingList.add(parkingtest5);
		// 테스트용 필드 끝
		
		while(true) {	// 프로그램 종료 조건 없음
			try {
				System.out.printf("\n------------------------------------ 주차 현황 표 ------------------------------------\n\n");
				System.out.printf("\t\t\t현재 시간 : %s\n\n",nowDateTime.format(nowdateFormatter));
				System.out.printf("\t날짜\t\t차량번호\t\t입차시간\t\t출차시간\t\t금액\n");
				// 배열 내 맴버 출력용 반복문
				for(Parking tmp : con.parkingList) {
					if(tmp.getOutTime()==null)
						System.out.printf("\t%s\t%s\t\t%s\t\t%s\t\t%s\n", tmp.getDate(), tmp.getCarNum(), tmp.getInTime().format(timeFormatter), 
								"주차 중", "정산 전");
					else if(tmp.getOutTime()!=null)
						System.out.printf("\t%s\t%s\t\t%s\t\t%s\t\t%s\n", tmp.getDate(), tmp.getCarNum(), tmp.getInTime().format(timeFormatter), 
								tmp.getOutTime().format(timeFormatter), decimalFormat.format(tmp.getPay()));
				}
				System.out.printf("-----------------------------------------------------------------------------------\n\n");
				System.out.printf("\t\t\t\t1. 입차\t2. 출차\n");
				System.out.printf("선택 >");
				String ch = scanner.next();
				
				if(ch.equals("1")) {	// 입차 매뉴
					System.out.print("입차하는 차량 번호를 입력하세요 : ");
					String carNum = scanner.next();
					boolean inCarResult = con.inCar(carNum);
						// 컨트롤 class inCar 메서드로 차량번호를 인수로 전달 후 리턴값을 boolean형으로 저장
					if(inCarResult) {	// 리턴값이 true이면
						System.out.println(carNum+" 차량의 주차가 완료되었습니다.");
					}
					else	// 리턴값이 true가 아니면 (= 차량번호가 중복이면)
						System.out.println("해당 차량은 이미 주차되어있습니다.");
				}
				
				else if(ch.equals("2")) {
					System.out.print("출차하실 차량 번호를 입력하세요 : ");
					String carNum = scanner.next();
					int outCarResult = con.outCar(carNum);
					if(outCarResult>0) {
						System.out.println(carNum+" 차량 출차 완료.");
						System.out.printf("이용요금은 %8d 원 입니다.", outCarResult);
					}
					else if(outCarResult==0) {
						System.out.println("회차 차량입니다. 결제하실 금액은 없습니다.");
					}
					else {
						System.out.println("에러 발생. 관리자에게 문의 요망.");
					}
					
				}
				else System.out.println("잘못 누르셨습니다.");
				
				
			} catch (Exception e) {System.out.println(e);}
		}	// w e
	}	// m e
}	// c e 
