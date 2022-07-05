package interfaceex.remotecontrol;

public class SmartTVTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartTV sTV = new SmartTV();
		
		sTV.turnOn();
		sTV.search("안알랴쥼.com");;
		sTV.setVolume(5);;
		sTV.setMute(true);
		sTV.turnOff();
	}

}
