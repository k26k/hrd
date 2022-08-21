package thisExample;

class Person{
	
	String name = "";
	int age = 0;
	
	Person(){
//		this를 이용해서 해당 클래스 내의 선택자나 메소드도 이용 가능
//		Person(String name, int age)생성자를 호출해서 이용
		this("이름없음", 1);
	}
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
//	객체(클래스)를 반환하는 함수
	Person returnSelf() {
		return this;
	}
}

public class CallAnother {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person noName = new Person();
		
		System.out.println(noName.name+" "+noName.age);
		
		Person p = noName.returnSelf();
		
		System.out.println(noName);
		System.out.println(p);
		System.out.println("n "+noName.name+" "+noName.age);
		System.out.println("p "+p.name+" "+p.age);
		
		p.age = 2;
		System.out.println("n "+noName.name+" "+noName.age);
		System.out.println("p "+p.name+" "+p.age);
//		p의 age를 바꿨는데 noName의 age도 바뀜 p==noName 인듯
	}

}
