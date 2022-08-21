package statics;

public class StudentTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student2 lee = new Student2();
		lee.setName("이대한");
		
//		System.out.println(student2.serialNum); // private가 붙은 애들은 직접 접근할 수 없음
		System.out.println(lee.getId()); // 이렇게 클래스의 메소드를 통해 접근 가능
		System.out.println(lee.getName());
		
		Student2 han = new Student2();
		han.setName("한지수");
		System.out.println(han.getId());
		System.out.println(han.getName());
	}

}
