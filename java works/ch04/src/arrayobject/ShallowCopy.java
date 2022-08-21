package arrayobject;

public class ShallowCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book[] array1 = new Book[3];
		Book[] array2 = new Book[array1.length];
		
		array1[0] = new Book("혼공 자바", "신형곤");
		array1[1] = new Book("반응형 웹", "나잘난");
		array1[2] = new Book("스프링부트", "잘난");
		
//		이렇게 복사하면 메모리 위치값이 같아서 객체 하나의 요소를 변경하면 같은 메모리를 공유하는 객체들의 요소도 변경됨 
		System.arraycopy(array1, 0, array2, 0, array1.length);
		
//		for(int i=0; i<array1.length; i++) {
//			array2[i] = new Book(array1[i].getbookName(), array1[i].getAuthor()); 
//		}
		
		for(int i=0; i<array1.length; i++) {
			array2[i] = new Book();
			array2[i].setbookName(array1[i].getbookName());
			array2[i].setAuthor(array1[i].getAuthor());
		}
//		이렇게 하면 다른 메모리 주소에 생성된 인스턴스에 요소의 데이터만 복사해서 넣을수 있음
		
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
		
		array1[0].setbookName("혼자 공부하는 java");
		array1[1].setAuthor("김광수");
		
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
