package customer;

public class GOLDCustomer extends Customer{
	
	private double saleRatio; // 할인 비율
	
	public GOLDCustomer() {
		super();
		customerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;
	}
	
	public GOLDCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;
	}
	
	@Override
	public int calcPrice(int price) {
		price -= (int)(price*saleRatio);
		bonusPoint += (int)(price*bonusRatio);
		return price;
	}	
	
}
