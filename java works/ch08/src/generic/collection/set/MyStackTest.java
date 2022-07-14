package generic.collection.set;

public class MyStackTest {

	public static void main(String[] args) {
		
		MyStack myStack = new MyStack();
		
		myStack.push("봄");
		myStack.push("여름");
		myStack.push("가을");
		myStack.push("겨울");
		
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		
	}
	
}
