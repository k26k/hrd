package generic.collection.member;

public class MemberHashSetTest {

	public static void main(String[] args) {
		
		MemberHashSet memberHashSet = new MemberHashSet();
		
		memberHashSet.addMember(new Member(1001,"네이버"));
		memberHashSet.addMember(new Member(1002,"카카오"));
		memberHashSet.addMember(new Member(1003,"엔씨소프트"));
		memberHashSet.addMember(new Member(1004,"다음"));
		
		memberHashSet.showAllMember();
		
		System.out.println("==================");
		memberHashSet.removeMember(1001);
		System.out.println("==================");
		
		memberHashSet.showAllMember();
		
		System.out.println("==================");
		memberHashSet.removeMember(1001);
		System.out.println("==================");
		
		memberHashSet.showAllMember();
		
	}
	
}
