package statics;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student lee = new Student();
		lee.setName("이대한");
		
//		System.out.println(lee.serialNum); // 스태틱이 붙은 애들은 인스턴스를 통해 접근하는걸 권하지않음
		System.out.println(Student.serialNum); // 이렇게 클래스를 통해 접근하는걸 권장
		System.out.println(lee.getName());
		
		Student.serialNum++;
		
		Student han = new Student();
		han.setName("한지수");
		System.out.println(Student.serialNum); // 이렇게 클래스를 통해 접근하는걸 권장
		System.out.println(han.getName());
	}

}
