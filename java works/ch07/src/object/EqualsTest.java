package object;

public class EqualsTest {

	public static void main(String[] args) {
		
		String color1 = new String("빨강");
		String color2 = new String("빨강");
		
		System.out.println(color1==color2);
		System.out.println(color1.equals(color2));
		
		Book book1 = new Book(12, "개미");
		Book book2 = new Book(12, "개미");		
		Book book3 = new Book(13, "안개미");		
		
		System.out.println(book1==book2);
		System.out.println(book1.equals(book2));
		System.out.println(book1.equals(book3));
		
	}
	
}
