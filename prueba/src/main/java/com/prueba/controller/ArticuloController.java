package com.prueba.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.dto.ArticuloDto;
import com.prueba.service.IArticuloService;
import com.prueba.utils.InvalidDataException;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "articulos")
public class ArticuloController {

	private static final Logger logger = LoggerFactory.getLogger(ArticuloController.class);
	
	@Autowired
	private IArticuloService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ArticuloDto>> listar() {
		logger.debug("Obteniendo todos los articulos");
		return ResponseEntity.ok(this.service.listar());
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> insertar(@Valid @RequestBody ArticuloDto articulo, BindingResult result) {
		logger.debug("Creando el siguiente articulo {}", articulo);
		if (result.hasErrors()) {
			throw new InvalidDataException(result);
		}
		this.service.insertarModificar(articulo);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public ResponseEntity<Object> modificar(@Valid @RequestBody ArticuloDto articulo, BindingResult result) {
		logger.debug("Modificando el siguiente articulo {}", articulo);
		if (result.hasErrors()) {
			throw new InvalidDataException(result);
		}
		this.service.insertarModificar(articulo);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> borrar(@PathVariable("id") Integer id) {
		this.service.borrar(id);
		return ResponseEntity.ok().build();
	}
}
