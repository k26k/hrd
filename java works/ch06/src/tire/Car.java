package tire;

public class Car {
	
	public Tire frontLeftTire = new HankookTire();
	public Tire frontRightTire = new HankookTire();
	public Tire backLeftTire = new HankookTire();
	public Tire backRightTire = new HankookTire();

	public void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
	
}
