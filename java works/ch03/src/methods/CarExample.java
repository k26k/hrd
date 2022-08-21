package methods;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		myCar.keyTurnOn();
		myCar.run();
		System.out.println("현재 속도 (시속: "+myCar.getSpeed()+"km/h)");
	}

}
