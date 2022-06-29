package scoreArray;

public class SortEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		정렬(버블정렬) - 오름차순
		char[] arr1 = {'S','B','M','K','C','Z','A'};
		int i, j;
		char temp;
		
		for(i=0; i<arr1.length; i++) {
			for(j=0; j<arr1.length-1; j++) {
				if(arr1[j+1]<arr1[j]) {
					temp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = temp;
				}
			}
		}
		
		for(char ch:arr1) {
			System.out.print(ch+"  ");
		}
		System.out.println("");
		
		for(int n:arr1) {
			System.out.print(n+" ");
		}
		System.out.println("");
	}

}
