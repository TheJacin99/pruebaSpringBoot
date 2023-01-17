package com.prueba.utils;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleException(NoSuchElementException exc) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return buildResponseEntity(httpStatus, exc);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleException(DuplicateKeyException exc) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return buildResponseEntity(httpStatus, exc);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleException(IllegalArgumentException exc) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return buildResponseEntity(httpStatus, exc);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleException(InvalidDataException exc) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		List<String> errors = exc.getResultado().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
		return buildResponseEntity(httpStatus, new RuntimeException("Los datos enviados no son validos"), errors);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleException(MethodArgumentTypeMismatchException exc) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return buildResponseEntity(httpStatus, new RuntimeException("Tipo de dato invalido"));
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleException(Exception exc) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		return buildResponseEntity(httpStatus, new RuntimeException("Ha ocurrido un error no identificado"));
	}
	
	private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc) {
		return buildResponseEntity(httpStatus, exc, null);
	}
	
	private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc, List<String> errors) {
		ErrorResponse error = new ErrorResponse();
		error.setMensaje("Descripcion: " + exc.getMessage());
		error.setEstado(httpStatus.value());
		error.setFecha(new Date());
		error.setErrores(errors);
		
		return new ResponseEntity<>(error, httpStatus);
	}
}
