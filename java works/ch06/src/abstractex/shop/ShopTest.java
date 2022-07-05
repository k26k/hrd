package abstractex.shop;

import java.util.ArrayList;

public class ShopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HeadShop shop1 = new Shop1();
//		HeadShop shop2 = new Shop2();
//		
//		ArrayList<HeadShop> sList = new ArrayList<>();
//		
//		sList.add(shop1);
//		sList.add(shop2);
//		
//		for(HeadShop s:sList) {
//			s.sellDoenjangJige();
//			s.sellKimchiJige();
//			s.sellBibimBap();
//		}

		HeadShop shop1 = new Shop1();
		shop1.sellDoenjangJige();
		shop1.sellKimchiJige();
		shop1.sellBibimBap();
		System.out.println("==========================");
		
		HeadShop shop2 = new Shop2();
		shop2.sellDoenjangJige();
		shop2.sellKimchiJige();
		shop2.sellBibimBap();
		System.out.println("==========================");
		
	}

}
