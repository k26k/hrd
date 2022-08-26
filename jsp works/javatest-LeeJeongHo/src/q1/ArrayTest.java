package q1;

public class ArrayTest {
	public static void main(String[] args) {
		
		//이름 10개를 저장할 배열 생성
		String[] name = new String[10];
		
		//제품 10개를 저장할 배열 생성
//		Product 클래스 없이 Product 클래스 배열을 선언해서 오류 발생
//		해결방법으로 Product 클래스를 선언해줌
		Product[] product = new Product[10];

	}

}

// 해결방법
class Product {}	

