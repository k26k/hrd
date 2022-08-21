package decoraor.bufferedstream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadLineExample {

	public static void main(String[] args) throws IOException  {
//		줄(line)단위로 문자 읽기
//		BufferedReader 사용
		
		Reader fr = new FileReader("reader.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			String data = br.readLine();
			if(data == null)break;
			System.out.println(data);			
		}
		
//		fr.close();
		br.close();
		System.out.println("[end]");
	}
	
}
