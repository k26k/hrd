package method;

public class OneUp {
	static int x = 1;
	public static int oneUp() {
		x++;
		return x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oneUp());
		System.out.println(oneUp());
		System.out.println(oneUp());
//		각각 2, 3, 4가 반환됨
	}

}
