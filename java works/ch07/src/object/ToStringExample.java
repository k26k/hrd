package object;

public class ToStringExample {

	public static void main(String[] args) {
//		toString method 객체의 정보를 문자열로 출력하는 함수
		String name = new String("오상식"); // String 클래스의 name 객체를 생성
		System.out.println(name);
		System.out.println(name.toString());
		
		Book book = new Book(12, "개미");
		System.out.println(book.toString());
		
	}

}
