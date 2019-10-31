package vo;

public class UserVO {

	//유저정보를 변수로 만듦 
	private String id;
	private String password;
	private String name;
	private String phonenum;
	private boolean wish;
	
	public boolean isWish() {
		return wish;
	}
	
	public void setWish(boolean wish) {
		this.wish = wish;
	}
	
	private int grade;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
