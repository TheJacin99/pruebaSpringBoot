package com.prueba.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.prueba.dto.ArticuloDto;
import com.prueba.entity.Articulo;
import com.prueba.repository.IArticuloRepository;

public class ArticuloServiceTest {

	@Mock
	private IArticuloRepository repository;
	
	@InjectMocks
	private ArticuloServiceImpl service;
	
	private Articulo articulo;
	
	private ArticuloDto articuloDto;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		
		articulo = new Articulo();
		articulo.setIdArticulo(0);
		articulo.setNombreArticulo("Secador");
		articulo.setDescripcionArticulo("Secador de ultima generacion para un secado perfecto");
		
		articuloDto = new ArticuloDto();
		articuloDto.setIdArticulo(0);
		articuloDto.setNombreArticulo("Secador");
		articuloDto.setDescripcionArticulo("Secador de ultima generacion para un secado perfecto");
	}
	
	@Test
	void listar() {
		when(repository.findAll()).thenReturn(Arrays.asList(articulo));
		assertNotNull(service.listar());
	}
	
	@Test
	void insertarModificar() {
		when(repository.save(any())).thenReturn(articulo);
		service.insertarModificar(articuloDto);
		when(repository.findAll()).thenReturn(Arrays.asList(articulo));
		assertNotNull(service.listar());
	}
	
	@Test
	void borrar() {
		when(repository.save(any(Articulo.class))).thenReturn(articulo);
		service.insertarModificar(articuloDto);
		service.borrar(0);

	    assertThrows(IllegalArgumentException.class, () -> {
	    	service.listar();
	    });
	}
}
