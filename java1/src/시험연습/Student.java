package 시험연습;

public class Student {
	// 1. 필드
	private String name;
	private int num;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private int rank;
	
	
	// 2. 생성자
	
	public Student(String name, int num, int kor, int eng, int math, int sum, double avg, int rank) {
		this.name = name;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = sum;
		this.avg = avg;
		this.rank = rank;
	}

	public Student() {
	}
	
	// 3. 메서드

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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
}
