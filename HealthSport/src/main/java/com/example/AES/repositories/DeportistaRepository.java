package com.example.AES.repositories;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AES.Deportista;

public interface DeportistaRepository extends JpaRepository<Deportista, Long> {
	
	
	@SuppressWarnings("unchecked")
	Deportista save(Deportista deportista);
	
	@Cacheable
	Deportista findByEmail(String email);
	
	
	List<Deportista> findByNombre(String nombre);
	Deportista getByNombre(String nombre);
	
	

}
