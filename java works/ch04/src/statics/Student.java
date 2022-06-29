package statics;

public class Student {
	
	static int serialNum = 100;
	int id;
	String name;
	
	public Student() {
		
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
