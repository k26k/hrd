package thread;

import java.awt.Toolkit;

public class BeepPrintTest {

	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		for(int i=0; i<5; i++) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			toolkit.beep();
			try {
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		System.out.println("[End]");
	}
	
}
