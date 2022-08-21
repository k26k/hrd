package abstractex.template_method;

public abstract class Car {

	protected abstract void drive();

	protected abstract void stop();
	
	protected void startCar() {
		System.out.println("시동을 켭니다");
	}
	
	protected void turnOff() {
		System.out.println("시동을 끕니다");
	}
	
	public final void run() {
		startCar();
		drive();
		stop();
		turnOff();
	}
	
}
