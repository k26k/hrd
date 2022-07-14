package generic.collection.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MemberHashMap {

	Map<Integer, Member> hashMap;
	
	public MemberHashMap() {
		hashMap = new HashMap<>();
	}
	
	
	public void addMember(Member member) {
		hashMap.put(member.getMemberId(), member);
	}
	
	
	public void showAllMember() {
		Iterator<Integer> ir = hashMap.keySet().iterator();
		while(ir.hasNext()) {
			Member member = hashMap.get(ir.next());
			System.out.println(member);
		}
		System.out.println("");
	}
	
	
	public boolean removeMember(int memberId) {
		if(hashMap.containsKey(memberId)) {
			hashMap.remove(memberId);
			System.out.println("ID "+memberId+" 삭제 완료\n");
			return true;
		}
		System.out.println("ID "+memberId+" 가 존재하지 않음\n");
		return false;
	}
		
}
