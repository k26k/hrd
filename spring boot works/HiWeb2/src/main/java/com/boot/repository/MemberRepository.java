package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.boot.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	@Transactional
	@Modifying
	@Query("UPDATE Member m SET m.enabled = 0 WHERE m.userId = :userId")
	public void memberDisable(String userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Member m SET m.enabled = 1 WHERE m.userId = :userId")
	public void memberEnable(String userId);
	
}
