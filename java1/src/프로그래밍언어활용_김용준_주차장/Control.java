package ���α׷��־��Ȱ��_�����_������;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Control {
	
	ArrayList<Parking> parkingList = new ArrayList<>();
	LocalDate nowDate = LocalDate.now();
	LocalTime nowTime = LocalTime.now();
	
	boolean inCar(String carNum) {	// ������ ����Ǵ� �޼���
		for(Parking tmp : parkingList) {
			// 1. ������ȣ �ߺ��˻�
			if(tmp.getCarNum().equals(carNum)) 
				return false;
		}	// f e
		// 2. ������ȣ �ߺ��˻� ����� ����Ʈ�� ������ȣ, ������, �����ð� ���� ����
		Parking parking = new Parking(carNum, nowTime, null, nowDate, 0);
		parkingList.add(parking);
		return true;
	}	// inCar end
	
	int outCar(String carNum) {
		int index = 0;	// parkingList �ε��� ī��Ʈ�� ����
		int bill = -1;	
		for (Parking tmp : parkingList) {
			
			// 1. �Է¹��� ������ȣ�� ������ ����Ʈ�� �����ϰ� �����ð��� null����[=������]���� Ȯ�� ��
			if(tmp.getCarNum().equals(carNum) && tmp.getOutTime()==null) {
				bill=0;	// if���� �����ϸ� ���ϰ��� 0���� ����
				int parkedTime = (int)ChronoUnit.MINUTES.between(tmp.getInTime(), nowTime) - 30;

				if(parkedTime < 0) parkedTime=0;

				bill = 1000*(parkedTime/10);	// 10�д� 1000�� û��

				Parking parking = new Parking(carNum, tmp.getInTime(), nowTime, tmp.getDate(), bill);	// ��üȭ ��
				parkingList.set(index, parking);	// �ش� �ε����� ��ü
				return bill;	// ���� ó�� �Ϸ�.
				
			}
			index++;
		}
		return bill;	// outCar�޼��尡 bill�� �����Ҷ� �ʱⰪ�� -1 �״�θ� view���� ������� ���.
	}	// f e
}	// c e
