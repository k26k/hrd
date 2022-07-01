package statement;

public class SaleStatement {
	
	public static void main(String[] args) {
		
		Drink coffee = new Drink("커피", 2500, 10);
		Drink tea = new Drink("녹차", 3000, 4);
		
		Drink.printTitle();
		coffee.printData();
		tea.printData();
		
		Alcohol soju = new Alcohol("소주", 4000, 5, 17.3f);
		Alcohol.printTitle();
		soju.printData();
		
		int sum = coffee.getTotalPrice() + tea.getTotalPrice() + soju.getTotalPrice();
		System.out.println("\n*** 합계금액 : "+sum+"원 ***\n");
		
	}
	
}
