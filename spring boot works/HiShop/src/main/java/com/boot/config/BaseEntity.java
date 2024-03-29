package com.boot.config;


import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseEntity extends BaseTimeEntity {
	
	@CreatedBy
	@Column(name="created_by")
	private String createdBy;
	
	@LastModifiedBy
	@Column(name="updated_by")
	private String updatedBy;
	
}
