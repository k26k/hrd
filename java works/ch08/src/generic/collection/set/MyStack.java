package generic.collection.set;

import java.util.ArrayList;
import java.util.List;

// Coin을 관리할 DAO
public class MyStack {

	private List<String> arrayStack;
	
	public MyStack() {
		arrayStack = new ArrayList<>();
	}
	
	public void push(String data) {
		arrayStack.add(data);
	}
	
	public String pop() {
		int len = arrayStack.size();
		if(len > 0) {
			String data = arrayStack.get(len-1);
			arrayStack.remove(len-1);
			return data;
		}
		return null;
	}
	
}
