package arraylist;

public class Book {
	
	private String bookName;
	private String author;
	
	public Book() {
		bookName = null;
		author = null;
	}
	
	public Book(String bookName, String author) {
		// TODO Auto-generated constructor stub
		this.bookName = bookName;
		this.author = author;
	}
	
	public void setbookName(String bookName) {
		// TODO Auto-generated constructor stub
		this.bookName = bookName;
	}
	public String getbookName() {
		// TODO Auto-generated constructor stub
		return bookName;
	}
	
	public void setAuthor(String author) {
		// TODO Auto-generated constructor stub
		this.author = author;
	}
	public String getAuthor() {
		// TODO Auto-generated constructor stub
		return author;
	}
	
	public void showInfo() {
		System.out.printf(" %s, %s \n", bookName, author);
	}
}
