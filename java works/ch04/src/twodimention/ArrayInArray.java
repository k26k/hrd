package twodimention;

public class ArrayInArray {
	
	public static void main(String[] args) {
		
		int[][] mathScores = new int[2][3];
		
		System.out.println(mathScores.length); // 행의 갯수, 열의 길이
		System.out.println(mathScores[0].length); // 열의 갯수, 행의 길이
		
		for(int y=0;y<mathScores.length;y++) {
			for(int x=0;x<mathScores[y].length;x++) {
				System.out.printf("mathScore[%d][%d]= %d ",y,x,mathScores[y][x]);
			}
			System.out.println("");
		}
	}
	
}
