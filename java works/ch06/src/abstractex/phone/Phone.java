package abstractex.phone;

public abstract class Phone { // abstract 붙여주면 추상 클래스, 상속 없이 단독 생성 불가능

	public String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void powerOn() {
		System.out.println("전원 킴");
	}
	
	public void powerOff() {
		System.out.println("전원 끔");
	}
	
}
