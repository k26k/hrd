package reference;

public class Student {
	
	int studentID;
	String studentName;
	Subject korean;
	Subject math;
	
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.korean = new Subject();
		this.math = new Subject();
	}
	
//	수업과목 추가 메서드
	public void koreanSubject(String name, int score) {
		korean.setSubjectName(name);
		korean.setScorePoint(score);
	}
	
	public void showInfo() {
		System.out.printf("%s의 %s 점수는 %d점이고 %s 점수는 %d점\n", studentName, korean.getSubjectName(), korean.getScorePoint(), math.getSubjectName(), math.getScorePoint());
	}
	
	public void mathSubject(String name, int score) {
		math.setSubjectName(name);
		math.setScorePoint(score);
	}

//	public void setStudentID(int studentID) {
//		this.studentID = studentID;
//	}
//	
//	public int getStudentID() {
//		return studentID;
//	}
//	
//	public void setSstudentName(String studentName) {
//		this.studentName = studentName;
//	}
//	
//	public String getStudentName() {
//		return studentName;
//	}
	
}
