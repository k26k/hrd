package object;

public class Book {
	
	int bookNumber;
	String bookTitle;
	
	Book(int bookNumber, String bookTitle){
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "["+bookNumber+"]번 ["+bookTitle+"]책";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book book = (Book)obj;
			if(this.bookNumber == book.bookNumber) {
				return true;
			}
		}
		return false;
	}	
	
}
