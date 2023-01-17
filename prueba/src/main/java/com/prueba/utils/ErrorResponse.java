package com.prueba.utils;

import java.util.Date;
import java.util.List;

public class ErrorResponse {

	private int estado;
	private String mensaje;
	private Date fecha;
	List<String> errores;
	
	ErrorResponse() {
	}
	
	ErrorResponse(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<String> getErrores() {
		return errores;
	}

	public void setErrores(List<String> errores) {
		this.errores = errores;
	}

}
