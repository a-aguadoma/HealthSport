package com.example.AES.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AES.Deportista;

public interface DeportistaRepository extends JpaRepository<Deportista, Long> {
	
	List<Deportista> findByNombre(String nombre);
	Deportista getByNombre(String nombre);

}
