package tire;

public class Car2 {
	
	Tire[] tires = new Tire[] {
		new HankookTire(),
		new HankookTire(),
		new HankookTire(),
		new HankookTire()
	};

	public void run() {
		for(Tire tire:tires) {
			tire.roll();
		}
	}
	
}
