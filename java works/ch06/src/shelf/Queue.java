package shelf;

public interface Queue {
	
//	선입선출의 큐(Queue) 자료 구조 구현 
	void enQueue(String title); // 리스트에 자료 추가, 맨 뒤에 추가
	
	String deQueue(); // 리스트 자료 반환, 맨 처음 반환
	
	int getSize(); // 리스트 길이 반환
	
}
