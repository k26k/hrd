package generic.collection.list;

public class LinkedListExample2 {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		long count=0;
		
		System.out.println(startTime);
		
		for(int i=0; i<100000000; i++) {
			long c = 0;
			for(int j=0; j<10000000; j++) {
				c++;
			}
			long endTime = System.nanoTime();
			if(endTime - startTime < 0) {
				System.out.println(endTime);
				break;
			}else if(startTime+count*1000000 < endTime) {
				System.out.println(endTime+" "+count+" "+i);
				count++;
			}
//			System.out.println(startTime);
//			System.out.println(System.currentTimeMillis()+" "+System.nanoTime());
		}
		
	}
	
}
