package generic.box;

public class GenericBoxTest {

	public static void main(String[] args) {
		
		Box<String> box1 = new Box<>();
		box1.set("행운을 빌어요");
		String msg = box1.get();
		System.out.println(msg);
		
		Box<Integer> box2 = new Box<>();
		box2.set(10);
		Integer num = box2.get();
		System.out.println(num);
		
		Box<Apple> box3 = new Box<>();
		box3.set(new Apple("사과"));
		Apple apple = box3.get();
		System.out.println(apple);
		
	}
	
}
