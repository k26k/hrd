package arrayobject;

public class BookArray {

	public static void main(String[] args) {
		
		Book[] library = new Book[3];	
//		for(int i=0; i<library.length; i++) {
//			library[i].showInfo();
//		}
//		for(Book b:library) {
//			b.showInfo();
//		}
//		배열 입력 전 출력
		
		library[0] = new Book("혼공 자바", "신형곤");
		library[1] = new Book("반응형 웹", "나잘난");
		library[2] = new Book("스프링부트", "잘난");
		
		for(Book b:library) {
			b.showInfo();
		}
		
		library[0].setbookName("혼자 공부하는 java");
		library[1].setAuthor("김광수");
		
		for(Book b:library) {
			b.showInfo();
		}
	}
	
}
