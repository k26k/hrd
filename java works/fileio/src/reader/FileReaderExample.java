package reader;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderExample {

	public static void main(String[] args) {

		try(Reader fr = new FileReader("file1.txt") ){
			int i;
			while((i = fr.read())!=-1) {
				System.out.print((char)i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
