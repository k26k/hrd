package decoraor.bufferedstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class bufferedReaderTest {

	public static void main(String[] args) {
		
		ArrayList<String> dataArr = new ArrayList<>();
		
		try(FileReader fr = new FileReader("animal.txt");
			BufferedReader br = new BufferedReader(fr);){
			
			while(true) {
				String data = br.readLine();
				if(data==null) break;
				System.out.println(data);
				String[] animals = data.split(" ");
				for(String animal:animals) {
					dataArr.add(animal);
				}
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("");
		
		for(String dataStr:dataArr) {
			System.out.print(dataStr+" ");
		}
		
		System.out.println("");
		
		System.out.println(dataArr.get((int)(Math.random()*dataArr.size())));
		
	}
	
}
