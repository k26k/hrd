package customer;

public class VIPCustomerTest {

	public static void main(String[] args) {
		
		VIPCustomer customerKing = new VIPCustomer();
		
		customerKing.setCustomerName("세종");
		customerKing.setCustomerID(1446);
		
		int price1 = 10000;
		customerKing.calcPrice(price1);
		System.out.println(customerKing.showCustomerInfo());

		int price2 = 10000;
		customerKing.calcPrice(price2);
		System.out.println(customerKing.showCustomerInfo());
		
	}

}
