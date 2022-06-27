package classpart;

public class Person {
	String name;
	float height;
	float width;
	
//	기본 생성자
	public Person() {}

//	매개변수가 있는 생성자
	public Person(String n) {
		name = n;
	}
	
//	매개변수가 있는 생성자
	public Person(String n, float h, float w) {
		name = n;
		height = h;
		width = w;
	}
	
	public void showInfo() {
		System.out.println(name+", "+height+", "+width);
	}
}
