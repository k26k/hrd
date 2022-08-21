package outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteSample2 {

	public static void main(String[] args) {

		OutputStream os = null;
		
		try{
			os = new FileOutputStream("C:/file/test2.txt");
			
			byte[] byteArray = new byte[] {10,20,30};
			
			os.write(byteArray);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.flush();
				os.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
