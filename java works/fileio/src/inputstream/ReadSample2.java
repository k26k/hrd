package inputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadSample2 {

	public static void main(String[] args) {
		
		InputStream is = null;
				
		try {
			is = new FileInputStream("C:/file/test1.txt");
			
			byte[] buffer = new byte[100];
			
			int data;
			
//			while((data = is.read(buffer)) != -1) {
//				for(int i=0; i<data; i++) {
//					System.out.println(buffer[i]);
//				}
//			}
			
			while(true) {
				if((data = is.read(buffer)) == -1) break;
				for(int i=0; i<data; i++) {
					System.out.println(buffer[i]);
				}
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try{
				is.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("[END]");
	}
	
}
