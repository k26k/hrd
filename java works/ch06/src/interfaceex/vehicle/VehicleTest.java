package interfaceex.vehicle;

public class VehicleTest {

	public static void main(String[] args) {
		
//		Driver driver = new Driver();
//		기존의 클래스 선언
//		Bus bus = new Bus();
//		Texi texi = new Texi();
//		
//		driver.drive(bus);
//		driver.drive(texi);
		
		
		Driver driver = new Driver();
//		인터페이스형 선언
		Vehicle bus = new Bus();
		Vehicle texi = new Texi();
		
		driver.drive(bus);
		driver.drive(texi);
		
		
	}

}
