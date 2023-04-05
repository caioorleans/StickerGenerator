package com.github.caioorleans.excepions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UnespectedErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UnespectedErrorException(String message) {
		super(message);
	}

}
