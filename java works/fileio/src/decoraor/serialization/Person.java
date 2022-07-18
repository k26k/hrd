package decoraor.serialization;

import java.io.Serializable;

public class Person implements Serializable{

//	버전 관리
	private static final long serialVersionUID = 1L; // long타입 선언
	
	private String name;
	private String job;
	
	public Person(String name, String job) {
		this.name = name;
		this.job = job;
	}

	@Override
	public String toString() {
		return name + ", " + job;
	}

}
