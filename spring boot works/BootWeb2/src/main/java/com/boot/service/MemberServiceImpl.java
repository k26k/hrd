package com.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boot.domain.Member;
import com.boot.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public boolean checkMember(String id, String password) {
		System.out.println("checkMember start ...");
		// Optional 클래스는 null 체크용으로 사용 가능
		Optional<Member> result = memberRepository.findById(id);
		if(result.isPresent() && result.get().getPassword().equals(password)) {
			return true;
		}
//		Member member = memberRepository.findById(id).get();
//		System.out.println("checkMember get member ...");
//		if(member != null) {
//			System.out.println("checkMember member is not null ...");
//			if(member.getId() != null) {
//				System.out.println("checkMember member id is not null ...");
//				if(member.getPassword() != null) {
//					System.out.println("checkMember member password is not null ...");
//					if(member.getId().equals(id)) {
//						System.out.println("checkMember member id is equal ...");
//						if(member.getPassword().equals(password)) {
//							System.out.println("checkMember member password is equal ...");
//						}
//					}
//				}
//			}
//		}
		return false;
	}

	@Override
	public Member selectMemberById(String id) {
		Optional<Member> result = memberRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public List<Member> selectMemberByQuery(String query) {
		return null;
	}

	@Override
	public void insertMember(Member member) {
		memberRepository.save(member);
	}

	@Override
	public void deleteMember(String id) {
		memberRepository.deleteById(id);
	}

	@Override
	public void updateMember(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Page<Member> getMemberListByKeywordAndPage(String keywordId, String keywordName, Pageable paging) {
		return memberRepository.findByIdContainingOrNameContaining(keywordId, keywordName, paging);
	}

}
