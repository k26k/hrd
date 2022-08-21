package interfaceex.remotecontrol;

public class RemoteControlTest {

	public static void main(String[] args) {

//		Television tv = new Television();
		
//		인터페이스형 타입으로 객체 생성
		RemoteControl tv = new Television();
		
		tv.turnOn();
		tv.setVolume(15);;
		tv.turnOff();
		
		RemoteControl audio = new Audio();
		
		audio.turnOn();
		audio.setVolume(-10);;
		audio.turnOff();
		
	}

}
