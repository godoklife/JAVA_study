package Day18_220325_결석3;

public class Wating {
	// 1. 필드
	private int people;
	private int waitingNum;
	
	// 2. 생성자
	public Wating() {
		// TODO Auto-generated constructor stub
	}
	public Wating(int people, int waitingNum) {
		super();
		this.people = people;
		this.waitingNum = waitingNum;
	}
	
	// 3. 메서드
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getWaitingNum() {
		return waitingNum;
	}
	public void setWaitingNum(int waitingNum) {
		this.waitingNum = waitingNum;
	}
	
	
}
