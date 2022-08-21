package cooperation;

public class Person {
	
	String name; // 이름
	int money;   // 돈
	
//	생성자
	public Person(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
//	버스 타기
	public void takeBus(Bus bus) {
		bus.take(1200);
		this.money -= 1200;
	}
	
//	지하철 타기
	public void takeSubway(Subway subway) {
		subway.take(1500);
		this.money -= 1500;
	}
	
//	사람의 정보 확인
	public void showInfo() {
		System.out.println(this.name+"님의 돈은 "+this.money+"원 입니다.");
	}
	
}
