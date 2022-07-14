package generic.collection.member;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberHashSet {

	private Set<Member> hashSet;

	public MemberHashSet() {
		hashSet = new HashSet<>();
	}
	
//	회원 추가
	public void addMember(Member member) {
		hashSet.add(member);
	}
	
	
//	회원 전체 조회 Iterator
	public void showAllMember() {
		Iterator<Member> ir = hashSet.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			System.out.println(member);
		}
	}
	
//	회원 전체 조회 향상 for
//		hashSet은 순서가 없어서 향상된 for문은 가능하지만 일반 for문은 안됨	
//	public void showAllMember() {
//		for(Member member:hashSet) {
//			System.out.println(member);
//		}
//	}
	
	
//	회원 삭제 Iterator
	public boolean removeMember(int memberId) {
		Iterator<Member> ir = hashSet.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			int dbMemberId = member.getMemberId();
			if(dbMemberId == memberId) {
				hashSet.remove(member);
				return true;
			}
		}
		System.out.println("ID "+memberId+" 가 존재하지 않음");
		return false;
	}
	
//	회원 삭제 향상 for
//	public boolean removeMember(int memberId) {
//		for(Member member:hashSet) {
//			if(member.getMemberId() == memberId) {
//				hashSet.remove(member);
//				return true;
//			}
//		}
//		System.out.println("ID "+memberId+" 가 존재하지 않음");
//		return false;
//	}
	
	
	
}
