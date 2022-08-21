package outputstream;

import java.io.IOException;

public class SystemInTest {

	public static void main(String[] args) {
		
		System.out.println("여러개의 문자를 입력하고 [ENTER]를 누르세요.");
		
		int readByte;
		
		try{
			System.out.println("s");
			while((readByte = System.in.read()) != -1) {
				System.out.print((char)readByte);
			}
			System.out.println("e");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
