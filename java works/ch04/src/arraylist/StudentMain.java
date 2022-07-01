package arraylist;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student(1001, "이양파");
		student1.addSubject("국어", 90);
		student1.addSubject("영어", 85);
		student1.addSubject("수학", 82);
		student1.showStudentInfo();
		
		Student student2 = new Student(1002, "박마늘");
		student2.addSubject("java", 90);
		student2.addSubject("js", 95);
		student2.showStudentInfo();
		
	}

}
