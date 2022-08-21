package generic.collection.queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

	private List<String> arrayQueue = new ArrayList<>();
	
	public void enQueue(String data) {
		arrayQueue.add(data);
	}
	
	public String deQueue() {
		if (arrayQueue.size()==0) {
			return null;
		}
		String data = arrayQueue.get(0);
		arrayQueue.remove(0);
		return data;
	}
	
	public int getSize() {
		return arrayQueue.size();
	}
	
}