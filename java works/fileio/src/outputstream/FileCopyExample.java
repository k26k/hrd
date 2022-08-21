package outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExample {

	public static void main(String[] args) {
		
		String originFile = "C:/file/bg2.jpg";
		String copyFile = "C:/file/bg1.jpg";
		
//		FileInputStream fis = null;
//		FileOutputStream fos = null;
		
//		try catch resource문
//		close 명시 안하고 사용 가능		
		try(FileInputStream fis = new FileInputStream(originFile);
			FileOutputStream fos = new FileOutputStream(copyFile);){
			
			long startTime = System.currentTimeMillis();
			
			int data;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			
			long endTime = System.currentTimeMillis();
			
			System.out.println(endTime-startTime);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
