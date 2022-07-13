package generic.collection.member;

public class MemberArrayListTest {
	
	public static void main(String[] args) {
		
		MemberArrayList memberArrayList = new MemberArrayList();
		
		memberArrayList.addMember(new Member(1001, "추신수"));
		memberArrayList.addMember(new Member(1002, "손흥민"));
		memberArrayList.addMember(new Member(1003, "박인비"));
		memberArrayList.addMember(new Member(1004, "김연아"));
		
		memberArrayList.showAllMember();
		
		memberArrayList.removeMember(1003);
		memberArrayList.removeMember(1005);
		
		memberArrayList.showAllMember();
		
	}
	
}
