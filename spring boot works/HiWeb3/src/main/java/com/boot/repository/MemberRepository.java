package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.boot.domain.Role;
import com.boot.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	@Transactional
	@Modifying
	@Query("UPDATE Member m SET m.enabled = 0 WHERE m.userId = :userId")
	public void memberDisable(@Param("userId") String userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Member m SET m.enabled = 1 WHERE m.userId = :userId")
	public void memberEnable(@Param("userId") String userId);

	@Transactional
	@Modifying
	@Query("UPDATE Member m SET m.role = :role WHERE m.userId = :userId")
	public void changeRole(@Param("userId") String userId, @Param("role") Role role);
	
}
