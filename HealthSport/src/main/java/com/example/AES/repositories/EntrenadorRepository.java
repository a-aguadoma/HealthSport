package com.example.AES.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AES.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

	@SuppressWarnings("unchecked")
	Entrenador save(Entrenador entrenador);

}
