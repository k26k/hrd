package interfaceex.remotecontrol;

public class Audio implements RemoteControl {

	public int volume;
	
	@Override
	public void turnOn() {
		System.out.println("오디오 키기");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오 끄기");
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
		System.out.println("오디오 볼륨: "+volume);
	}
}
