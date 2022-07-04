package customer;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customerLee = new Customer();
		
		customerLee.setCustomerName("이순신");
		
		int price1 = 10000;
		customerLee.calcPrice(price1);
		System.out.println(customerLee.showCustomerInfo());

		int price2 = 20000;
		customerLee.calcPrice(price2);
		System.out.println(customerLee.showCustomerInfo());
		
	}

}
