package com.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boot.domain.Member;
import com.boot.domain.Role;
import com.boot.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Page<Member> getMemberPage(String keyWord, Pageable pageable) {
		return memberRepository.findByIdContainingOrNameContaining(keyWord, keyWord, pageable);
	}

	@Override
	public Member getMemberById(String id) {
		Optional<Member> optional = memberRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return new Member();
	}

	@Override
	public void addMember(Member member) {
		member.setRole(Role.ROLE_MEMBER);
		memberRepository.save(member);
	}

	@Override
	public void updateMember(Member member) {
		if(member.getRole() != null && !member.getRole().equals(Role.ROLE_ADMIN)) {
			member.setRole(Role.ROLE_MEMBER);
		}
		memberRepository.save(member);
	}

	@Override
	public void deleteMember(String id) {
		memberRepository.deleteById(id);
	}
	
	@Override
	public boolean checkId(String id) {
		return false;
	}
	
}
