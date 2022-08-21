package decoraor;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStreamTest {

	public static void main(String[] args) {
		
		try(OutputStream os = new FileOutputStream("data.txt");
			DataOutputStream dos = new DataOutputStream(os);){
			
			dos.writeByte('C');		// 영문자
			dos.writeChar('나');		// 한글 한 글자
			dos.writeInt(48);		// 정수
			dos.writeFloat(2.54F);	// 실수
			dos.writeUTF("감사합니다."); // 문자열
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
