package com.boot.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.support.Repositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.domain.Role;
import com.boot.dto.BoardDto;
import com.boot.dto.MemberDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entity.Member;
import com.boot.repository.MemberRepository;
import com.boot.repository.SearchRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final SearchRepository searchRepository;

	@Override
	public MemberDto getMember(String userId) {
		Member member = memberRepository.findById(userId).get();
		MemberDto memberDto = this.entityToDTO(member);
		return memberDto;
	}

	@Override
	public PageResultDto<MemberDto, Member> getMemberPage(PageRequestDto pageRequestDto) {
		Pageable pageable = pageRequestDto.getPageable(Sort.by(Order.desc("modDate")));
		
		Function<Member, MemberDto> func = (member -> this.entityToDTO(member));
		Page<Member> page = memberRepository.findAll(pageable);
		
		PageResultDto<MemberDto, Member> pageResultDto = new PageResultDto<MemberDto, Member>(page, func);
		return pageResultDto;
	}
	
	@Override
	public PageResultDto<MemberDto, Member> searchMemberPage(PageRequestDto pageRequestDto) {
		String type = pageRequestDto.getType();
		String keyword = pageRequestDto.getKeyword();
		Pageable pageable = pageRequestDto.getPageable(Sort.by(Order.desc("userId")));
		
		Function<Member, MemberDto> func = (member -> this.entityToDTO(member));
		Page<Member> page = searchRepository.searchMemberPage(type, keyword, pageable);
		
		PageResultDto<MemberDto, Member> pageResultDto = new PageResultDto<MemberDto, Member>(page, func);
		return pageResultDto;
	}

	@Override
	public boolean insertMember(MemberDto memberDto) {
		memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
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
	public boolean updateMember(String userId, MemberDto newMemberDto) {
		Optional<Member> optional = memberRepository.findById(userId);
		if(optional.isEmpty()) {
			return false;
		}
		
		MemberDto originMember = this.entityToDTO(optional.get());
		if(newMemberDto.getPassword() != null && !newMemberDto.getPassword().equals("")) {
			originMember.setPassword(passwordEncoder.encode(newMemberDto.getPassword()));
		}
		originMember.setName(newMemberDto.getName());
		memberRepository.save(this.dtoToEntity(originMember));
		return true;
	}

	@Override
	public boolean updateMemberAdmin(String adminId, String oldId, MemberDto newMemberDto) {
		Optional<Member> adminOptional = memberRepository.findById(adminId);
		if(adminOptional.isEmpty()) {
			return false;
		}
		MemberDto adminDto = this.entityToDTO(adminOptional.get());
		if(!adminDto.getRole().equals(Role.ROLE_ADMIN)) {
			return false;
		}
		
		Optional<Member> memberOptional = memberRepository.findById(oldId);
		if(memberOptional.isEmpty()) {
			return false;
		}
		MemberDto originMember = this.entityToDTO(memberOptional.get());
		if(newMemberDto.getPassword() != null && !newMemberDto.getPassword().equals("")) {
			originMember.setPassword(passwordEncoder.encode(newMemberDto.getPassword()));
		}
		originMember.setName(newMemberDto.getName());
		memberRepository.save(this.dtoToEntity(originMember));
		return true;
	}

	@Override
	public boolean deleteMember(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enableMember(String userId) {
		return memberRepository.memberEnable(userId);
	}

	@Override
	public boolean disableMember(String userId) {
		return memberRepository.memberDisable(userId);
	}

	@Override
	public boolean checkId(String userId) {
		if(memberRepository.findById(userId).isEmpty()) {
			return false;
		}
		
		return true;
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
