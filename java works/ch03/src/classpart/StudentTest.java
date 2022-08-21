package classpart;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		클래스 객체 사용
//		Student() = 생성자 
		Student s1 = new Student();
		s1.studentId=100;
		s1.studentName="다이소";
		s1.showInfo();
		
		Student s2 = new Student();
		s1.studentId=101;
		s1.studentName="장그래";
		s1.showInfo();
		
//		인스턴스 출력
		System.out.println(s1);
		System.out.println(s2);
//		클래스의 패키지 이름, 클래스 이름 출력, 힙메모리 주소
	}

}
