package generic.product;

public class GenericProduct {

	public static void main(String[] args) {
		
		Product<TV, String> prod1 = new Product<>();
		TV tv = new TV();
		prod1.setKind(tv);
		prod1.setModel("스마트 티비");
		String tvModel = prod1.getModel();
		tv.makeing();
		System.out.println(tvModel);
		
		Product<Car, String> prod2 = new Product<>();
		Car car = new Car();
		prod2.setKind(car);
		prod2.setModel("전기차");
		prod2.getKind().makeing();
		System.out.println(prod2.getModel());
		
	}
	
}
