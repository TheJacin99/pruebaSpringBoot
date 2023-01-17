package com.prueba.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Articulos")
public class Articulo {

	@Id
	@Column(name = "id", nullable = false)
	@NotNull(message = "El id no puede ser nulo")
	private int idArticulo;
	
	@Column(name = "nombre", length = 50, nullable = false)
	@NotNull(message = "El nombre no puede ser nulo")
	@Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
	private String nombreArticulo;
	
	@Column(name = "descripcion", length = 200, nullable = false)
	@NotNull(message = "La descripcion no puede ser nula")
	@Size(min = 2, message = "La descripcion debe tener al menos dos caracteres")
	private String descripcionArticulo;
	
	public int getIdArticulo() {
		return idArticulo;
	}
	
	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}
	
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
		return "Articulo [idArticulo=" + idArticulo + ", nombreArticulo=" + nombreArticulo + ", descripcionArticulo="
				+ descripcionArticulo + "]";
	}
	
}
