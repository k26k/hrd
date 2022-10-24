package com.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	public Optional<Member> findByEmail(String email);
	
}
