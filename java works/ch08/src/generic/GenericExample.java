package generic;

import java.util.ArrayList;

public class GenericExample {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>(); 
		
		list.add("grape");
		list.add("egg");
		list.add("coffe");

		System.out.println(list);
		System.out.println(list.get(2));
		
		
//		generic 프로그램을 사용하는 이유
		ArrayList cart = new ArrayList<>();
		
		cart.add("포도");
		cart.add("계란");
		cart.add("커피");
		
//		String str = cart.get(1); // 형변환 없이 그냥 사용 불가능
		String str = cart.get(1).toString();
//		타입을 지정해주지 않으면 Object형이 되므로 별도의 형변환이 필요
		
		
	}
	
}
