package com.example.AES.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AES.Deportista;
import com.example.AES.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long>{
	
	
	@SuppressWarnings("unchecked")
	Equipo save(Equipo equipo);
	
	Equipo findByNombre(String nombre);
	
	Equipo findByClave(String claveEquipo);

}
