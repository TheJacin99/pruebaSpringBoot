package com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.entity.Articulo;

@Repository
public interface IArticuloRepository extends JpaRepository<Articulo, Integer> {
	
}
