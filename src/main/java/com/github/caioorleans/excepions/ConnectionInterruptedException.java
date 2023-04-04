package com.github.caioorleans.excepions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ConnectionInterruptedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ConnectionInterruptedException() {
		super("Conexão com a API interrompida.");
	}

}
