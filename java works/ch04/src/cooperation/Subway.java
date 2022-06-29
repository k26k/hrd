package cooperation;

public class Subway {

	String lineNumber; // 지하철 노선 
	int passenger;     // 승객
	int money;         // 수입
	
//	생성자
	public Subway(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	
//	승객 추가
	public void take(int money) {
		this.money+=money;
		passenger+=1;
	}
	
//	지하철의 정보
	public void showInfo() {
		System.out.printf("지하철 %s의 수입은 %d원이고 승객수는 %d명입니다.", this.lineNumber, this.money, this.passenger);
	}
	
}
