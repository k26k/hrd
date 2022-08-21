package nestedclass;

public class StudentTest {

	public static void main(String[] args) {

		Student jang = new Student("장그래");
		
//		내부의 인스턴스 클래스 객체 생성시 외부 클래스의 객체가 필요하다
		Student.Score score = jang.new Score();
		
		score.eng = 88;
		score.math = 75;
		score.showInfo();
	}

}
