package method;

public class SayHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sayHello();
		sayHelloName("sk");
	}
	
//	void = 반환값이 없음
	public static void sayHello() {
		System.out.println("hello");
	}
//	stacic을 사용하는 이유 객체(클래스 사용하지 않음) 생성을 하지 않으므로
	
	public static void sayHelloName(String name) {
		System.out.println("hello"+name);
	}
}
