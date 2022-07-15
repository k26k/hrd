package thread;

import java.awt.Toolkit;

public class BeepPrintTest3 {

	public static void main(String[] args) {
		
		System.out.println("[ START ]");
				
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("= START =");
				
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("=  END  =");
			}
		});
		
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
