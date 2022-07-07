package shelf;

public class BookShelf extends Shelf implements Queue {

	@Override
	public void enQueue(String title) {
		shelf.add(title);
	}

	@Override
	public String deQueue() {
		String data = shelf.get(0);
		shelf.remove(0);
		return data;
	}

	@Override
	public int getSize() {
		return shelf.size();
	}

}
