package com.prueba.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;

import com.prueba.dto.ArticuloDto;
import com.prueba.service.IArticuloService;

@SpringBootTest
public class ArticuloControllerTest {

	@Mock
	private IArticuloService service;
	
	@InjectMocks
	private ArticuloController controller;
	
	private ArticuloDto articuloDto;
	
	@BeforeEach
	void setUp() {
		articuloDto = new ArticuloDto();
		articuloDto.setIdArticulo(0);
		articuloDto.setNombreArticulo("Secador");
		articuloDto.setDescripcionArticulo("Secador de ultima generacion para un secado perfecto");
	}
	
	@Test
	void listar() {
		when(service.listar()).thenReturn(Arrays.asList(articuloDto));
		assertNotNull(controller.listar());
	}
	
	@Test
	void insertar() {
		assertNotNull(controller.insertar(articuloDto, mock(BindingResult.class)));
	}
	
	@Test
	void modificar() {
		assertNotNull(controller.modificar(articuloDto, mock(BindingResult.class)));
	}
	
	@Test
	void borrar() {
		controller.insertar(articuloDto, mock(BindingResult.class));
		assertNotNull(controller.borrar(0));
	}
}
