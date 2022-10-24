package com.boot.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.constant.Role;
import com.boot.dto.MemberFormDto;
import com.boot.entity.Member;
import com.boot.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder encoder;
	
	public boolean addMember(MemberFormDto dto) {
		Member member = Member.creatMemberByFormDto(dto, encoder);
		this.validateDuplicateMember(member);
		member.setRole(Role.USER);
		member = memberRepository.save(member);
		if(member.getId() != null) {
			return true;
		}
		
		return false;
	}
	
	public void validateDuplicateMember(Member member) {
		Optional<Member> optional = memberRepository.findByEmail(member.getEmail());
		if(optional.isPresent()) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}
	
}
