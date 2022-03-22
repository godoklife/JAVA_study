package 시험연습3;

import java.time.LocalDate;
import java.time.LocalTime;

public class Car {
	private LocalDate date;
	private String carNum;
	private LocalTime inTime;
	private LocalTime outTime;
	private int fee;
	
	public Car() {}
	
	public Car(LocalDate date, String carNum, LocalTime inTime, LocalTime outTime, int fee) {
		this.date = date;
		this.carNum = carNum;
		this.inTime = inTime;
		this.outTime = outTime;
		this.fee = fee;
	}

	public LocalDate getDate() {
		// 사용자가 입력한 값이 예상범위 내 인지 검증하는 코드 작성.
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public LocalTime getInTime() {
		return inTime;
	}

	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}

	public LocalTime getOutTime() {
		return outTime;
	}

	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
	
	
}
