package com.cloud.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userid;
    private String userpw;
    private String username;
    private String enabled;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date regDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date updateDate;
    private List<MemberAuthVO> memberAuthVoList;
}
