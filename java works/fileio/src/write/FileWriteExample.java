package write;import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriteExample {

	public static void main(String[] args) {
//		문자 파일 기반 출력 스트림 생성 
//		try(Writer fw = new FileWriter("file1.txt")){
		try(Writer fw = new FileWriter("C:/file/file1.txt")){
			fw.write("hellow java\n");
			fw.write("만나면 반갑\n");
//			fw.write((int)3.3); 숫자 사용 안함
			fw.write(65); // 아스키 코드
			fw.write(10); // 줄바꿈 
			char[] buffer = {'s','m','i','l','e'}; // 배열 삽입
			fw.write(buffer);
			fw.write(buffer,1,2);
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("수행 완료");
	}
	
}
