package com.example.AES.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.example.AES.models.*;

@CacheConfig(cacheNames="HealthSport")
public interface EquipoRepository extends JpaRepository<Equipo, Long>{
	
	
	@CachePut
	Equipo save(Equipo equipo);
	
	@CacheEvict
	Equipo findByNombre(String nombre);
	
	@Cacheable
	Equipo findByClave(String claveEquipo);
	
	@Cacheable
	List<Deportista> findByDeportistas(String nombre);

}
