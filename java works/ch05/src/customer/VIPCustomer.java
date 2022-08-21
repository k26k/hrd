package customer;

public class VIPCustomer extends Customer {
	
	private int agentID; // 상담원 아이디
	private double saleRatio; // 할인 비율
	
	public VIPCustomer() {
		super();
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
	}
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
	}
	
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	
	public int getAgentID() {
		return agentID;
	}

	@Override
	public int calcPrice(int price) {
//		가격 = 가격 - 가격 * 구매할인율
		price -= (int)(price*saleRatio);
//		보너스 = 가격 * 보너스 적립율
		bonusPoint += (int)(price*bonusRatio);
		return price;
	}

	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo()+" // 당담 상담원 아이디는 "+agentID+"입니다.";
	}
	
}
