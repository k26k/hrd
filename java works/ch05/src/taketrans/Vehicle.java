package taketrans;

public class Vehicle {

	String vehicleName; // 탈것 이름
	int money; // 수입
	int passengerCount; // 승객수
	
	// 생성자
	public Vehicle(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	// 운송
	public void carry(int money) {
		this.money += money; // 수입 증가
		passengerCount++; // 승객수 1명 증가
	}
	
	public void showInfo() {
		System.out.printf("%s의 수입은 %,d원이고 승객수는%d명입니다.\n", vehicleName, money, passengerCount);
	}
	
}
