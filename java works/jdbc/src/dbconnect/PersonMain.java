package dbconnect;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) {
		
		PersonDAO dao = new PersonDAO();
		
//		자료 삽입
//		Person p1 = new Person();
//		p1.setUserId("sky");
//		p1.setUserPw("sky11");
//		p1.setName("하늘");
//		p1.setAge(21);
//		
//		dao.insertPerson(p1);
		
		
//		자료 수정
//		Person p2 = new Person();
//		p2.setUserId("today");
//		p2.setUserPw("today11");
//		p2.setName("오늘");
//		p2.setAge(35);
//		
//		dao.updatePerson(p2);
		
//		자료 삭제
//		Person p3 = new Person();
//		p3.setUserId("sky");
//		
//		dao.deletePerson(p3);
		
//		자료 조회
//		ArrayList<Person> personList = new ArrayList<>();
//		
//		personList = dao.getPersonList();
//		
//		for(Person person:personList) {
//			System.out.printf(
//				"ID: %s \t PW: %s \t Name: %s \t Age: %d \n",
//				person.getUserId(), person.getUserPw(), person.getName(), person.getAge()
//			);
//		}
		
		boolean power = true;
		Scanner sc = new Scanner(System.in);
		
		while(power) {
			
			System.out.println("\n=================================================================");
			System.out.println(" 1. 자료추가 | 2. 자료수정 | 3. 자료삭제 | 4. 상세조회 | 5. 전체조회 | 6. 종료 ");
			System.out.println("=================================================================");
			System.out.print("번호를 입력해주세요 > ");
			int mode = Integer.parseInt(sc.nextLine());
			
			switch(mode) {
				case 1:
					System.out.println("자료추가를 선택하셨습니다.");
					
					Person p1 = new Person();
					
					System.out.print("userid : ");
					p1.setUserId(sc.nextLine());
					System.out.print("userpw : ");
					p1.setUserPw(sc.nextLine());
					System.out.print("name : ");
					p1.setName(sc.nextLine());
					System.out.print("age : ");
					p1.setAge(Integer.parseInt(sc.nextLine()));
					
					dao.insertPerson(p1);
					break;
					
				case 2:
					System.out.println("자료수정을 선택하셨습니다.");
					
					Person p2 = new Person();
					
					System.out.print("userid : ");
					p2.setUserId(sc.nextLine());
					System.out.print("userpw : ");
					p2.setUserPw(sc.nextLine());
					System.out.print("name : ");
					p2.setName(sc.nextLine());
					System.out.print("age : ");
					p2.setAge(Integer.parseInt(sc.nextLine()));
					
					dao.updatePerson(p2);
					break;
					
				case 3:
					System.out.println("자료삭제를 선택하셨습니다.");
					
					Person p3 = new Person();
					
					System.out.print("userid : ");
					p3.setUserId(sc.nextLine());
					
					dao.deletePerson(p3);
					break;
					
				case 4:
					System.out.println("상세조회를 선택하셨습니다.");
					
					String userId; 
					System.out.print("userid : ");
					userId = sc.nextLine();
					
					Person p4 = new Person();
					p4 = dao.getPerson(userId);
					
					printPerson(p4);
					
					break;
						
				case 5:
					System.out.println("전체조회를 선택하셨습니다.");
					
					ArrayList<Person> personList = new ArrayList<>();
					
					personList = dao.getPersonList();
					
					for(Person person:personList) {
						printPerson(person);
					}
					
					break;
					
				case 6:
					System.out.println("종료를 선택하셨습니다.");
					
					power = false;
					
					break;
					
				default:
					System.out.println("다시 입력해 주세요.");
					break;
			}
			
		}
		
		System.out.println("종료 성공");
		
	}
	
	public static void printPerson(Person person) {
		System.out.printf(
			"ID: %s \t PW: %s \t Name: %s \t Age: %d \n",
			person.getUserId(), person.getUserPw(), person.getName(), person.getAge()
		);
	}

}
