package abstractex.car;

public abstract class Car {
	
	public abstract void run();
	
	public abstract void refuel();
	
	public void stop() {
		System.out.println("차가 정지합니다");
	}
	
}