package thread;

import java.awt.Toolkit;

public class BeepTask implements Runnable{

	@Override
	public void run() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		System.out.println("= START =");
		
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

}
