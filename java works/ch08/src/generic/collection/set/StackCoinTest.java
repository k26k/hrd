package generic.collection.set;

import java.util.Stack;

public class StackCoinTest {

	public static void main(String[] args) {
		
//		stack = List Vector의 DAO
//		coinBox 스택 선언
		Stack<Coin> coinBox = new Stack<>();
		
//		Coin 객체 생성
		Coin coin10 = new Coin(10);
		Coin coin50 = new Coin(50);
		Coin coin100 = new Coin(100);
		Coin coin500 = new Coin(500);
		
		coinBox.push(coin500);
		coinBox.push(coin100);
		coinBox.push(coin50);
		coinBox.push(coin10);
		
		System.out.println("총 객체 수 : "+coinBox.size());
		
		System.out.println("0번 객체 값 : "+coinBox.get(0).getValue());
		
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼낸 돈 : "+coin.getValue()+"원");
		}
		
	}
	
}
