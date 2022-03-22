package 시험연습4;

import java.util.Calendar;

public class Car {
	
	// 1. 필드
	private String carNum;
	private Calendar inTime;
	private Calendar outTime;
	// 2. 생성자
	
	public Car() {}
	
	public Car(String carNum, Calendar inTime, Calendar outTime) {
		this.carNum = carNum;
		this.inTime = inTime;
		this.outTime = outTime;
	}
	// 3. 메서드

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Calendar getInTime() {
		return inTime;
	}

	public void setInTime(Calendar inTime) {
		this.inTime = inTime;
	}

	public Calendar getOutTime() {
		return outTime;
	}

	public void setOutTime(Calendar outTime) {
		this.outTime = outTime;
	}
	
	
}
