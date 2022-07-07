package annonymous.remotecontrol;

public class Anonymous {
	
	RemoteControl feild = new RemoteControl() {

		@Override
		public void turnOn() {
			System.out.println("TV 켜기");
		}

		@Override
		public void turnOff() {
			System.out.println("TV 끄기");
		}
		
	};
	
	void method1() {
		
		RemoteControl localVal = new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("Audio 켜기");
			}

			@Override
			public void turnOff() {
				System.out.println("Audio 끄기");
			}
			
		};
		
		localVal.turnOn();
		
	}
	
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
	
}
