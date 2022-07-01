package arraylist;

import java.util.ArrayList;
import reference.Subject;

public class Student {
	
	private int studentID;
	private String studentName;
	private ArrayList<Subject> subjectsList;
	
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		subjectsList = new ArrayList<>();
	}
	
	public void addSubject(String name, int score) {
		Subject subject = new Subject();
		subject.setSubjectName(name);
		subject.setScorePoint(score);
		
		subjectsList.add(subject);
	}
	

	public void showStudentInfo() {
		System.out.printf("%d학번 %s의 성적 리스트\n", studentID, studentName);
		int sum = 0;
		double avg = 0.0;
		for(Subject s:subjectsList) {
			int v = s.getScorePoint();
			sum+=v;
			System.out.printf("%s 점수: %d\n", s.getSubjectName(), v);
		}
		avg = ((double)sum)/subjectsList.size();
		System.out.printf("총점은 %d점이고 평균 %.2f점수는 점입니다.\n\n", sum, avg);
	}
	
	
}
