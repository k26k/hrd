package system;

public class SystemTime {

	public static void main(String[] args) {

		long start1 = System.currentTimeMillis();
		
		long sum1 = 0;
		for(int i=0; i<100000; i++) {
			for(int j=0; j<100000; j++) {
				sum1+=1;
			}
		}
		
		long end1 = System.currentTimeMillis();
		
		System.out.printf("합계: %d, 소요시간: %.6f초\n", sum1, ((double)(end1-start1))/1000);
		
		long start2 = System.nanoTime();
		
		long sum2 = 0;
		for(int i=0; i<100000; i++) {
			for(int j=0; j<100000; j++) {
				sum2+=1;
			}
		}
		
		long end2 = System.nanoTime();
		
		System.out.printf("합계: %d, 소요시간: %.6f초\n", sum2, ((double)(end2-start2))/1000000000);
		
	}

}
