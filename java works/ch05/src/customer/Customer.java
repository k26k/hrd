package customer;

public class Customer {
	private int customerID; // 고객 아이디
	private String customerName; // 고객 이름
	protected String customerGrade; // 고객 등급
	protected int bonusPoint; // 고객의 보너스 포인트(마일리지)
	protected double bonusRatio; // 고객의 포인트 적립 비율
	
	public Customer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}
	
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}
	
	// getter, setter 메서드
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	// 보너스 적립 계산
	
	public int calcPrice(int price) {
		// 보너스 포인트 = 가격 * 보너스 적립율
		bonusPoint += (int)(price * bonusRatio); 
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName+"님의 등급은 ["+customerGrade+"]이며 보너스 포인트는 "+bonusPoint+"점입니다.";
	}
	
	
	
}
