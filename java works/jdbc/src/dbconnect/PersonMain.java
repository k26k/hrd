package dbconnect;

import java.util.ArrayList;

public class PersonMain {

	public static void main(String[] args) {
		
		PersonDAO dao = new PersonDAO();
		
		Person p1 = new Person();
		p1.setUserId("today");
		p1.setUserPw("today11");
		p1.setName("투데이");
		p1.setAge(15);
		
		dao.insertPerson(p1);
		
		ArrayList<Person> personList = new ArrayList<>();
		
		personList = dao.getPersonList();
		
		for(Person person:personList) {
			System.out.printf(
				"ID: %s \t PW: %s \t Name: %s \t Age: %d \n",
				person.getUserId(), person.getUserPw(), person.getName(), person.getAge()
			);
		}
		
	}

}
