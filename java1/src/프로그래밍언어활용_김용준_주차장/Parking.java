package ���α׷��־��Ȱ��_�����_������;

import java.time.LocalDate;
import java.time.LocalTime;

public class Parking {
	
	// 1. �ʵ�
	private String carNum;
	private LocalTime inTime;
	private LocalTime outTime;
	private LocalDate date;
	private int pay;
	
	// 2. ������
	public Parking() {
		// TODO Auto-generated constructor stub
	}

	public Parking(String carNum, LocalTime inTime, LocalTime outTime, LocalDate date, int pay) {
		this.carNum = carNum;
		this.inTime = inTime;
		this.outTime = outTime;
		this.date = date;
		this.pay = pay;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	
	
}