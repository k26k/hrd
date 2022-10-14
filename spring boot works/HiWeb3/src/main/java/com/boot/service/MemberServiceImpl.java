package com.boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.domain.Role;
import com.boot.dto.MemberDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entity.Member;
import com.boot.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public MemberDto getMember(String userId) {
		Member member = memberRepository.findById(userId).get();
		MemberDto memberDto = this.entityToDTO(member);
		return memberDto;
	}

	@Override
	public PageResultDto<MemberDto, Object[]> getMemberPage(PageRequestDto pageRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertMember(MemberDto memberDto) {
		Member member = this.dtoToEntity(memberDto);
		memberRepository.save(member);
		memberRepository.changeRole(member.getUserId(), Role.ROLE_MEMBER);
		Optional<Member> optional = memberRepository.findById(member.getUserId());
		if(optional.isPresent()) {
			System.out.println("insertMember: "+optional.get().toString());
			return true;
		}
		return false;
	}

	@Override
	public boolean updateMember(String userId, String oldId, MemberDto newMemberDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberAdmin(String adminId, String oldId, MemberDto newMemberDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMember(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enableMember(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disableMember(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkId(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
//	@Override
//	public Member getMember(String userId) {
//		return memberRepository.findById(userId).get();
//	}
//
//	@Override
//	public Page<Member> getMemberPage(Pageable pageable) {
//		return memberRepository.findAll(pageable);
//	}
//
//	@Override
//	public Page<Member> searchMemberPage(SearchDto search, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getSearchLink(SearchDto search) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean insertMember(Member member) {
//		Optional<Member> optional = memberRepository.findById(member.getUserId());
//		if(optional.isEmpty()) {
//			member.setRole(Role.ROLE_MEMBER);
//			member.setPassword(passwordEncoder.encode(member.getPassword()));
//			memberRepository.save(member);
//			return true;
//		}
//		
//		return false;
//	}
//
//	@Override
//	public boolean updateMember(String userId, Member member){
//		Optional<Member> optional = memberRepository.findById(userId);
//		if(optional.isPresent()) {
//			Member originMember = optional.get();
//			originMember.setName(member.getName());
//			if(!member.getPassword().equals("")) {
//				originMember.setPassword(passwordEncoder.encode(member.getPassword()));
//			}
//			memberRepository.save(originMember);
//			return true;
//		}
//		
//		return false;
//	}
//	
//	@Override
//	public boolean updateMemberAdmin(String userId, Member member){
//		Optional<Member> optional = memberRepository.findById(userId);
//		if(optional.isPresent()) {
//			Member originMember = optional.get();
//			originMember.setName(member.getName());
//			if(!member.getPassword().equals("")) {
//				originMember.setPassword(passwordEncoder.encode(member.getPassword()));
//			}
//			if(member.isEnabled()) {
//				originMember.setEnabled(true);
//			}else{
//				originMember.setEnabled(false);
//			}
//			if(member.getRole().equals(Role.ROLE_ADMIN)) {
//				originMember.setRole(Role.ROLE_ADMIN);
//			}else {
//				originMember.setRole(Role.ROLE_MEMBER);
//			}
//			memberRepository.save(originMember);
//			return true;
//		}
//		
//		return false;
//	}
//
//	@Override
//	public boolean deleteMember(String userId) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean checkId(String userId) {
//		Optional<Member> optional = memberRepository.findById(userId);
//		if(optional.isEmpty()) {
//			return false;
//		}
//		
//		return true;
//	}

	

}
