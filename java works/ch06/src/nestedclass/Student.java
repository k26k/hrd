package nestedclass;

public class Student {

	String name;
	
	Student(String name){
		this.name = name;
	}
	
	class Score{
		
		int eng;
		int math;
		
		void showInfo() {
			System.out.println("이름: "+name+" | 영어: "+eng+" | 수학: "+math);
		}
		
	}
	
}
