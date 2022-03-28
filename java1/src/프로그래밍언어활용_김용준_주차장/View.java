package ���α׷��־��Ȱ��_�����_������;

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
		DecimalFormat decimalFormat = new DecimalFormat("#,##0��");
		
		
		// �׽�Ʈ�� �ʵ�
		LocalDate testDate1 = LocalDate.of(2022, 03, 28);
		LocalTime testTime1 = LocalTime.of(11, 22);
		Parking parkingtest1 = new Parking("11��1111", testTime1, null, testDate1, 0);
		con.parkingList.add(parkingtest1);
		LocalDate testDate2 = LocalDate.of(2022, 03, 28);
		LocalTime testTime2 = LocalTime.of(11, 25);
		Parking parkingtest2 = new Parking("22��2222", testTime2, null, testDate2, 0);
		con.parkingList.add(parkingtest2);
		LocalDate testDate3 = LocalDate.of(2022, 03, 28);
		LocalTime testTime3 = LocalTime.of(11, 26);
		Parking parkingtest3 = new Parking("33��3333", testTime3, null, testDate3, 0);
		con.parkingList.add(parkingtest3);
		LocalDate testDate4 = LocalDate.of(2022, 03, 28);
		LocalTime testTime4 = LocalTime.of(11, 56);
		Parking parkingtest4 = new Parking("44��4444", testTime4, null, testDate4, 0);
		con.parkingList.add(parkingtest4);
		LocalDate testDate5 = LocalDate.of(2022, 03, 28);
		LocalTime testTime5 = LocalTime.of(12, 31);
		Parking parkingtest5 = new Parking("33��7415", testTime5, null, testDate5, 0);
		con.parkingList.add(parkingtest5);
		// �׽�Ʈ�� �ʵ� ��
		
		while(true) {	// ���α׷� ���� ���� ����
			try {
				System.out.printf("\n------------------------------------ ���� ��Ȳ ǥ ------------------------------------\n\n");
				System.out.printf("\t\t\t���� �ð� : %s\n\n",nowDateTime.format(nowdateFormatter));
				System.out.printf("\t��¥\t\t������ȣ\t\t�����ð�\t\t�����ð�\t\t�ݾ�\n");
				// �迭 �� �ɹ� ��¿� �ݺ���
				for(Parking tmp : con.parkingList) {
					if(tmp.getOutTime()==null)
						System.out.printf("\t%s\t%s\t\t%s\t\t%s\t\t%s\n", tmp.getDate(), tmp.getCarNum(), tmp.getInTime().format(timeFormatter), 
								"���� ��", "���� ��");
					else if(tmp.getOutTime()!=null)
						System.out.printf("\t%s\t%s\t\t%s\t\t%s\t\t%s\n", tmp.getDate(), tmp.getCarNum(), tmp.getInTime().format(timeFormatter), 
								tmp.getOutTime().format(timeFormatter), decimalFormat.format(tmp.getPay()));
				}
				System.out.printf("-----------------------------------------------------------------------------------\n\n");
				System.out.printf("\t\t\t\t1. ����\t2. ����\n");
				System.out.printf("���� >");
				String ch = scanner.next();
				
				if(ch.equals("1")) {	// ���� �Ŵ�
					System.out.print("�����ϴ� ���� ��ȣ�� �Է��ϼ��� : ");
					String carNum = scanner.next();
					boolean inCarResult = con.inCar(carNum);
						// ��Ʈ�� class inCar �޼���� ������ȣ�� �μ��� ���� �� ���ϰ��� boolean������ ����
					if(inCarResult) {	// ���ϰ��� true�̸�
						System.out.println(carNum+" ������ ������ �Ϸ�Ǿ����ϴ�.");
					}
					else	// ���ϰ��� true�� �ƴϸ� (= ������ȣ�� �ߺ��̸�)
						System.out.println("�ش� ������ �̹� �����Ǿ��ֽ��ϴ�.");
				}
				
				else if(ch.equals("2")) {
					System.out.print("�����Ͻ� ���� ��ȣ�� �Է��ϼ��� : ");
					String carNum = scanner.next();
					int outCarResult = con.outCar(carNum);
					if(outCarResult>0) {
						System.out.println(carNum+" ���� ���� �Ϸ�.");
						System.out.printf("�̿����� %8d �� �Դϴ�.", outCarResult);
					}
					else if(outCarResult==0) {
						System.out.println("ȸ�� �����Դϴ�. �����Ͻ� �ݾ��� �����ϴ�.");
					}
					else {
						System.out.println("���� �߻�. �����ڿ��� ���� ���.");
					}
					
				}
				else System.out.println("�߸� �����̽��ϴ�.");
				
				
			} catch (Exception e) {System.out.println(e);}
		}	// w e
	}	// m e
}	// c e 
