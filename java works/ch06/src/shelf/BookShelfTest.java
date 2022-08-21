package shelf;

public class BookShelfTest {

	public static void main(String[] args) {
		
		Queue shelfQueue = new BookShelf();
		
		shelfQueue.enQueue("반응형 웹");
		shelfQueue.enQueue("혼공 자바");
		shelfQueue.enQueue("스프링 부트");
		
		System.out.println("shelfQueue size : "+shelfQueue.getSize());
		
		System.out.println(shelfQueue.deQueue());
		System.out.println(shelfQueue.deQueue());
		System.out.println(shelfQueue.deQueue());
		
	}
	
}
