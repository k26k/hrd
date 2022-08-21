package generic.collection.queue;

import java.util.ArrayList;

public class MyQueueTest {

	public static void main(String[] args) {
		
		MyQueue myQueue = new MyQueue();
		
		myQueue.enQueue("A");
		myQueue.enQueue("B");
		myQueue.enQueue("C");
		
		System.out.println("요소 "+myQueue.getSize()+"개");
		
		System.out.println(myQueue.deQueue());
		System.out.println(myQueue.deQueue());
		System.out.println(myQueue.deQueue());
		System.out.println(myQueue.deQueue());
		
	}
	
}
