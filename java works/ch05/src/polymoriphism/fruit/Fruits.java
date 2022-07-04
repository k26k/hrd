package polymoriphism.fruit;

public class Fruits {
	
	String name;
	String weight;
	int price;
	
	Fruits() {}
	
	void showInfo() {
		System.out.printf("이름:%s / 무게:%s / 가격%,d원\n", name, weight, price);
	}
	
	
}
