package generic.collection.member;

import java.util.ArrayList;

public class MemberArrayList {

	private ArrayList<Member> memberList;
	
	public MemberArrayList() {
		memberList = new ArrayList<>();
	}
	
	
//	회원 추가
	public void addMember(Member member) {
		memberList.add(member);
	}
	
	
//	회원 전체 조회
	public void showAllMember() {
		for(Member member:memberList) {
			System.out.println(member);
		}
	}
	
	
//	회원 삭제
	public boolean removeMember(int memberId) {
		for(int i=0; i<memberList.size(); i++) {
			Member member = memberList.get(i);
			if(memberList.get(i).getMemberId() == memberId) {
				int id = member.getMemberId();
				String name = member.getMemberName();
				System.out.println("id : "+id+" , name : "+name+" 삭제완료");
				memberList.remove(i);
				return true;
			}
		}
		System.out.println("ID "+memberId+" 가 존재하지 않음");
		return false;
	}
	
	
	
}
