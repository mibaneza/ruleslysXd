package com.intocables.rulesly.service.exception;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.intocables.rulesly.service.dto.ErrorDTO;

public class NotFountException extends RuleslyException{

	private static final long serialVersionUID = 1L;
	private static final int STATUS = HttpStatus.NOT_FOUND.value();

	public NotFountException(String code, String message) {
		super(code, STATUS, message);
	}
	
	public NotFountException(String code, String message, ErrorDTO data) {
		super(code, STATUS, message, Arrays.asList(data));
	}

}
