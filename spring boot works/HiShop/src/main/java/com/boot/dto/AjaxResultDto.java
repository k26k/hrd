package com.boot.dto;

import java.util.List;

import org.springframework.validation.ObjectError;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AjaxResultDto {

	private boolean result;
	
	private String message;
	
	private String redirectLink;
	
	private List<ObjectError> errors;
	
}
