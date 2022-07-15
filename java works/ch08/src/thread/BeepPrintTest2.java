package thread;

public class BeepPrintTest2 {

	public static void main(String[] args) {
		
		System.out.println("[ START ]");
				
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		System.out.println("[  END  ]");
		
	}
	
}
