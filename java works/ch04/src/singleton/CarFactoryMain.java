package singleton;

public class CarFactoryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CarFactory의 인스턴스를 받아와서 CarFactory와 같은 메모리 주소를 가진 factory 객체 생성 
		CarFactory factory = CarFactory.getInstance();
		
//		factory.createCar()메소드를 이용해서 car를 생성하고 생성한 car의 인스턴스를 받아와서 mySonata 객체를 생성
		Car mySonata = factory.createCar();
		System.out.println(mySonata.getCarNum());
		
		Car yourSonata = factory.createCar();
		System.out.println(yourSonata.getCarNum());
		
	}

}
