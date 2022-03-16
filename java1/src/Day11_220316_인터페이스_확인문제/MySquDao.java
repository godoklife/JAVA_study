package Day11_220316_인터페이스_확인문제;

public class MySquDao implements DataAccessObject{
	@Override
	public void select() {
		System.out.println("MySql DB에서 검색");
	}
	@Override
	public void insert() {
		System.out.println("MySql DB에서 삽입");
		
	}
	@Override
	public void update() {
		System.out.println("MySql DB에서 수정");
		
	}
	@Override
	public void delete() {
		System.out.println("MySql DB에서 삭제");
		
	}
}
