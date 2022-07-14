package generic.collection.member;

public class MemberHashMapTest {

	public static void main(String[] args) {
		
		MemberHashMap memberHashMap = new MemberHashMap();
		
		memberHashMap.addMember(new Member(1001, "삼성"));
		memberHashMap.addMember(new Member(1002, "엘지"));
		memberHashMap.addMember(new Member(1003, "한화"));

		memberHashMap.showAllMember();
		
//		동일한 key에 다른 value을 덮어씌우기 가능
		memberHashMap.addMember(new Member(1003, "비둘기")); 
		
		memberHashMap.showAllMember();
		
		memberHashMap.removeMember(1001);
		memberHashMap.removeMember(1005);

		memberHashMap.showAllMember();
		
	}
	
}
