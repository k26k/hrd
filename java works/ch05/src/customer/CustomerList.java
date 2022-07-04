package customer;

import java.util.ArrayList;

public class CustomerList {

	public static void main(String[] args) {
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		Customer customerLee = new Customer(10010,"이순신");
		Customer customerShin = new Customer(10010,"신사임당");
		Customer customerHong = new GOLDCustomer(10010,"홍길동");
		Customer customerYoul = new GOLDCustomer(10010,"이율곡");
		Customer customerKing = new VIPCustomer(10010,"세종대왕", 1446);
				
		customerList.add(customerLee);
		customerList.add(customerShin);
		customerList.add(customerHong);
		customerList.add(customerYoul);
		customerList.add(customerKing);
		
		System.out.println("================ 할인율과 보너스 계산 ================");
		int price = 10000;
		for(Customer c:customerList) {
			System.out.println(c.getCustomerName()+"님이 "+c.calcPrice(price)+"원 지불하셨습니다.");
		}
		
		System.out.println("================== 고객 정보 출력 ==================");
		for(Customer c:customerList) {
			System.out.println(c.showCustomerInfo());
		}
		
	}

}
