package com.example.AES.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AES.models.*;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


@CacheConfig(cacheNames="HealthSport")
public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	@SuppressWarnings("unchecked")
	@CacheEvict	(allEntries = true)
	Evento save(Evento evento);
	
	@Cacheable
	Evento findByNombre(String nombre);
	
	@Cacheable
	Evento findByDeporte(String deporte);
	
	@Cacheable
	Evento findByFecha(String fecha);
	
	@Cacheable
	Evento findByLugar(String lugar);

}
