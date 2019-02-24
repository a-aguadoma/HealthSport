package com.example.AES.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.cache.annotation.Cacheable;

import com.example.AES.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long>{
	
	
	@SuppressWarnings("unchecked")
	Equipo save(Equipo equipo);
	
	@Cacheable
	Equipo findByNombre(String nombre);
	
	Equipo findByClave(String claveEquipo);

}
