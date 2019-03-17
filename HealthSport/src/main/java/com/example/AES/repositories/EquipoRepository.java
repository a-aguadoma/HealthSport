package com.example.AES.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.example.AES.models.*;

public interface EquipoRepository extends CrudRepository<Equipo, Long>{
	
	
	@SuppressWarnings("unchecked")
	Equipo save(Equipo equipo);
	
	@Cacheable
	Equipo findByNombre(String nombre);
	
	Equipo findByClave(String claveEquipo);
	
	List<Deportista> findByDeportistas(String nombre);

}
