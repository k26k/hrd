package com.boot.entitiy;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class BaseEntity {
	
	@CreatedDate
	@Column(name="reg_date", updatable = false)
	private LocalDateTime regDate;
	
	@LastModifiedDate
	@Column(name="mod_date")
	private LocalDateTime modDate;
	
}
