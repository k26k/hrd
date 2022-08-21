package annonymous.remotecontrol;

public class AnnonymousExample {

	public static void main(String[] args) {
		
		Anonymous anony = new Anonymous();
		
		anony.feild.turnOn();
		
		anony.method1();
		
		anony.method2(new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("에어컨을 킵니다");
			}
			
			@Override
			public void turnOff() {
				System.out.println("에어컨을 끕니다");
			}
		});
		
	}
	
}
