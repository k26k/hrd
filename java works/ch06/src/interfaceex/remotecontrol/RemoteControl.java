package interfaceex.remotecontrol;

public interface RemoteControl {
	
	public int MIN_VOLUME = 0;
	public int MAX_VOLUME = 10;
	
	public void turnOn();
	public void turnOff();
	public void setVolume(int v);
	
//	디폴트 메서드
	default void setMute(boolean m) {
		if(m) {
			System.out.println("음소거");
		}else{
			System.out.println("음소거 해제");
		}
	}
	
//	정적 메서드
	static void chargeBattery() {
		System.out.println("배터리를 충전 하세요");
	}
	
}
