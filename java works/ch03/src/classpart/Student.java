package classpart;

public class Student {
//	필드(멤버변수)
	int studentId;
	String studentName;
	
//	기본생성자 - 객체의 초기화, 생략가능
//	클래스 이름과 같으나 함수는 아님, 반환값이 없음
	Student(){
		studentId=0;
		studentName="OOO";
	}
	
//	메소드(public - 접근제한자)
	public void showInfo() {
		System.out.println(studentId + ", " + studentName);
	}
}
