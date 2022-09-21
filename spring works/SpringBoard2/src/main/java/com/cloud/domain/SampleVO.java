package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //매개변수가 없는 기본 생성자를 추가
@AllArgsConstructor // 매개변수가 필요한 생성자를 추가
@Data
public class SampleVO {

	private Integer mno;
	
	private String firstName;
	private String lastName;
	
//	public SampleVO(Integer mno, String firstName, String lastName) {
//		super();
//		this.mno = mno;
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
	
}
