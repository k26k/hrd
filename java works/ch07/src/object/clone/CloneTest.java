package object.clone;

import java.util.ArrayList;

public class CloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[] {1,2,3,4};
		int[] arr2 = new int[arr1.length];
		
		System.out.println("for문 배열 복사");
		for(int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
			System.out.print(arr2[i]+" ");
		}
		System.out.println("");
		
		System.out.println("clone() 배열 복사");
		int[] arr3 = arr1.clone();
		for(int a:arr3) {
			System.out.print(a+" ");
		}
		System.out.println("");
		
	}

}
