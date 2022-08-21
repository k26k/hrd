package ex2;

public class SpeedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long v1 = 0;
		long v2 = 0;
		for(int j=0; j<1000;j++) {
			long to1 = System.nanoTime();
			int n = 10;
			for(int i=0;i<100;i++) {
				System.out.print(n+"점 "+n+"점\n");
			}
			long tn1 = System.nanoTime();
			v1+=tn1-to1;
		}
		
		for(int j=0; j<1000;j++) {
			long to2 = System.nanoTime();
			int n = 10;
			for(int i=0;i<100;i++) {
				System.out.printf("%d점 %d점\n",n,n);
			}
			long tn2 = System.nanoTime();
			v2+=tn2-to2;
		}

		System.out.printf("ptint:%.2f\nprintf:%.2f\nf/nonf = %.2f\n", v1/(double)1000000,v2/(double)1000000,v2/(double)v1);
	}

}
