package com.example.AES.repositories;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AES.Deportista;
import com.example.AES.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

	@SuppressWarnings("unchecked")
	Entrenador save(Entrenador entrenador);
	
	@Cacheable
	Entrenador findByEmail(String email);
	
	Entrenador findByEmailAndPass(String email,String pass);
	
	List<Entrenador> findByNombre(String nombre);
	
	Entrenador getByNombre(String nombre);

}
