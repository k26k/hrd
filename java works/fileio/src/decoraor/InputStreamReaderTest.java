package decoraor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public static void main(String[] args) {
		
//		try(InputStreamReader isr = 
//			new InputStreamReader(new FileInputStream("reader.text"))){
		try(InputStream fis = new FileInputStream("reader.txt");
			InputStreamReader isr = new InputStreamReader(fis);){
//			보조스트림 객체는 기반 스트림 객체를 베이스로 생성 = 매개변수로 기반스트림 전달 
//			바이트 기반 환경에서 문자로 읽어야 할때 사용
			while(true) {
				int data = isr.read();
				if(data == -1)break;
				System.out.print((char)data);				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
