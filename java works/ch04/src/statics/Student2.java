package statics;

public class Student2 {
	
	private static int serialNum = 100;
	private int id;
	private String name;
	
//	선언자 선언시 아이디 설정
	public Student2() {
		serialNum++;
		id=serialNum;
	}
	
//	아이디 설정
	public void setId(int id) {
		this.id = id;
	}
	
//	아이디 가져오기
	public int getId() {
		return this.id;
	}
		
//	이름 설정
	public void setName(String name) {
		this.name = name;
	}
	
//	이름 가져오기
	public String getName() {
		return this.name;
	}
	
}
