package loopExample;

public class ForSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;
		for(i=1;i<=5;i++) {
			for(j=1;j<=i;j++) {
				System.out.print("$");
			}
			System.out.println();
		}
		
		for(i=1;i<=5;i++) {
			for(j=1;j<i;j++) {
				System.out.print(" ");
			}
			for(j=j;j<=5;j++) {
				System.out.print("$");
			}
			System.out.println();
		}
		
		for(i=1;i<=5;i++) {
			for(j=5;i<j;j--) {
				System.out.print(" ");
			}
			for(j=j;1<=j;j--) {
				System.out.print("$");
			}
			System.out.println();
		}
		
		for(i=5;0<i;i--) {
			for(j=1;j<=i;j++) {
				System.out.print("$");
			}
			for(j=j;j<=5;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
