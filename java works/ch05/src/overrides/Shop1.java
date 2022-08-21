package overrides;

public class Shop1 extends HeadShop {
	
	public Shop1() {
		System.out.println("대학가 매장입니다.");
	}
	
	@Override
	public void sellD() {
		System.out.println("된장찌개 : 6000 원");
	}
	
	@Override
	public void sellK() {
		System.out.println("김치찌개 : 6500 원");
	}
	
	@Override
	public void sellB() {
		System.out.println("비빔밥 : 7000원");
	}

}
