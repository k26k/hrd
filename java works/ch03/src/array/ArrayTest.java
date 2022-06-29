package array;

public class ArrayTest {

	public static void main(String[] args) {
		
		int[] num = new int[5];
		
		String[] str = new String[3];

		Product[] product = new Product[3];
		System.out.println(product.length);
		for(int i=0; i<product.length; i++) {
			product[i]=new Product();
		}
		for(Product pd:product) {
			System.out.println(pd.showInfo());
		}

	}
	
}
