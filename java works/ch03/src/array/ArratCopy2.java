package array;

public class ArratCopy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {1,2,3,4};
		int[] a2 = new int[a1.length];
		int[] a3 = new int[a1.length];
		
//		arraycopy(복사할 대상 배열, 대상 배열 인덱스, 복사해서 넣을 배열, 넣을 배열 인덱스, 배열의 길이)
		System.arraycopy(a1, 0, a2, 0, a1.length);
		for(int i=0; i<a2.length; i++) {
			System.out.println(a2[i]);
		}
		
//		a3배열에 a2배열의 클론을 대입함
		a3=a2.clone();
		
		for(int i:a3) {
			System.out.print(i+", ");
		}
		System.out.println("");
	}

}
