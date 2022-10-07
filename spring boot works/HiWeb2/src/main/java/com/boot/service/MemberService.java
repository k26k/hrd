package com.boot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.domain.Member;
import com.boot.domain.Search;

public interface MemberService {
	public Member getMember(String userId);
	
	public Page<Member> getMemberPage(Pageable pageable);
	
	public Page<Member> searchMemberPage(Search search, Pageable pageable);
	
	public String getSearchLink(Search search);
	
	public boolean insertMember(Member member);
	
	public boolean updateMember(String userId, Member newMember);
	
	public boolean updateMemberAdmin(String userId, Member newMember);
	
	public boolean deleteMember(String userId);
	
	public boolean checkId(String userId);
	
}
