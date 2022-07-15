package outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExample2 {

	public static void main(String[] args) {
		
		String originFile = "C:/file/bg0.jpg";
		String copyFile = "C:/file/bg1.jpg";
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(originFile);
			fos = new FileOutputStream(copyFile);
			int data;
			while((data = fis.read())!=-1) {
				fos.write(data);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try{
				fis.close();
				fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
