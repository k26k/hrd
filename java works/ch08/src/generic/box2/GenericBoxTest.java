package generic.box2;

import generic.box.Apple;

public class GenericBoxTest {

	public static void main(String[] args) {
		
		Box box1 = new Box();
		box1.set("Good Luck!");
		String msg = (String)box1.get(); // 제네릭 box랑 달리 별도의 형변환이 필요
		System.out.println(msg);
		
		Box box2 = new Box();
		box2.set(new Apple("사과"));
		Apple apple = (Apple)box2.get();
		System.out.println(apple);
		
	}
	
}
