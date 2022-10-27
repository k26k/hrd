package com.boot.config;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseTimeEntity {

	@CreatedDate
	@Column(name="reg_time", updatable = false)
	private LocalDateTime regTime;

	@LastModifiedDate
	@Column(name="update_time")
	private LocalDateTime updateTime;
	
}
