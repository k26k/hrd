package arraylist;

import java.util.ArrayList;

import arrayobject.Book;

public class BookList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Book> library = new ArrayList<>();
		
		library.add(new Book("혼공 자바", "신형곤"));
		library.add(new Book("반응형 웹", "나잘난"));
		library.add(new Book("스프링부트", "잘난"));
		
		for(Book l:library) {
			l.showInfo();
		}
		System.out.println("");
		
	}

}
