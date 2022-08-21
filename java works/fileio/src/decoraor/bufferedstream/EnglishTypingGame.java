package decoraor.bufferedstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EnglishTypingGame {

	public static void main(String[] args) {
		
		try(FileReader fr = new FileReader("word.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner sc = new Scanner(System.in);){
			
			String[] wordList = null;
			
			while(true) {
				String data = br.readLine();
				if(data==null) break;
				System.out.println(data);
				wordList = data.split(" ");
			}
			
			for(String word:wordList) System.out.print(word+"  ");
			
			long startTime = System.currentTimeMillis();
			
			System.out.println("\n\nStart game");
			
			int count = 0;
			while(count<wordList.length) {
				System.out.print("\nword: "+wordList[count]+"\nanswer : ");
				String answer = sc.next();
				if(answer.equals(wordList[count])) {
					System.out.println("right");
					count++;
				}else if(answer.equals("q")){
					System.out.println("pass");
					count++;
				}else {
					System.out.println("wrong");
				}
			}
			
			System.out.println("\nend game");
			
			long endTime = System.currentTimeMillis();
			
			long usedTime = endTime - startTime;
			
			System.out.println(usedTime);
			System.out.printf("소요시간 %.2f초", usedTime/(double)1000);
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
