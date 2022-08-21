package interfaceex.remotecontrol;

public class MyClass {
	
	RemoteControl rc = new Television();
	
	MyClass(){}
	
	MyClass(RemoteControl rc){
		this.rc = rc;
		rc.turnOn();
		rc.setVolume(5);
	}
	
	void methodA() {
		RemoteControl rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
	}
	
	void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(5);
	}
	
}
