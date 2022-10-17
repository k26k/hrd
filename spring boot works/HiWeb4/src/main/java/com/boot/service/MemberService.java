package com.boot.service;

import com.boot.dto.MemberDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entity.Member;

public interface MemberService {
	
	public MemberDto getMember(String userId);
	
	public PageResultDto<MemberDto, Member> getMemberPage(PageRequestDto pageRequestDto);
	
	public PageResultDto<MemberDto, Member> searchMemberPage(PageRequestDto pageRequestDto);
	
	public boolean insertMember(MemberDto memberDto);
	
	public boolean updateMember(String userId, MemberDto newMemberDto);
	
	public boolean updateMemberAdmin(String adminId, String oldId, MemberDto newMemberDto);
	
	public boolean deleteMember(String userId);
	
	public boolean enableMember(String userId);
	
	public boolean disableMember(String userId);
	
	public boolean checkId(String userId);
	
	public default MemberDto objectToDto(Object[] objects) {
		MemberDto memberDto = null;
		return memberDto;
	}
	
	public default MemberDto entityToDTO(Member member) {
		MemberDto memberDto = MemberDto.builder()
				.userId(member.getUserId())
				.password(member.getPassword())
				.name(member.getName())
				.role(member.getRole())
				.enabled(member.isEnabled())
				.regDate(member.getRegDate())
				.modDate(member.getModDate())
				.build();
		return memberDto;
	}
	
	public default Member dtoToEntity(MemberDto memberDto) {
		Member member = Member.builder()
				.userId(memberDto.getUserId())
				.password(memberDto.getPassword())
				.name(memberDto.getName())
				.role(memberDto.getRole())
				.enabled(memberDto.isEnabled())
				.build();
		return member;
	}
	
}
