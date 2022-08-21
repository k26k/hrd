package inputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadSample {

	public static void main(String[] args) throws IOException{

		InputStream is = new FileInputStream("C:/file/test1.txt");
//		InputStream is = new FileInputStream("C:/Users/guro-hi/Desktop/color.bmp");
		
		int readByte;
		while((readByte = is.read()) != -1) {
			System.out.println(readByte);
		}
		
		is.close();
		
		System.out.println("[END]");
		
	}
	
}
