package ���迬��;

public class ���迬��_�л� {
	// 1. �ʵ�
	private String name;
	private int num;
	private int kor;
	private int eng;
	private int math;
	
	
	// 2. ������
		public ���迬��_�л�(String name, int num, int kor, int eng, int math) {
		this.name = name;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public ���迬��_�л�() {
	}
	
	// 3. �޼���

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
