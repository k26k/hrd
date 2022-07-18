package decoraor.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationTest {

	public static void main(String[] args) {
		
		Person personSon = new Person("손정의", "대표이사");
		Person personJang = new Person("장그래", "부장");
		
		try(FileOutputStream fos = new FileOutputStream("serial.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);){
			oos.writeObject(personSon);
			oos.writeObject(personJang);
//			oos.writeObject(null);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<Person> personArray = new ArrayList<>();
		
		try(FileInputStream fis = new FileInputStream("serial.out");
			ObjectInputStream ois = new ObjectInputStream(fis)){
			while(true) {
				Object data = ois.readObject();
				if(data==null) break;
				if(data instanceof Person) personArray.add((Person)data);
			}
		}catch(EOFException e) {
//			e.printStackTrace();
			System.out.println("none");
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Person person:personArray) System.out.println(person);
		
	}
	
}
