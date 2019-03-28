package com.example.AES.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.example.AES.models.*;

@CacheConfig(cacheNames="HealthSport")
public interface EquipoRepository extends JpaRepository<Equipo, Long>{
	
	
	@SuppressWarnings("unchecked")
	@CacheEvict(allEntries = true)
	Equipo save(Equipo equipo);
	
	@Cacheable
	Equipo findByNombre(String nombre);
	
	@Cacheable
	Equipo findByClave(String claveEquipo);
	
	List<Deportista> findByDeportistas(String nombre);

}
