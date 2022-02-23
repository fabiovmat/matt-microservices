package br.com.matt.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.matt.exception.ExceptionResponse;
import br.com.matt.exception.UnsupportedMathException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExcepetions(Exception ex, WebRequest request){
	ExceptionResponse exeptionResponse = new ExceptionResponse(
			new Date(), 
			ex.getMessage(), 
			request.getDescription(false)
			);
	return new ResponseEntity<>(exeptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	
}
	
	@ExceptionHandler(UnsupportedMathException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExcepetions(Exception ex, WebRequest request){
	ExceptionResponse exeptionResponse = new ExceptionResponse(
			new Date(), 
			ex.getMessage(), 
			request.getDescription(false)
			);
	return new ResponseEntity<>(exeptionResponse, HttpStatus.BAD_REQUEST);
	
}
	
	
	
}
