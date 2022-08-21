package inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadSample3 {

	public static void main(String[] args) {
//		바이트 기반 파일 입력 스트림 설정
		try(InputStream is = new FileInputStream("C:/file/test3.txt");){
			byte[] buffer = new byte[5];
			
			while(true) {
				int data = is.read(buffer, 2, 3); // buffer의 2번 인덱스부터 3개 저장
				if(data == -1) break;
//				for(int i=0; i<buffer.length; i++){
//					System.out.println(buffer[i]);
//				}
				for(byte b:buffer) System.out.println(b);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
