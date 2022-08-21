package inheritance;

class Car{
	String brand;
	int cc;
	public Car(String brand, int cc) {
		this.brand = brand;
		this.cc = cc;	
	}
}

public class Taxi extends Car{
	int passenger;
	
	public Taxi(String brand, int cc, int passenger) {
		super(brand, cc);
		this.passenger = passenger;
	}
}
