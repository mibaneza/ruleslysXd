package com.intocables.rulesly.service.exception;

import java.util.ArrayList;
import java.util.List;

import com.intocables.rulesly.service.dto.ErrorDTO;

public class RuleslyException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private final String code;
	
	private final int responseCode;
	
	private final List<ErrorDTO> errorList = new ArrayList<>();


	public RuleslyException(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}

	public RuleslyException(String code, int responseCode, String message, List<ErrorDTO> errorList) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}

	public String getCode() {
		return code;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public List<ErrorDTO> getErrorList() {
		return errorList;
	}
	
	

}
