package reference;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student lee = new Student(1001, "이양파");
		
		lee.koreanSubject("국어", 90);
		lee.mathSubject("수학", 80);
		lee.showInfo();
		
		Student han = new Student(1001, "한대파");
		
		han.koreanSubject("국어", 70);
		han.mathSubject("수학", 75);
		han.showInfo();
		
	}

}
