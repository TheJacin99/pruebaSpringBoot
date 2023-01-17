package com.prueba.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticuloDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "id")
	private int idArticulo;
	
	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	@JsonProperty(value = "nombre")
	private String nombreArticulo;
	
	@JsonProperty(value = "descripcion")
	private String descripcionArticulo;

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	
	@Override
	public String toString() {
		return "ArticuloDto [idArticulo=" + idArticulo + ", nombreArticulo=" + nombreArticulo + ", descripcionArticulo="
				+ descripcionArticulo + "]";
	}
}
