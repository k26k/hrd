package outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteSample3 {

	public static void main(String[] args) {
		
		OutputStream os = null;
		
		try {
			os = new FileOutputStream("C:/file/test3.txt");
			
			byte[] array = new byte[] {10,20,30,40,50};
			
//			os.write(array); // 전체 선택
			os.write(array, 1, 3); // 1번 인덱스 부터 3개 선택
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
}
