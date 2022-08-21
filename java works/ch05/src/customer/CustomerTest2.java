package customer;

public class CustomerTest2 {

	public static void main(String[] args) {
		
		Customer lee = new Customer(10010, "이순신");
		System.out.println(lee.showCustomerInfo());
		
		Customer king = new VIPCustomer(10020, "세종", 1446); // 자식 클래스 선언자를 사용하면서 부모 클래스로 선언해도 됨 (묵시적 형변환)
		System.out.println(king.showCustomerInfo());
		
		int price = 10000;
		
		int leePrice = lee.calcPrice(price);
		int kingPrice = king.calcPrice(price);
				
		System.out.println(lee.showCustomerInfo());
		System.out.println(king.showCustomerInfo());
		
		System.out.println(lee.getCustomerName()+"님이 지불해야 하는 금액은 원 "+leePrice+"입니다.");
		System.out.println(king.getCustomerName()+"님이 지불해야 하는 금액은 원 "+kingPrice+"입니다.");
		

	}

}
