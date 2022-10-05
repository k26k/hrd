package com.boot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.domain.Member;

public interface MemberService {

	public Page<Member> getMemberPage(String keyWord, Pageable pageable);
	
	public Member getMemberById(String id);
	
	public void addMember(Member member);
	
	public void updateMember(Member member);

	public void deleteMember(String id);
	
	public boolean checkId(String id);
	
}
