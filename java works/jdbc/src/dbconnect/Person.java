package dbconnect;

public class Person {
	
	private String userId;
	private String userPw;
	private String name;
	private int age;
	
	String getUserId() {
		return userId;
	}
	void setUserId(String userId) {
		this.userId = userId;
	}
	
	String getUserPw() {
		return userPw;
	}
	void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	
}
