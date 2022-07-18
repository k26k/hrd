package decoraor.bufferedstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterStream {

	public static void main(String[] args) {
		
		try(FileWriter fw = new FileWriter("animal.txt");
			BufferedWriter bw = new BufferedWriter(fw);) {
			
			bw.write("cat");
			bw.write(32); // space
			bw.write("dog");
			bw.write(32);
			bw.write("chicken");
			bw.write(32);
			bw.write("pig");
			bw.write("\n");
			bw.write("cat");
			bw.write(32);
			bw.write("dog");
			bw.write(32);
			bw.write("chicken");
			bw.write(32);
			bw.write("pig");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done");
	}
	
}
