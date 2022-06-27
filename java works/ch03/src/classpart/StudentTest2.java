package classpart;

public class StudentTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		클래스 선언
		Student std1 = new Student();
//		student의 멤버에 접근시 . 연산자 이용
		std1.studentId=100;
		std1.studentName="다있소";
		
		System.out.println("학번 : "+std1.studentId);
		System.out.println("이름 : "+std1.studentName);
		
		Student std2 = new Student();
		std1.studentId=101;
		std1.studentName="장그래";
		
		System.out.println("학번 : "+std1.studentId);
		System.out.println("이름 : "+std1.studentName);
		
//	 	클래스는 한번 만들어두면 여러개를 선언해서 이용할수있음
	}

}
