package com.prueba.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.prueba.dto.ArticuloDto;
import com.prueba.entity.Articulo;
import com.prueba.repository.IArticuloRepository;

@Service
public class ArticuloServiceImpl implements IArticuloService {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticuloServiceImpl.class);
	
	@Autowired
	private IArticuloRepository repository;
	
	@Override
	@Cacheable("articulos")
	public List<ArticuloDto> listar() {
		List<Articulo> articulosRepo = this.repository.findAll();
		
		if (articulosRepo.isEmpty()) {
			throw new IllegalArgumentException("Actualmente no existen datos, inserte datos primero");
		}
		
		List<ArticuloDto> articulos = new ArrayList<>();
		
		articulosRepo.forEach(d -> {
			ArticuloDto dto = new ArticuloDto();
			dto.setIdArticulo(d.getIdArticulo());
			dto.setNombreArticulo(d.getNombreArticulo());
			dto.setDescripcionArticulo(d.getDescripcionArticulo());
			
			articulos.add(dto);
		});
		
		return articulos;
	}

	@Override
	@CacheEvict(value = "articulos", allEntries = true)
	public void insertarModificar(ArticuloDto dto) {
		Articulo articulo = new Articulo();
		articulo.setIdArticulo(dto.getIdArticulo());
		articulo.setNombreArticulo(dto.getNombreArticulo());
		articulo.setDescripcionArticulo(dto.getDescripcionArticulo());
		
		this.repository.save(articulo);
		logger.debug("Se ha insertado o modificado el siguiente articulo " + articulo);
	}

	@Override
	@CacheEvict(value = "articulos", allEntries = true)
	public void borrar(Integer id) {
		this.repository.deleteById(id);
		logger.debug("Se ha borrado el siguiente articulo con id " + id);
	}
	
}
