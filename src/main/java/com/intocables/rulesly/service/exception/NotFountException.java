package com.intocables.rulesly.service.exception;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.intocables.rulesly.dto.ErrorDto;

public class NotFountException extends RuleslyException{

	private static final long serialVersionUID = 1L;
	private static final int status = HttpStatus.NOT_FOUND.value();

	public NotFountException(String code, String message) {
		super(code, status, message);
	}
	
	public NotFountException(String code, String message, ErrorDto data) {
		super(code, status, message, Arrays.asList(data));
	}

}
