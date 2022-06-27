package classpart;

public class Student {
//	필드(멤버변수)
	int studentId;
	String studentName;
	
//	메소드(public - 접근제한자)
	public void showInfo() {
		System.out.println(studentId + ", " + studentName);
	}
}
