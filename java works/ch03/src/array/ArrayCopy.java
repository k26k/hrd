package array;

public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		배열 복사
		int[] arr1= new int[3];
		arr1[0] = 0;
		arr1[1] = 1;
		arr1[2] = 2;
		
//		복사
		int[] arr2= new int[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			arr2[i]=arr1[i];
		}
		
//		출력
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
//		역순 복사
		int[] arr3= new int[arr1.length];
		for(int i=0; i<arr1.length; i++) {
			arr3[arr1.length-1-i]=arr1[i];
		}
		
//		출력
		for(int i=0; i<arr3.length; i++) {
			System.out.println(arr3[i]);
		}
	}
}
