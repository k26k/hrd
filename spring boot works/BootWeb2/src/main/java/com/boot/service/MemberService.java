package com.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.domain.Board;
import com.boot.domain.Member;

public interface MemberService {
	
	public boolean checkMember(String id, String password); 
	
	public Member selectMemberById(String id); 

	public Page<Member> getMemberListByKeywordAndPage(String keywordId, String keywordName, Pageable paging);
	
	public List<Member> selectMemberByQuery(String query); 
	
	public void insertMember(Member member);

	public void deleteMember(String id);
	
	public void updateMember(Member member);
	
}
