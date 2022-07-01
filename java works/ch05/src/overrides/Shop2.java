package overrides;

public class Shop2 extends HeadShop {
	
	public Shop2() {
		System.out.println("역세권 매장입니다.");
	}
	
	@Override
	public void sellD() {
		System.out.println("된장찌개 : 7000 원");
	}
	
	@Override
	public void sellK() {
		System.out.println("김치찌개 : 7500 원");
	}
	
	@Override
	public void sellB() {
		System.out.println("비빔밥 : 8000원");
	}

}
