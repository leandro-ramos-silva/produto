package br.com.bbseguros.produto.resources.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandle {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e , HttpServletRequest http){
		
		
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err) ;
		
	}
	

	@ExceptionHandler(ObjectValidationException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectValidationException e , HttpServletRequest http){
		
		
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err) ;
		
	}


}
