package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.boot.config.BaseEntity;
import com.boot.constant.Role;
import com.boot.dto.MemberFormDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Member extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private Long id;
	
	private String name;
	
	@Column(unique = true) // 중복 방지
	private String email;
	
	private String password;
	
	private String address;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
//	회원 생성 메소드
	public static Member creatMemberByFormDto(
			MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		
		Member member = Member.builder()
				.name(memberFormDto.getName())
				.email(memberFormDto.getEmail())
				.password(passwordEncoder.encode(memberFormDto.getPassword()))
				.address(memberFormDto.getAddress())
				.build();
		return member;
	}
	
	
}
