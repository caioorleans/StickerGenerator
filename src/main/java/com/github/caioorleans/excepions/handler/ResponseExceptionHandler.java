package com.github.caioorleans.excepions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.github.caioorleans.excepions.ConnectionInterruptedException;
import com.github.caioorleans.excepions.JsonParsingException;
import com.github.caioorleans.excepions.NotFoundException;
import com.github.caioorleans.excepions.StickerNotGeneratedException;
import com.github.caioorleans.excepions.UnespectedErrorException;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler {

	@ExceptionHandler(ConnectionInterruptedException.class)
	public final ResponseEntity<ExceptionResponse> handleConnectionInterruptedExceptions(
			Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(JsonParsingException.class)
	public final ResponseEntity<ExceptionResponse> handleParseExceptions(
			Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StickerNotGeneratedException.class)
	public final ResponseEntity<ExceptionResponse> handleStickerNotGeneratedExceptions(
			Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
			Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UnespectedErrorException.class)
	public final ResponseEntity<ExceptionResponse> handleUnespectedErrorExceptions(
			Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
