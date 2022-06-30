package arrayobject;

public class ObjectCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book[] array1 = new Book[3];
		Book[] array2 = new Book[array1.length];
		
		array1[0] = new Book("혼공 자바", "신형곤");
		array1[1] = new Book("반응형 웹", "나잘난");
		array1[2] = new Book("스프링부트", "잘난");
		
		for(int i=0; i<array1.length; i++) {
			array2[i] = array1[i];
		}
		
		for(Book b:array1) {
			b.showInfo();
			System.out.println(b);
		}
		System.out.println("");
		
		for(Book b:array2) {
			b.showInfo();
			System.out.println(b);
		}
		System.out.println("");
		
	}

}
