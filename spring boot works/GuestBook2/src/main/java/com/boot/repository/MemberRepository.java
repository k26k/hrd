package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entitiy.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
