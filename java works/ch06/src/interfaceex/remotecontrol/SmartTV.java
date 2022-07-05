package interfaceex.remotecontrol;

public class SmartTV implements RemoteControl, Searchable{

	public int volume;
	
	@Override
	public void search(String url) {
		System.out.println("["+url+"]을 검색합니다");
	}

	@Override
	public void turnOn() {
		System.out.println("티비 키기");
	}

	@Override
	public void turnOff() {
		System.out.println("티비 끄기");
	}

	@Override
	public void setVolume(int v) {
		this.setMute(false);
		if(RemoteControl.MAX_VOLUME < v) {
			v = RemoteControl.MAX_VOLUME;
		}else if(v < RemoteControl.MIN_VOLUME) {
			v = RemoteControl.MIN_VOLUME;
		}
		this.volume = v;
		System.out.println("티비 볼륨: "+volume);
	}

}
