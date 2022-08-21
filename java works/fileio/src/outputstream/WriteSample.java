package outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteSample {

	public static void main(String[] args) throws IOException{

//		파일 생성
		OutputStream os = new FileOutputStream("C:/file/test1.txt");
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		os.write(a);
		os.write(b);
		os.write(c);
		os.write(a);
		os.write(b);
		os.write(c);
		os.write(a);
		os.write(b);
		os.write(c);
		
		os.close();
		
	}
	
}
