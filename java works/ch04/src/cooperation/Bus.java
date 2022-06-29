package cooperation;

public class Bus {
	
	int busNumber; // 버스 번호 
	int passenger; // 승객
	int money;     // 수입
	
//	생성자
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	
//	승객 추가
	public void take(int money) {
		this.money+=money;
		passenger+=1;
	}
	
//	버스의 정보
	public void showInfo() {
		System.out.println(busNumber+"번 버스의 수입은 "+money+"원이고 승객수는 "+passenger+"명입니다.");
	}
	
}
