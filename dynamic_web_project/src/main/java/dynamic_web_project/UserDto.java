package dynamic_web_project;

public class UserDto {
	private int 회원번호;
	private String 회원아이디;
	private String 회원비밀번호;
	private String 회원이름;
	private String 회원이메일;
	public UserDto() {}
	public int get회원번호() {
		return 회원번호;
	}
	public void set회원번호(int 회원번호) {this.회원번호 = 회원번호;}
	public String get회원아이디() {return 회원아이디;}
	public void set회원아이디(String 회원아이디) {this.회원아이디 = 회원아이디;}
	public String get회원비밀번호() {return 회원비밀번호;}
	public void set회원비밀번호(String 회원비밀번호) {this.회원비밀번호 = 회원비밀번호;}
	public String get회원이름() {return 회원이름;}
	public void set회원이름(String 회원이름) {this.회원이름 = 회원이름;}
	public String get회원이메일() {return 회원이메일;}
	public void set회원이메일(String 회원이메일) {this.회원이메일 = 회원이메일;}
}
