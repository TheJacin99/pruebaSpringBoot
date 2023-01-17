package com.prueba.utils;

import org.springframework.validation.BindingResult;

public class InvalidDataException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private final transient BindingResult resultado;
	
	public InvalidDataException(BindingResult resultado) {
		super();
		this.resultado = resultado;
	}
	
	public InvalidDataException(String mensaje, BindingResult resultado) {
		super(mensaje);
		this.resultado = resultado;
	}
	
	public BindingResult getResultado() {
		return resultado;
	}
}
