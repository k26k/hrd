package com.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.domain.Member;
import com.boot.domain.Role;
import com.boot.domain.Search;
import com.boot.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Member getMember(String userId) {
		return memberRepository.findById(userId).get();
	}

	@Override
	public Page<Member> getMemberPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Member> searchMemberPage(Search search, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSearchLink(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertMember(Member member) {
		Optional<Member> optional = memberRepository.findById(member.getUserId());
		if(optional.isEmpty()) {
			member.setRole(Role.ROLE_MEMBER);
			member.setPassword(passwordEncoder.encode(member.getPassword()));
			memberRepository.save(member);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateMember(String userId, Member member){
		Optional<Member> optional = memberRepository.findById(userId);
		if(optional.isPresent()) {
			Member originMember = optional.get();
			originMember.setName(member.getName());
			if(!member.getPassword().equals("")) {
				originMember.setPassword(passwordEncoder.encode(member.getPassword()));
			}
			memberRepository.save(originMember);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteMember(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkId(String userId) {
		Optional<Member> optional = memberRepository.findById(userId);
		if(optional.isEmpty()) {
			return false;
		}
		
		return true;
	}

	

}
