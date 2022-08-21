package decoraor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedStreamTest {

	public static void main(String[] args) {
		
//		이미지 읽고 쓰기 (복사)
//		BufferdStream  - 보조 스트림 클래스 사용
//		버퍼링 기능 - 빠르게 입출력 가능
//		보조스트림은 단독으로 사용할수 없고 기반스트림과 함께 사용해야함
		
		String originFile = "C:/file/bg0.jpg";
		String copyFile = "C:/file/bg0_copy.jpg";
		String copybuffFile = "C:/file/bg0_copyBuff.jpg";
		
		long usedTime1=0, usedTime2=0;
		
		try(FileInputStream fis = new FileInputStream(originFile);
			FileOutputStream fos = new FileOutputStream(copyFile);){
			
			long startTime = System.currentTimeMillis();
			
			int i;
			while((i=fis.read())!=-1) {
				fos.write(i);
			}
			
			long endTime = System.currentTimeMillis();
			usedTime1 = endTime - startTime;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream(originFile);
			FileOutputStream fos = new FileOutputStream(copybuffFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
			
			long startTime = System.currentTimeMillis();
			
			int i;
			while((i=bis.read())!=-1) {
				bos.write(i);
			}
			
			long endTime = System.currentTimeMillis();
			usedTime2 = endTime - startTime;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(usedTime1);
		System.out.println(usedTime2);
		
	}
	
}
