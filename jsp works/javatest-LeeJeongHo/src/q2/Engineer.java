package q2;

class Employee {
	private String name;
    public int age;

    public Employee(String name){
    	this.name = name;
    }
}

public class Engineer extends Employee {
	
//	해결방법
//	부모 Employee 클래스는 객체 생성시 필수로 요구하는 name 매개변수가 있다
//	자식 Engineer 클래스 또한 생성자로 해당 매개변수를 받고 super를 통해 넘겨줘야함
	public Engineer(String name) {
		super(name);
	}

	private String skillset;

    public String getSkillSet(){
    	return skillset;
    }
    
    public void setSkillSet(String skillset){
    	this.skillset = skillset;
    }
}

// 