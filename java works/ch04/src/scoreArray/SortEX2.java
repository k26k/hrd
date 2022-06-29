package scoreArray;

public class SortEX2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		정렬(버블정렬) - 오름차순
		int[] arr1 = {3,6,9,2,5,4};
		int i, j, temp;
		for(i=0; i<arr1.length; i++) {
			for(j=0; j<arr1.length-1; j++) {
				if(arr1[j+1]<arr1[j]) {
					temp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = temp;
				}
			}
		}
		for(int a:arr1) {
			System.out.print(a+" ");
		}
		
		System.out.println("");
	}

}
