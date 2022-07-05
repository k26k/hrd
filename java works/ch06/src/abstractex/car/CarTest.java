package abstractex.car;

public class CarTest {
	
	public static void main(String[] args) {
		
		Car bus = new Bus();
		Car truck = new Truck(); 
		
		bus.run();
		bus.refuel();
		bus.stop();
		((Bus)bus).takePassenger();;
		
		truck.run();
		truck.refuel();
		truck.stop();
		((Truck)truck).load();
		
	}
	
}
