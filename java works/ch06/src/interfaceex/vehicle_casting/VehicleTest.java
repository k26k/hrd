package interfaceex.vehicle_casting;

import java.util.ArrayList;

public class VehicleTest {

	public static void main(String[] args) {
		
		Driver driver = new Driver();
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Bus());
		vehicles.add(new Texi());
		vehicles.add(new Bus());
		vehicles.add(new Texi());
		
		for(Vehicle vehicle:vehicles) {
			if(vehicle instanceof Bus) {
				((Bus)vehicle).name();
			}else if(vehicle instanceof Texi) {
				((Texi)vehicle).name();
			}
			driver.drive(vehicle);
		}
		
	}

}
