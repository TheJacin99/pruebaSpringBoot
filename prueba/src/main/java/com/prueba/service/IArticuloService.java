package com.prueba.service;

import java.util.List;

import com.prueba.dto.ArticuloDto;

public interface IArticuloService {

	public List<ArticuloDto> listar();
	
	public void insertarModificar(ArticuloDto dto);
	
	public void borrar(Integer id);
}
