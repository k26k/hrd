package decoraor;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamtest {

	public static void main(String[] args) {
		
		try(InputStream is = new FileInputStream("data.txt");
			DataInputStream dis = new DataInputStream(is);){
			
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readUTF());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
