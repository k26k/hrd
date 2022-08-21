package arraylist;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> cart = new ArrayList<>();
		
		System.out.println(cart.size());
		
		cart.add("커피");
		cart.add("생수");
		cart.add("계란");
		
		System.out.println(cart.size());
		
		for(int i=0; i<cart.size(); i++) {
			System.out.print(cart.get(i)+" ");
		}
		System.out.println("");
		
		cart.remove(1);
		
		for(String c:cart) {
			System.out.print(c+" ");
		}
		System.out.println("");
		
		cart.add("라면");
		
		for(String c:cart) {
			System.out.print(c+" ");
		}
		System.out.println("");
		
		for(int i=0; i<cart.size(); i++) {
			if(cart.get(i).equals("계란")) {
				cart.set(i, "쌀");
				break;
			}
		}
		
		for(String c:cart) {
			System.out.print(c+" ");
		}
		System.out.println("");
		
	}

}
