package com.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.boot.dto.AjaxResultDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(BoardException.class)
//	public String handleCustomException(BoardException boardException, Model model) {
//		model.addAttribute("exception", boardException);
//		return "/system/boardError";
//	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/system/globalError";
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle404(NoHandlerFoundException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/system/globalError";
	}
	
	@ResponseBody
	@ExceptionHandler(IllegalStateException.class)
	public Object handleIllegalStateException(Exception exception, Model model) {
		AjaxResultDto ajaxResultDto = AjaxResultDto.builder()
				.result(true)
				.message(exception.getMessage())
				.build();
		return ajaxResultDto;
	}
}
